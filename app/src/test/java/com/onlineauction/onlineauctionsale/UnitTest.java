package com.onlineauction.onlineauctionsale;

import com.onlineauction.onlineauctionsale.api.ApiClass;
import com.onlineauction.onlineauctionsale.model.Bidm;
import com.onlineauction.onlineauctionsale.model.Bidmodel;
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
        Users users = new Users("", "rohit", "shrestha", "male", "rohit.shrestha@gmail.com", "asd.jpg", "rohit");
        ApiClass apiClass = new ApiClass();
        Call<Signup_response> regiscall = apiClass.calls().register(users);

        try {
            Response<Signup_response> registerResponse = regiscall.execute();
            Signup_response response = registerResponse.body();

            assertTrue(registerResponse.isSuccessful() && (response.getStatus().equals("Success")));

        } catch (IOException e) {
            System.out.println(e);
        }


    }

    @Test
    public void Test_Login() {

        Users users = new Users("helina@gmail.com", "helina");
        ApiClass apiClass = new ApiClass();
        Call<Signup_response> regiscall = apiClass.calls().checkUser(users.getEmail(), users.getPassword());
        try {
            Response<Signup_response> loginResponse = regiscall.execute();
            Signup_response loginresponse = loginResponse.body();

            assertTrue(loginResponse.isSuccessful() && (!loginresponse.getToken().isEmpty()));


        } catch (IOException e) {
            System.out.println(e);
        }


    }

    @Test
    public void Test_Bid(){
        ApiClass apiClass = new ApiClass();
        Call<Bidm> bidmodelCall = apiClass.calls().getBid("5e2fb169c58bb73660da7a75", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImhlbGluYUBnbWFpbC5jb20iLCJfaWQiOiI1ZTNhZmUwY2QyMGUwNTI4NDA0YjM3MjMiLCJpYXQiOjE1ODEzOTYxMjF9.aYF07NdrI4q_itLOxUJCufY7zhhyCmpiAV8YA72aYu8", "5740310");
        try{
            Response<Bidm>bidmResponse=bidmodelCall.execute();
            Bidm bidm=bidmResponse.body();
            assertTrue(bidm.getMeaasge().equals("ok"));

        }catch (IOException e){
            System.out.println(e);
        }
    }
}

