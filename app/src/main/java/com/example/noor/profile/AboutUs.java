package com.example.noor.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.noor.R;

public class AboutUs extends AppCompatActivity {

    ImageView back_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        back_about=findViewById(R.id.back_about_profile);
        back_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(AboutUs.this,MainProfile.class);
                startActivity(in);
            }
        });
    }
}