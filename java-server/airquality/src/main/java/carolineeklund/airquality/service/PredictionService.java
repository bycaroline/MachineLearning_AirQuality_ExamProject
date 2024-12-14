package carolineeklund.airquality.service;

import carolineeklund.airquality.AirqualityApplication;
import carolineeklund.airquality.model.PredictionRecord;
import carolineeklund.airquality.repository.PredictionRepository;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
package carolineeklund.airquality.service;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PredictionService {


    public Integer getPrediction (int[] featuresInt, String endpoint) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            JSONObject jsonData = new JSONObject();
            jsonData.put("features", featuresInt);
            System.out.println("JsonData: " + jsonData);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonData.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            JSONObject jsonResponse = new JSONObject(response.body());
            int prediction = jsonResponse.getJSONArray("categorized_prediction").getInt(0);
            System.out.println("categorized_prediction" + prediction);
            return prediction;
        } catch(Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }

    public Integer getPredictionLillaEssingen (int[] featuresInt){
        String endpoint = "http://127.0.0.1:5000/predictlillaessingen";
        return getPrediction(featuresInt, endpoint);
    }

    public Integer getPredictionHornsg (int[] featuresInt){
        String endpoint = "http://127.0.0.1:5000/predicthornsg";
        return getPrediction(featuresInt, endpoint);
    }

    public Integer getPredictionStEriks (int[] featuresInt){
        String endpoint = "http://127.0.0.1:5000/predictsteriks";
        return getPrediction(featuresInt, endpoint);
    }

    public Integer getPredictionSveav (int[] featuresInt){
        String endpoint = "http://127.0.0.1:5000/predictsveav";
        return getPrediction(featuresInt, endpoint);
    }

    public Integer getPredictionTorkel (int[] featuresInt){
        String endpoint = "http://127.0.0.1:5000/predicttorkel";
        return getPrediction(featuresInt, endpoint);
    }
}

