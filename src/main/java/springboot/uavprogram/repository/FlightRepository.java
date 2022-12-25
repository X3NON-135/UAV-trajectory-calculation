package springboot.uavprogram.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import springboot.uavprogram.model.Flight;

public interface FlightRepository extends MongoRepository<Flight, Long> {
    @Query(value = "{_id : ?0}")
    List<Flight> getFlightsByAirplaneId(Long ig);
}
