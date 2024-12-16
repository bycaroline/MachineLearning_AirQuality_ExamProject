package carolineeklund.airquality.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pm10")
public class PredictionRecord {

    @Id
    private String id;

    private int [] features;

    private int prediction;

    public PredictionRecord(int[] featuresInt, int prediction) {
        this.features = features;
        this.prediction = prediction;
    }
}
