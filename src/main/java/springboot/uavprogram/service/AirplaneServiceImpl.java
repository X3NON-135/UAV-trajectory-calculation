package springboot.uavprogram.service;

import java.util.List;
import org.springframework.stereotype.Service;
import springboot.uavprogram.model.Airplane;
import springboot.uavprogram.repository.AirplaneRepository;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private AirplaneRepository airplaneRepository;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

}
