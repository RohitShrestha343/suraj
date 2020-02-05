package com.shrestharohit.onlineauctionsalewear.api;

import com.shrestharohit.onlineauctionsalewear.model.Signup_Response;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("users/login")
    Call<Signup_Response> checkUser(@Field("email") String username, @Field("password")String password);

}
