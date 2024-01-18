package org.example.controller;

import org.example.logic.CompassModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    private static final CompassModel compassModel = CompassModel.getInstance();
    @PostMapping(value = "/createSides", consumes = "application/json", produces = "application/json")
    public String createPet(@RequestBody Map<String, String> map) {
        for (Map.Entry<String, String> entry: map.entrySet()) {
            compassModel.addWorldSide(entry.getValue(), entry.getKey());
        }
        return "Вы успешно установили стороны света!!!";
    }
//    {
//        "South": "157-202",
//            "SouthWest": "203-247",
//            "West": "248-292",
//            "NorthWest": "293-337",
//            "North": "338-22",
//            "NorthEast": "23-67",
//            "East": "68-112",
//            "SouthEast": "113-156"
//    }
    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public Map<String, String> getAll(@RequestBody Map<String, String> degree) {
        Map<String, String> answer = new HashMap<>();
        answer.put("Side", compassModel.determineWorldSide(Integer.parseInt(degree.get("Degree"))));
        return answer;
    }
//    {
//        "Degree": 0
//    }

}
