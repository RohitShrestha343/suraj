package com.onlineauction.onlineauctionsale;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.onlineauction.onlineauctionsale.bll.LoginBLl;

import java.io.InputStream;
import java.net.URL;

public class UserUpdateActivity extends AppCompatActivity {
ImageView imageupdate;
EditText firstnameup,lastnameup;
Button btnUpdate;
    String oldName, id;
    private String selected, imageName = "";
    public static String token = "";
    public static final String base_url = "http://10.0.2.2:3000/";
    String imagePaths = base_url;
    String imagePath;
    String sendp;
    String rImage;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        imageupdate=findViewById(R.id.imageupdate);
        firstnameup=findViewById(R.id.etuptfirst);
        lastnameup=findViewById(R.id.etuptsecond);
        btnUpdate=findViewById(R.id.btnUpdate);

         token="Bearer " + LoginBLl.Token;

         Bundle bundle=getIntent().getExtras();
         if(bundle !=null) {
             String imgPath = imagePaths + bundle.getString("image");
             oldName = bundle.getString("image");
             id = bundle.getString("id");
             firstnameup.setText(bundle.getString("first_name"));
             lastnameup.setText(bundle.getString("last_name"));

             try {
                 URL url = new URL(imgPath);
                 imageupdate.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }


    }
}
