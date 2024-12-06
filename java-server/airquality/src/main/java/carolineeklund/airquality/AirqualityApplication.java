package carolineeklund.airquality;

import carolineeklund.airquality.model.PredictionRecord;
import carolineeklund.airquality.service.PredictionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class AirqualityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirqualityApplication.class, args);

//        try {
//            ApplicationContext context = SpringApplication.run(AirqualityApplication.class, args);
//            PredictionService predictionService = context.getBean(PredictionService.class);
//            HttpClient client = HttpClient.newHttpClient();
//            Scanner scan = new Scanner(System.in);
//
//            System.out.println("Enter the value of the feature: ");
//            int feature = scan.nextInt();
//            int feature2 = scan.nextInt();
//
//            int [] featuresInt = {feature, feature2};
//
//            JSONObject jsonData = new JSONObject();
//            jsonData.put("features", featuresInt);
//            System.out.println("JsonData: " + jsonData);
//
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("http://127.0.0.1:5000/predict"))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(jsonData.toString()))
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            System.out.println("Response Code: " + response.statusCode());
//            System.out.println("Response Body: " + response.body());
//
//            JSONObject jsonResponse = new JSONObject(response.body());
//            int prediction = jsonResponse.getJSONArray("prediction").getInt(0);
//            System.out.println("prediction" + prediction);
//
////            PredictionRecord newPredictionRecord = new PredictionRecord(featuresInt, prediction);
////            predictionService.createPredictionRecord(newPredictionRecord);
//
//
//            //spara ut bara siffran och skapa en ny PredictionRecord.
//            //dela upp i klasser?
//            //lägg till frontend så är nästan klar :)
//            //spara varje predictionRecord
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

}
