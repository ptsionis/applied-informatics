package com.example.carpicker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private CarBrandList cbl;
    private RadioGroup rg;

    private final String myIP = "192.168.1.2";

    public void PickCarOnClick(View v) {
        Spinner dropDown = (Spinner) findViewById(R.id.cars);
        String brand = String.valueOf(dropDown.getSelectedItem());
        List<String> allModels = cbl.getAllModels(brand);

        rg.removeAllViews();

        for(int i=0;i<allModels.size();i++) {
            RadioButton rb = new RadioButton(this);
            rb.setText(allModels.get(i));
            rb.setId(100+i);
            rg.addView(rb);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                String url= "http://"+myIP+"/carsDBServices/logHistory.php?brand=" + brand +
                        "&model=" + rb.getText().toString() + "&timestamp=" + new
                        Date(System.currentTimeMillis()).toString();
                try {
                    OkHttpHandler okHttpHandler = new OkHttpHandler();
                    okHttpHandler.logHistory(url);
                    Toast.makeText(getApplicationContext(), "Selection Logged",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cbl = new CarBrandList(myIP);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner dropDown = (Spinner) findViewById(R.id.cars);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        cbl.getAllBrands());
        dropDown.setAdapter(arrayAdapter);

        rg = (RadioGroup) findViewById(R.id.rg);
    }
}