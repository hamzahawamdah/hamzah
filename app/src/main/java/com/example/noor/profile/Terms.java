package com.example.noor.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.noor.R;

public class Terms extends AppCompatActivity {

    ImageView back_terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        back_terms=findViewById(R.id.back_terms_profile);
        back_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Terms.this,MainProfile.class);
                startActivity(in);
            }
        });
    }
}