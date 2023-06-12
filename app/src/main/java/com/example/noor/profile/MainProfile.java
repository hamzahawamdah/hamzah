package com.example.noor.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noor.R;
import com.example.noor.activity.Login;

public class MainProfile extends AppCompatActivity {

    ImageView offer_history, about_us, terms, sign_out,profile;
    TextView language;
    SwitchCompat notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);

        offer_history = findViewById(R.id.move_offer_history);
        about_us = findViewById(R.id.move_about_us);
        terms = findViewById(R.id.move_terms);
        sign_out = findViewById(R.id.signout);
        profile=findViewById(R.id.move_profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(MainProfile.this,ProfileInfo.class);
                startActivity(in);
            }
        });

        offer_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(MainProfile.this,OfferHistory.class);
                startActivity(in);
            }
        });

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainProfile.this,AboutUs.class);
                startActivity(in);
            }
        });

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainProfile.this,Terms.class);
                startActivity(in);
            }
        });

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainProfile.this, Login.class);
                startActivity(in);
            }
        });


    }
}