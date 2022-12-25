package springboot.uavprogram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("airplane_characteristics")
public class AirplaneCharacteristics {
    private double maxSpeed;
    private double acceleration;
    private double heightSpeed;
    private double bearing;
}
