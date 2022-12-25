package springboot.uavprogram.service;

import java.util.List;
import springboot.uavprogram.model.AirplaneCharacteristics;
import springboot.uavprogram.model.TemporaryPoint;
import springboot.uavprogram.model.WayPoint;

public interface RouteService {
    List<TemporaryPoint> calculateRoute(AirplaneCharacteristics characteristics,
                                        List<WayPoint> wayPoints);
}
