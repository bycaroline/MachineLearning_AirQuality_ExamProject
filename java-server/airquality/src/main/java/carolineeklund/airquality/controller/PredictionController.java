package carolineeklund.airquality.controller;

import carolineeklund.airquality.service.PredictionService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }


    @PostMapping("/predictlillaessingen")
    public Integer getPredictionLillaEssingen(@RequestBody Map<String, int[]> request) {
        int[] features = request.get("features");
        return predictionService.getPredictionLillaEssingen(features);
    }

    @PostMapping("/predicthornsg")
    public Integer getPredictionHornsg(@RequestBody Map<String, int[]> request) {
        int[] features = request.get("features");
        return predictionService.getPredictionHornsg(features);
    }

    @PostMapping("/predictsteriks")
    public Integer getPredictionStEriks(@RequestBody Map<String, int[]> request) {
        int[] features = request.get("features");
        return predictionService.getPredictionStEriks(features);
    }

    @PostMapping("/predictsveav")
    public Integer getPredictionSveav(@RequestBody Map<String, int[]> request) {
        int[] features = request.get("features");
        return predictionService.getPredictionSveav(features);
    }

    @PostMapping("/predicttorkel")
    public Integer getPredictionTorkel(@RequestBody Map<String, int[]> request) {
        int[] features = request.get("features");
        return predictionService.getPredictionTorkel(features);
    }
}


