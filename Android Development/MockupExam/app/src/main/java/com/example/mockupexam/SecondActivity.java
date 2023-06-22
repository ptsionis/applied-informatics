package com.example.mockupexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    TextView animalInfo;
    ImageView animalImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String type = intent.getStringExtra("type");
        String image = intent.getStringExtra("image");
        String voice = intent.getStringExtra("voice");

        animalInfo = findViewById(R.id.animalInfo);
        animalInfo.setText("I am " + name + ", a " + type + " and I say " + voice);

        animalImage = findViewById(R.id.animalImage);
        animalImage.setVisibility(View.VISIBLE);
        Picasso.with(getApplicationContext()).load(Uri.parse(image)).into(animalImage);
    }
}