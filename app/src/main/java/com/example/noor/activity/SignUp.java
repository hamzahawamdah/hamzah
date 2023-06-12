package com.example.noor.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.noor.R;
import com.example.noor.api.RetrofitClint;
import com.example.noor.api.Api;
import com.example.noor.model.UserModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

import retrofit2.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    Button btn, btn2;
    CheckBox ch;
    TextView tv;
    TextInputEditText name, pass, email, phoneS;
    CountryCodePicker concode;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        btn = findViewById(R.id.continue_btn);
        ch = findViewById(R.id.check);
        tv = findViewById(R.id.login_sginup);

        phoneS = findViewById(R.id.phone_edit);
        name = findViewById(R.id.fullname_edit);
        pass = findViewById(R.id.password_edit);
        email = findViewById(R.id.email_edit);

        concode = findViewById(R.id.countyCodePickerS);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ch.isChecked()) {
                    signUp();
                    showBottomSheetDialog();
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SignUp.this, Login.class);
                startActivity(in);
            }
        });
    }
    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottomsheet);
        btn2 = bottomSheetDialog.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
        bottomSheetDialog.show();
    }
    public void signUp() {
        ProgressDialog pd = new ProgressDialog(this);
        pd.show();
        Api service = RetrofitClint.getApiService();

        RequestBody nameRequestBody = RequestBody.create(MediaType.parse("text/plain"), name.getText().toString());
        RequestBody phoneRequestBody = RequestBody.create(MediaType.parse("text/plain"), phoneS.getText().toString());
        RequestBody passwordRequestBody = RequestBody.create(MediaType.parse("text/plain"), pass.getText().toString());
        RequestBody conCodeRequestBody = RequestBody.create(MediaType.parse("text/plain"), concode.getSelectedCountryCode());
        RequestBody emailRequestBody = RequestBody.create(MediaType.parse("text/plain"), email.getText().toString());

        Call<UserModel> retCall = service.signUp(nameRequestBody, phoneRequestBody, conCodeRequestBody, emailRequestBody, passwordRequestBody);

        retCall.enqueue(new Callback<UserModel>() {
            @Override

            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                pd.dismiss();

                if (response.body().isResult()) {
                    Toast.makeText(SignUp.this, "Done", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(SignUp.this, response.body().getMsg(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                pd.dismiss();
            }
        });

    }


}