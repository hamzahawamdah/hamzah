package com.example.noor.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.noor.R;

public class OfferHistory extends AppCompatActivity {

    ImageView back_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_history);

        back_profile=findViewById(R.id.back_offer_profile);
        back_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(OfferHistory.this,MainProfile.class);
                startActivity(in);
            }
        });

    }
}