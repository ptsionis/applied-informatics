package com.example.lab0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myBtn = findViewById(R.id.myBtn);
        myBtn.setOnClickListener(view -> {
            EditText myTextField = findViewById(R.id.myTextField);
            TextView myTextView = findViewById(R.id.myTextView);
            myTextView.setText("Hello, " + myTextField.getText());
        });
    }
}