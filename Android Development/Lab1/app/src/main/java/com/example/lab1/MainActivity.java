package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String toast;
    private int counter;
    private TextView counterView;
    private Intent i;
    private int defaultNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast = "Add number with Count button";
        counter = 0;
        counterView = findViewById(R.id.counterView);
        i = getIntent();
        defaultNum = i.getIntExtra("counter", 0);
        counterView.setText(Integer.toString(defaultNum));
    }

    public void CounterIncrement(View view) {
        counter++;
        counterView.setText(Integer.toString(counter));
    }

    public void PrintToast(View view) {
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }

    public void ShowRandom(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("counter", counter);
        startActivity(intent);
    }
}