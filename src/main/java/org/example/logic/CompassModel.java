package org.example.logic;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CompassModel {
    private static final CompassModel instance = new CompassModel();
    private final Map<String, String> model;

    public CompassModel() {
        model = new HashMap<String, String>();
    }
    public static CompassModel getInstance() {
        return instance;
    }
    public void addWorldSide(String degrees, String name) {
        model.put(degrees, name);
    }
    public String determineWorldSide(Integer degrees) {
        for (Map.Entry<String, String> entry: model.entrySet()) {
            int first = Integer.parseInt(entry.getKey().split("-")[0]);
            int second = Integer.parseInt(entry.getKey().split("-")[1]);
            if (first < second) {
                if (first <= degrees && degrees <= second)
                    return entry.getValue();
            }
            else {
                if (first <= degrees || degrees <= second)
                    return entry.getValue();
            }
        }
        return "Данные некорректны!";
    }
}
