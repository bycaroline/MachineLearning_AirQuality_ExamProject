package carolineeklund.airquality.repository;

import carolineeklund.airquality.model.PredictionRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionRepository extends MongoRepository<PredictionRecord, String> {
}
