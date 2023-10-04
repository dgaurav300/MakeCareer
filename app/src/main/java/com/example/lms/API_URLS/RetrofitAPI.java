package com.example.lms.API_URLS;

import com.example.lms.respones.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @FormUrlEncoded
    @POST("register.php")
Call<RegisterResponse> register(
        @Field("full_name")  String name,
        @Field("email") String email,
        @Field("contact_number") String contact_number,
        @Field("password") String password
);
}
