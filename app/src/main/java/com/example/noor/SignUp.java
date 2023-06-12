package com.example.noor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    Button btn;
    CheckBox ch;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn = findViewById(R.id.continue_btn);
        ch = findViewById(R.id.check);
        tv = findViewById(R.id.login_sginup);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch.isChecked()) {
                    Toast.makeText(SignUp.this, "SginUp Done", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(SignUp.this, Home.class);
                    startActivity(in);
                }
            }
        });


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SignUp.this, Home.class);
                startActivity(in);
            }
        });


    }
}