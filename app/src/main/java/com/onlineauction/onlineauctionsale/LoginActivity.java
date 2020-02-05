package com.onlineauction.onlineauctionsale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.onlineauction.onlineauctionsale.StrictModeClass.StrictModeClass;
import com.onlineauction.onlineauctionsale.bll.LoginBLl;
import com.onlineauction.onlineauctionsale.model.Users;

public class LoginActivity extends AppCompatActivity {
    private EditText etLogEmail, etLogPassword;
    private Button btnLogin, btnLogRegister;
    public String Token="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //  getSupportActionBar().setTitle("Login Form");
        etLogEmail = findViewById(R.id.etLogEmail);
        etLogPassword = findViewById(R.id.etLogPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogRegister = findViewById(R.id.btnLogRegister);



        btnLogRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(etLogEmail.getText().toString())){
                    if(!TextUtils.isEmpty(etLogPassword.getText().toString())){
                        String email=etLogEmail.getText().toString();
                        String password=etLogPassword.getText().toString();

                        Users users=new Users(email,password);
                        login(users);
                    }else{
                        etLogPassword.setError("Please Enter Password");
                    }
                }else{
                    etLogEmail.setError("Please Enter Email");
                }
            }
        });
    }
    void Store(Users u){
        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",u.getEmail());
        editor.putString("password",u.getPassword());
        Toast.makeText(this, "User Saved", Toast.LENGTH_SHORT).show();
        editor.commit();
    }
    public boolean login(Users u){

        LoginBLl loginBLl=new LoginBLl();
        StrictModeClass.StrictMode();
        if(loginBLl.checkUser(u.getEmail(),u.getPassword())){
            Store(u);
            Token=loginBLl.Token;
            Intent logIn= new Intent(LoginActivity.this,AdminDashboardActivity.class);
            logIn.putExtra("token",Token);
            startActivity(logIn);
          //  Toast.makeText(this, "Welcome "+ Token, Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(this, "Either Username or Passoword is incorrect", Toast.LENGTH_SHORT).show();
        return false;
    }
}
