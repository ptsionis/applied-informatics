package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private int counter;
    private TextView randomHeader;
    private TextView randomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        counter = intent.getIntExtra("counter", 0);
        randomHeader = findViewById(R.id.randomHeader);
        randomHeader.append(" " + Integer.toString(counter));
        randomView = findViewById(R.id.randomView);
        randomView.setText(Integer.toString(new Random().nextInt(counter+1)));
    }

    public void PreviousActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("counter", 0);
        startActivity(intent);
    }
}