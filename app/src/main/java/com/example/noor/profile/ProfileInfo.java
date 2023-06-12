package com.example.noor.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noor.R;
import com.example.noor.activity.Login;
import com.example.noor.activity.SignUp;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;


public class ProfileInfo extends AppCompatActivity {

    TextView birthday, password, name, gender;
    Button cancel,save;
    ImageView back_profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);

        birthday = findViewById(R.id.change_birthday);
        password = findViewById(R.id.change_password);
        name = findViewById(R.id.change_name);
        gender = findViewById(R.id.change_gender);
        back_profile=findViewById(R.id.back_profile_main_profile);


        cancel=findViewById(R.id.cancel);
        save=findViewById(R.id.save);


        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });


        back_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ProfileInfo.this,MainProfile.class);
                startActivity(in);
            }
        });
    }

    private void showBottomSheetDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottomsheet_name);
        bottomSheetDialog.show();
    }
}