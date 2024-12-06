package carolineeklund.airquality.service;

import carolineeklund.airquality.AirqualityApplication;
import carolineeklund.airquality.model.PredictionRecord;
import carolineeklund.airquality.repository.PredictionRepository;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

@Service
public class PredictionService {

//    private final PredictionRepository predictionRepository;
//
//    public PredictionService(PredictionRepository predictionRepository) {
//        this.predictionRepository = predictionRepository;
//    }

//    public PredictionRecord createPredictionRecord(PredictionRecord predictionRecord) {
//        return predictionRepository.save(predictionRecord);
//    }

    public Integer getPrediction (int[] featuresInt){
        try {
//            ApplicationContext context = SpringApplication.run(AirqualityApplication.class, args);
//            PredictionService predictionService = context.getBean(PredictionService.class);
            HttpClient client = HttpClient.newHttpClient();
//            Scanner scan = new Scanner(System.in);

//            System.out.println("Enter the value of the feature: ");
//            int feature = scan.nextInt();
//            int feature2 = scan.nextInt();

//            int [] featuresInt = {feature, feature2};

            JSONObject jsonData = new JSONObject();
            jsonData.put("features", featuresInt);
            System.out.println("JsonData: " + jsonData);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:5000/predict"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            JSONObject jsonResponse = new JSONObject(response.body());
            int prediction = jsonResponse.getJSONArray("prediction").getInt(0);
            System.out.println("prediction" + prediction);
            return prediction;
        } catch(Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }


}
