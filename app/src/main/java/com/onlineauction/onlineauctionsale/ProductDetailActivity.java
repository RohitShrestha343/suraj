package com.onlineauction.onlineauctionsale;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView product_Image;
    TextView product_name,product_category,base_price,start_date,end_date,highest_bid;
    Button bit_button;
    EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        product_Image = findViewById(R.id.product_Image);
        product_name = findViewById(R.id.product_name);
        product_category = findViewById(R.id.product_category);
        base_price = findViewById(R.id.base_price);
        start_date = findViewById(R.id.start_date);
        end_date = findViewById(R.id.end_date);
        highest_bid = findViewById(R.id.highest_bid);
        bit_button = findViewById(R.id.bit_button);
        amount = findViewById(R.id.amount);




    }
}
