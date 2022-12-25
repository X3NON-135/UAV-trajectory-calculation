package springboot.uavprogram.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import springboot.uavprogram.model.Airplane;
import springboot.uavprogram.model.AirplaneCharacteristics;
import springboot.uavprogram.model.TemporaryPoint;
import springboot.uavprogram.model.WayPoint;

@Log4j2
@Service
public class RouteServiceImpl implements RouteService {
    private AirplaneService airplaneService;

    public RouteServiceImpl(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @Override
    public List<TemporaryPoint> calculateRoute(AirplaneCharacteristics characteristics,
                                               List<WayPoint> wayPoints) {
        double passedDistance = Math.pow(characteristics.getMaxSpeed(), 2)
                / characteristics.getAcceleration();
        List<TemporaryPoint> points = new ArrayList<>();
        double startLat = wayPoints.get(0).getLatitude();
        double startLon = wayPoints.get(0).getLongitude();
        for (int i = 1; i < wayPoints.size(); i++) {
            double currentLat = wayPoints.get(i).getLatitude();
            double currentLon = wayPoints.get(i).getLongitude();
            GeodesicData g1 = Geodesic.WGS84.Inverse(startLat, startLon, currentLat, currentLon);
            GeodesicData g2 = Geodesic.WGS84.Direct(g1.lat1, g1.lon1,
                    g1.azi1, passedDistance);
            TemporaryPoint temporaryPoint = new TemporaryPoint(g2.lat2, g2.lon2,
                    wayPoints.get(i).getAltitude(), wayPoints.get(i).getSpeed(), g2.azi1);
            points.add(temporaryPoint);
            if (wayPoints.size() > 1) {
                startLat = points.get(i - 1).getLatitude();
                startLon = points.get(i - 1).getLongitude();
            }
        }
        return points;
    }

    @PostConstruct
    @Scheduled(cron = "*/5 * * * * ?")
    private void getCurrentPosition() {
        log.info("airplanes {} positions {}", airplaneService.findAll().stream()
                        .map(Airplane::getId)
                .findAny().get(),
                airplaneService.findAll().stream()
                        .map(Airplane::getPosition).findAny().get());
    }
}
