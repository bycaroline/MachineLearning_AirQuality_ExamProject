package carolineeklund.airquality.controller;


import carolineeklund.airquality.service.PredictionService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@RestController
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

//@GetMapping("/predict")
//public JSONObject getPrediction (@RequestBody int[] features ){
//    System.out.println("get startar sen blir fel");
//
//    return predictionService.getPrediction(features);
//    //den här lyssnar på service som hämtar Integer
//    //lägg http från main till service?
//    //den här get läggs i react?
//    //ändra till responseEntity?
//    // men först testa med att bara ha så här och se om det funkar
//}

    @GetMapping("/predict")
    public Integer getPrediction(@RequestBody Map<String, int[]> request) {
        int[] features = request.get("features");
        return predictionService.getPrediction(features);
    }


//    @PostMapping("/predict")
//    public List<Integer> predict(@RequestBody Map<String, List<Integer>> request) {
//        String url = "http://127.0.0.1:5000/predict";
//        System.out.println("predict");
//
//        // Print the incoming request
//        System.out.println("The request is: " + request);
//
//        // Use WebClient to make the POST request
//        Map<String, Object> response = webClientBuilder.build()
//                .post()
//                .uri(url)
//                .bodyValue(request)
//                .retrieve()
//                .bodyToMono(Map.class)
//                .block(); // Blocking to get the response synchronously (you can also use reactive approach)
//
//        // Check if the response contains the "prediction" key
//        if (response != null && response.containsKey("prediction")) {
//            // Extract the prediction list from the response
//            List<Integer> prediction = (List<Integer>) response.get("prediction");
//
//            // Print out the prediction
//            System.out.println("The response is: " + prediction);
//            return prediction;
//        } else {
//            // Handle the case where the response does not contain the expected key
//            System.out.println("Response does not contain 'prediction' key.");
//            return List.of(); // Return an empty list if prediction key is not found
//        }
//    }


}
