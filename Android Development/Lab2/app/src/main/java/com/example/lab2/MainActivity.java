package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CarPicker cp = new CarPicker();
    private CarBrandsList cbList;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbList = new CarBrandsList();
        cbList.addBrand(new Brand(getString(R.string.Tomota)));
        cbList.addBrand(new Brand(getString(R.string.WW)));
        cbList.addBrand(new Brand(getString(R.string.Fissan)));
        cbList.addModel(getString(R.string.Tomota), "Kauris");
        cbList.addModel(getString(R.string.Tomota), "Yamis");
        cbList.addModel(getString(R.string.Tomota), "Gav14");
        cbList.addModel(getString(R.string.WW), "Molf");
        cbList.addModel(getString(R.string.WW), "Solo");
        rg = findViewById(R.id.car_radio);
    }

    public void onClickPickBrand(View view) {
        Spinner dropDown = findViewById(R.id.carsList);
        String brand = String.valueOf(dropDown.getSelectedItem());
        List<String> brandsList = cbList.getCars(brand);
        rg.removeAllViews();
        if(brandsList.size() == 0){
            Toast.makeText(getApplicationContext(), getString(R.string.toast_no_cars, brand),
                    Toast.LENGTH_SHORT).show();
        } else{
            rg.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
            createRadioButtons(rg, brandsList);
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton rb= findViewById(checkedId);
                    Toast.makeText(getApplicationContext(), brand+" "+rb.getText(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void createRadioButtons(RadioGroup rg, List<String> brandsList) {
        int size = brandsList.size();
        final RadioButton[] rb = new RadioButton[size];
        for(int i=0; i<size; i++){
            rb[i] = new RadioButton(this);
            rb[i].setText(" " + brandsList.get(i));
            rb[i].setId(i + 100);
            rg.addView(rb[i]);
        }
    }
}