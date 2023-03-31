package com.example.lab2;

import java.util.ArrayList;
import java.util.List;

public class CarPicker {
    List<String> getCars(String s) {
        List<String> models = new ArrayList<String>();
        switch (s) {
            case "Tomota":
                models.add("Kauris");
                models.add("Yamis");
                models.add("Gav14");
                break;
            case "WW":
                models.add("Molf");
                models.add("Solo");
                break;
            default:
                break;
        }
        return models;
    }
}
