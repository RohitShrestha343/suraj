package com.onlineauction.onlineauctionsale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etLogEmail,etLogPassword;
    private Button btnLogin,btnLogRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      //  getSupportActionBar().setTitle("Login Form");
        etLogEmail=findViewById(R.id.etLogEmail);
        etLogPassword=findViewById(R.id.etLogPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogRegister=findViewById(R.id.btnLogRegister);
        btnLogin.setOnClickListener(this);
        btnLogRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnLogin){
            if(TextUtils.isEmpty(etLogEmail.getText().toString())){
                etLogEmail.setError("Enter Username");
                etLogEmail.requestFocus();
            }
            else if(TextUtils.isEmpty(etLogPassword.getText().toString())){
                etLogPassword.setError("Enter Password");
                etLogPassword.requestFocus();
            }
            else{
                if(etLogEmail.getText().toString().equals("admin")&&etLogPassword.getText().toString().equals("admin")){
                    SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
                    SharedPreferences.Editor editor =sharedPreferences.edit();

                    editor.putString("username",etLogEmail.getText().toString());
                    editor.putString("password",etLogPassword.getText().toString());
                    editor.commit();
                    Toast.makeText(this, "Sucessfully Saved", Toast.LENGTH_SHORT).show();

                    Intent intent1=new Intent(LoginActivity.this,AdminDashboardActivity.class);
                    startActivity(intent1);
                    Toast.makeText(this, "Welcome Admin", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    etLogEmail.setText("");
                    etLogPassword.setText("");
                    etLogEmail.requestFocus();
                }
            }
        }
        else {
            Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
    }
    public void checkUser(){

    }

}
