package com.example.noor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.noor.R;

public class AllCategories extends AppCompatActivity {
    ImageView back,move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        back=findViewById(R.id.back_main);
        move=findViewById(R.id.bar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(AllCategories.this,Home_page.class);
                startActivity(in);
            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(AllCategories.this,Collection.class);
                startActivity(in);
            }
        });

    }
}