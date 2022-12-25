package springboot.uavprogram.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("flights")
public class Flight {
    @Id
    private Long number;
    private List<WayPoint> destinationPoints;
    private List<TemporaryPoint> passedPoints;
}
