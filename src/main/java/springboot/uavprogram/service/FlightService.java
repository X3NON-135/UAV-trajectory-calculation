package springboot.uavprogram.service;

import java.util.List;
import springboot.uavprogram.model.Flight;

public interface FlightService {
    Flight save(Flight flight);

    List<Flight> getFlightsByAirplaneId(Long id);
}
