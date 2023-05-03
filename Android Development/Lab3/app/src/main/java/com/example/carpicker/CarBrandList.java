package com.example.carpicker;

import android.content.res.AssetManager;
import java.io.InputStream;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class CarBrandList {
    ArrayList<CarBrand> cbList = new ArrayList<CarBrand>();

    public CarBrandList(String ip) {
        String url= "http://"+ip+"/carsDBServices/populateDropDown.php";
        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            cbList = okHttpHandler.populateDropDown(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCarBrand(CarBrand b) {
        cbList.add(b);
    }

/*    public void addModel(String b, String m) {
        for (int i=0; i<cbList.size(); i++) {
            if (cbList.get(i).hasName(b)) {
                cbList.get(i).addModel(m);
            }
        }
    }*/

    public String getAllModelsAsString(String b) {
        String s = "";
        for (int i=0; i<cbList.size(); i++) {
            if (cbList.get(i).hasName(b)) {
                s = cbList.get(i).getAllModelsAsString();
            }
        }
        return s;
    }

    public List<String> getAllBrands() {
        List<String> temp = new ArrayList<String>();
        for (int i=0; i<cbList.size(); i++) {
            temp.add(cbList.get(i).getName());
        }
        return temp;
    }

    public List<String> getAllModels(String b) {
        List<String> temp = new ArrayList<String>();
        for (int i=0; i<cbList.size(); i++) {
            if (cbList.get(i).hasName(b)) {
                temp = cbList.get(i).getAllModels();
            }
        }
        return temp;
    }
}
