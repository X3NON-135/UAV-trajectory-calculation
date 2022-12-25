package springboot.uavprogram.service;

import java.util.List;
import springboot.uavprogram.model.Airplane;

public interface AirplaneService {
    Airplane save(Airplane airplane);

    List<Airplane> findAll();
}
