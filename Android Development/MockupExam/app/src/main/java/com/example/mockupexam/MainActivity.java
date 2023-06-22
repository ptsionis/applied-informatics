package com.example.mockupexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String ip = "192.168.1.2";

    RadioGroup rg;
    Button nextBtn;

    AnimalList animalsList = new AnimalList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rgNames);
        nextBtn = findViewById(R.id.nextBtn);

        try {
            ArrayList<Animal> allAnimals = new ArrayList<>();
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            allAnimals = okHttpHandler.getAllAnimals(ip);
            ArrayList<String> allAnimalsName = new ArrayList<>();
            for (Animal a : allAnimals) {
                animalsList.addAnimal(a);
                allAnimalsName.add(a.getName());
            }
            createRadioButtons(rg, allAnimalsName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        nextBtn.setOnClickListener(v -> {
            int selectedRadioButtonId = rg.getCheckedRadioButtonId();
            String rbText;

            if (selectedRadioButtonId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                rbText = selectedRadioButton.getText().toString();
                Animal selectedAnimal = animalsList.getAnimal(rbText);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", selectedAnimal.getName());
                intent.putExtra("type", selectedAnimal.getType());
                intent.putExtra("image", selectedAnimal.getImage());
                intent.putExtra("voice", selectedAnimal.getVoice());

                startActivity(intent);
            }
        });
    }

    public void createRadioButtons(RadioGroup rGroup, ArrayList<String> list) {
        int size = list.size();
        final RadioButton[] rb = new RadioButton[size];

        for (int i = 0; i < size; i++) {
            rb[i] = new RadioButton(this);
            rb[i].setText(list.get(i));
            rb[i].setId(i + 100);
            rGroup.addView(rb[i]);
        }
    }
}