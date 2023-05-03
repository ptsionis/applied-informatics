package com.example.carpicker;

import java.util.*;

public class CarBrand {
    private String name;
    private List<String> models = new ArrayList<String>();
    
    public CarBrand(String b, String m) {
        name = b;
        models = Arrays.asList(m.split(","));
    }

    public boolean hasName(String b) {
        return name.equals(b);
    }

    public String getAllModelsAsString() {
        return models.toString();
    }

    public String getName() {return name; }
    public List<String> getAllModels() {return models;}
}
