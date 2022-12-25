package springboot.uavprogram;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springboot.uavprogram.model.Airplane;
import springboot.uavprogram.model.AirplaneCharacteristics;
import springboot.uavprogram.model.Flight;
import springboot.uavprogram.model.TemporaryPoint;
import springboot.uavprogram.model.WayPoint;
import springboot.uavprogram.service.AirplaneService;
import springboot.uavprogram.service.FlightService;
import springboot.uavprogram.service.RouteService;

@SpringBootApplication
@EnableScheduling
public class UavProgramApplication implements CommandLineRunner {

    private RouteService routeService;
    private AirplaneService airplaneService;
    private FlightService flightService;

    public UavProgramApplication(RouteService routeService,
                                 AirplaneService airplaneService,
                                 FlightService flightService) {
        this.routeService = routeService;
        this.airplaneService = airplaneService;
        this.flightService = flightService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UavProgramApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AirplaneCharacteristics characteristics = new AirplaneCharacteristics();
        characteristics.setMaxSpeed(50);
        characteristics.setAcceleration(1);
        characteristics.setHeightSpeed(10);
        characteristics.setBearing(119.633888888889);

        TemporaryPoint temporaryPoint = new TemporaryPoint();
        temporaryPoint.setLatitude(57.325195);
        temporaryPoint.setLongitude(25.630293);
        temporaryPoint.setAltitude(20);
        temporaryPoint.setSpeed(characteristics.getMaxSpeed());
        temporaryPoint.setBearing(characteristics.getBearing());

        Airplane airplane1 = new Airplane();
        airplane1.setId(1L);
        airplane1.setCharacteristics(characteristics);
        airplane1.setPosition(temporaryPoint);

        List<WayPoint> wayPoints = List.of(
                new WayPoint(57.324262, 25.628122, 20, 10),
                new WayPoint(57.325206, 25.630279, 20, 10),
                new WayPoint(57.323967, 25.630000, 20, 10),
                new WayPoint(57.324575, 25.632274, 20, 10));

        /*PRINTING AIRPLANE'S FLIGHTS BEFORE STARTING*/
        flightService.getFlightsByAirplaneId(airplane1.getId()).forEach(System.out::println);

        List<TemporaryPoint> points = routeService.calculateRoute(airplane1.getCharacteristics(),
                wayPoints);

        Flight airplane1Flights = new Flight();
        airplane1Flights.setNumber(1L);
        airplane1Flights.setDestinationPoints(wayPoints);
        airplane1Flights.setPassedPoints(points);
        flightService.save(airplane1Flights);

        airplane1.setFlights(List.of(airplane1Flights));
        airplane1.setPosition(points.get(points.size() - 1));
        airplaneService.save(airplane1);
        System.out.println(points);
    }
}
