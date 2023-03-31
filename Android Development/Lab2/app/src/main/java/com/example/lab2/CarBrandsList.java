package com.example.lab2;

import java.util.ArrayList;
import java.util.List;

public class CarBrandsList {
    ArrayList<Brand> bList = new ArrayList<Brand>();
    public CarBrandsList() {
    }
    public void addModel(String brand, String model) {
        for (int i=0; i<bList.size(); i++) {
            if (bList.get(i).isBrand(brand)) {
                bList.get(i).addModel(model);
            }
        }
    }
    public List<String> getCars(String brand) {
        for (int i=0; i<bList.size(); i++) {
            if (bList.get(i).isBrand(brand)) {
                return bList.get(i).getModels();
            }
        }
        return null;
    }
    public void addBrand(Brand b) {
        bList.add(b);
    }
}
