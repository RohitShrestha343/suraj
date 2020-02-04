package com.onlineauction.onlineauctionsale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.onlineauction.onlineauctionsale.StrictModeClass.StrictModeClass;
import com.onlineauction.onlineauctionsale.api.ApiClass;
import com.onlineauction.onlineauctionsale.bll.LoginBLl;
import com.onlineauction.onlineauctionsale.model.Bidm;
import com.onlineauction.onlineauctionsale.model.Bidmodel;
import com.onlineauction.onlineauctionsale.model.ProductsData;
import com.onlineauction.onlineauctionsale.model.Signup_response;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView product_Image;
    TextView product_name, product_category, base_price, start_date, end_date, highest_bid,email;
    Button bit_button;
    EditText amount;
    String id;

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
        email=findViewById(R.id.email);

        amount = findViewById(R.id.amount);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String imagepath = bundle.getString("image");

            try {
                URL url = new URL(imagepath);
                product_Image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            id = bundle.getString("id");
            Toast.makeText(this, "id" + id, Toast.LENGTH_SHORT).show();
            product_name.setText(bundle.getString("name"));
            product_category.setText(bundle.getString("category"));
            base_price.setText(bundle.getString("base_price"));
            start_date.setText(bundle.getString("start_date"));
            end_date.setText(bundle.getString("end_date"));
            highest_bid.setText(bundle.getString("highest_bid"));
            email.setText(bundle.getString("email"));


        }

        bit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Hnum = 0;
                Hnum = Integer.parseInt(highest_bid.getText().toString());
                int getnum = Integer.parseInt(amount.getText().toString());
                if (Hnum < getnum) {
                    String token = "Bearer "+new LoginBLl().Token;
                    setNew(token, amount.getText().toString());

                    Intent intent = new Intent(ProductDetailActivity.this, AdminDashboardActivity.class);
                    startActivity(intent);
                } else {
                     Toast.makeText(ProductDetailActivity.this, "Bid must be more", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void setNew(String token, String bid) {
        ApiClass apiClass = new ApiClass();
        Call<Bidm> bidmodelCall = apiClass.calls().getBid(id, token, bid);
        StrictModeClass.StrictMode();
        bidmodelCall.enqueue(new Callback<Bidm>() {
            @Override
            public void onResponse(Call<Bidm> call, Response<Bidm> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ProductDetailActivity.this, "error" + response.code(), Toast.LENGTH_SHORT).show();
                    Log.d("error", "error" + response.code());
                    return;
                }

                Toast.makeText(ProductDetailActivity.this, "Bid Posted. Thank You :)", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Bidm> call, Throwable t) {
                Toast.makeText(ProductDetailActivity.this, "error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("error", "error  " + t.getLocalizedMessage());
            }
        });
    }
}
