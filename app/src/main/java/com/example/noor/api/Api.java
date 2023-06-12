package com.example.noor.api;

import com.example.noor.model.BannerModel;
import com.example.noor.model.CatModel;
import com.example.noor.model.UserModel;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

    @Multipart
    @POST("login.php")
    Call<UserModel> login(@Part("Phone") RequestBody phone,
                          @Part("Password") RequestBody password,
                          @Part("ConCode") RequestBody conCode
    );

    @Multipart
    @POST("SignUp.php")
    Call<UserModel> signUp(@Part("Name") RequestBody Name,
                           @Part("Phone") RequestBody PhoneS,
                           @Part("ConCode") RequestBody ConCodeS,
                           @Part("Email") RequestBody Email,
                           @Part("Password") RequestBody PasswordS
    );

    @GET("getBannerImages.php")
    Call<List<BannerModel>> getBannerImages();

    @GET("GetCategories.php")
    Call<List<CatModel>> getCategories();

//    @Multipart
//    @POST("getShops.php")
//    Call<List<BannerModel>> getShops(
//            @Part("Id_category") RequestBody Id_category
//    );

}
