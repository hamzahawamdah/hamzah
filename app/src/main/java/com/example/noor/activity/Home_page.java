package com.example.noor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.example.noor.R;
import com.example.noor.adapter.RecycleAdapter;
import com.example.noor.adapter.RecycleAdapter2;
import com.example.noor.api.Api;
import com.example.noor.api.RetrofitClint;
import com.example.noor.model.BannerModel;
import com.example.noor.model.CatModel;
import com.example.noor.profile.MainProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_page extends AppCompatActivity {

    RecyclerView recyclerview, recyclerview2;
    TextView s_all;

    ImageView account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        s_all = findViewById(R.id.see_all);
        account = findViewById(R.id.account);

        recyclerview = findViewById(R.id.review);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        getBanner();

        recyclerview2 = findViewById(R.id.review2);
        recyclerview2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        getCat();

        s_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in3 = new Intent(Home_page.this, AllCategories.class);
                startActivity(in3);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Home_page.this, MainProfile.class);
                startActivity(in);
            }
        });
    }

    public void getBanner() {

        Api service = RetrofitClint.getApiService();
        Call<List<BannerModel>> img = service.getBannerImages();

        img.enqueue(new Callback<List<BannerModel>>() {
            @Override
            public void onResponse(Call<List<BannerModel>> call, Response<List<BannerModel>> response) {
                RecycleAdapter recycleAdapter = new RecycleAdapter(Home_page.this, response.body());
                recyclerview.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<BannerModel>> call, Throwable t) {

            }
        });
    }

    public void getCat() {

        Api service2 = RetrofitClint.getApiService();
        Call<List<CatModel>> text = service2.getCategories();

        text.enqueue(new Callback<List<CatModel>>() {
            @Override
            public void onResponse(Call<List<CatModel>> call, Response<List<CatModel>> response) {
                RecycleAdapter2 recycleAdapter = new RecycleAdapter2(Home_page.this, response.body());
                recyclerview.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<List<CatModel>> call, Throwable t) {
            }
        });
    }
}