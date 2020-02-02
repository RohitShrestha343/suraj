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

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String imagepath = bundle.getString("image");

            try {
                URL url =new URL(imagepath);
                product_Image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            product_name.setText(bundle.getString("name"));
            product_category.setText(bundle.getString("category"));
            base_price.setText(bundle.getString("base_price"));
            start_date.setText(bundle.getString("start_date"));
            end_date.setText(bundle.getString("end_date"));
            highest_bid.setText(bundle.getString("highest_bid"));
        }

        bit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetailActivity.this, "Bid Added", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
