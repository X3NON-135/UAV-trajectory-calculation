package springboot.uavprogram.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import springboot.uavprogram.model.Airplane;

public interface AirplaneRepository extends MongoRepository<Airplane, Long> {
}
