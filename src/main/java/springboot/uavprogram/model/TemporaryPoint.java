package springboot.uavprogram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("temporary_points")
public class TemporaryPoint {
    private double latitude;
    private double longitude;
    private double altitude;
    private double speed;
    private double bearing;
}
