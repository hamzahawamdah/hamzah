package com.example.noor.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;

import com.example.noor.R;
import com.example.noor.api.RetrofitClint;
import com.example.noor.api.Api;
import com.example.noor.model.UserModel;
import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

public class Login extends AppCompatActivity {

    Button login;
    TextView tv;

    CountryCodePicker code;

    TextInputEditText phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        login = findViewById(R.id.login);
        tv = findViewById(R.id.Rigister);

        phone = findViewById(R.id.phone_edit);
        password = findViewById(R.id.password_edit);

        code = findViewById(R.id.countyCodePicker);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, SignUp.class);
                startActivity(in);
            }
        });

    }


    public void login() {
        ProgressDialog pd = new ProgressDialog(this);
        pd.show();
        Api service = RetrofitClint.getApiService();

        RequestBody phoneRequestBody = RequestBody.create(MediaType.parse("text/plain"), phone.getText().toString());
        RequestBody passwordRequestBody = RequestBody.create(MediaType.parse("text/plain"), password.getText().toString());
        RequestBody conCodeRequestBody = RequestBody.create(MediaType.parse("text/plain"), code.getSelectedCountryCode());
        Call<UserModel> retCall = service.login(phoneRequestBody, passwordRequestBody, conCodeRequestBody);
        retCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                pd.dismiss();
                if (response.body().isResult()) {
                    Intent in2 = new Intent(Login.this, Home_page.class);
                    startActivity(in2);
                } else {
                    Toast.makeText(Login.this, response.body().getMsg(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                pd.dismiss();
            }
        });

    }


}