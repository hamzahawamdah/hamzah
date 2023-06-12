package com.example.noor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.noor.R;
import com.example.noor.location.Location;

public class Collection extends AppCompatActivity {

    ImageView back_cat, loc;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        back_cat = findViewById(R.id.back_Categories);
        back_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Collection.this, AllCategories.class);
                startActivity(in);
            }
        });

        loc = findViewById(R.id.location);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Collection.this, Location.class);
                startActivity(in);
            }
        });


    }
}