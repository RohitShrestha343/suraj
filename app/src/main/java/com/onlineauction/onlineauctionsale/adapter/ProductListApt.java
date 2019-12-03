package com.onlineauction.onlineauctionsale.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineauction.onlineauctionsale.R;
import com.onlineauction.onlineauctionsale.model.ProductsData;

import java.util.List;

public class ProductListApt extends RecyclerView.Adapter<ProductListApt.ProductsViewHolder>{

    Context context;
    List<ProductsData>productsDataList;

    public ProductListApt(Context context, List<ProductsData> productsDataList) {
        this.context = context;
        this.productsDataList = productsDataList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewproducts,parent,false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        ProductsData productsData=productsDataList.get(position);
        holder.prodImage.setImageResource(productsData.getImageId());
        holder.prodName.setText(productsData.getProdName());
        holder.prodType.setText(productsData.getProdType());
        holder.prodTime.setText(productsData.getProdTime());

    }

    @Override
    public int getItemCount() {
        return productsDataList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder{

        ImageView prodImage;
        TextView prodName,prodType,prodTime;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            prodImage=itemView.findViewById(R.id.prodImage);
            prodName=itemView.findViewById(R.id.prodName);
            prodType=itemView.findViewById(R.id.prodType);
            prodTime=itemView.findViewById(R.id.prodTime);
        }
    }
}
