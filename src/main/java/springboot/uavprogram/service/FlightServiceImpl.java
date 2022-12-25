package springboot.uavprogram.service;

import java.util.List;
import org.springframework.stereotype.Service;
import springboot.uavprogram.model.Flight;
import springboot.uavprogram.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getFlightsByAirplaneId(Long id) {
        return flightRepository.getFlightsByAirplaneId(id);
    }
}
