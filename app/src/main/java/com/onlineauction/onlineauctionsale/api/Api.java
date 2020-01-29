package com.onlineauction.onlineauctionsale.api;
import com.onlineauction.onlineauctionsale.model.ImageModel;
import com.onlineauction.onlineauctionsale.model.Signup_response;
import com.onlineauction.onlineauctionsale.model.Users;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

        @FormUrlEncoded
        @POST("users/login")
        Call<Signup_response>checkUser(@Field("email") String username,@Field("password")String password);

        @Multipart
        @POST("upload")
        Call<ImageModel>uploadImage(@Part MultipartBody.Part imageFile);

        @POST("users/signup")
        Call<Signup_response>register(@Body Users cud);
    }

}
