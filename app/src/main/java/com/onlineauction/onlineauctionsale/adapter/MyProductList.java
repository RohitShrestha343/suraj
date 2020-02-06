package com.onlineauction.onlineauctionsale.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineauction.onlineauctionsale.R;
import com.onlineauction.onlineauctionsale.model.ProductsData;

import java.util.List;

public class MyProductList extends RecyclerView.Adapter<MyProductList.MyProductsViewHolder> {
    Context context;
    List<ProductsData> productsDataList;

    public static final String base_url = "http://10.0.2.2:3000/";
    String imagePath = base_url;

    public MyProductList(Context context, List<ProductsData> productsDataList, String imagePath) {
        this.context = context;
        this.productsDataList = productsDataList;
        this.imagePath = imagePath;
    }

    @NonNull
    @Override
    public MyProductList.MyProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewmyproduct, parent, false);
        return new MyProductList.MyProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductList.MyProductsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyProductsViewHolder extends RecyclerView.ViewHolder {
        ImageView myprodImage;
        TextView myproductName, mybase_price, myend_date, myemail;

        public MyProductsViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}