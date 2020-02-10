package com.onlineauction.onlineauctionsale;

import com.onlineauction.onlineauctionsale.api.ApiClass;
import com.onlineauction.onlineauctionsale.model.Signup_response;
import com.onlineauction.onlineauctionsale.model.Users;

import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

import static junit.framework.TestCase.assertTrue;

public class UnitTest {
    @Test
    public void Test_registration() {
        Users users = new Users( "", "rohit", "shrestha", "male", "rohit.shrestha@gmail.com", "asd.jpg", "rohit" );
        ApiClass apiClass = new ApiClass();
        Call<Signup_response> regiscall = apiClass.calls().register( users );

        try {
            Response<Signup_response> registerResponse = regiscall.execute();
            Signup_response response= registerResponse.body();

            assertTrue( registerResponse.isSuccessful() && (response.getStatus().equals( "Success" )) );

        } catch (IOException e) {
            System.out.println( e );
        }


    }





}
