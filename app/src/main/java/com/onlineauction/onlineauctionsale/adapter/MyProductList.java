package com.onlineauction.onlineauctionsale.adapter;

import android.content.Context;

import com.onlineauction.onlineauctionsale.model.ProductsData;
import java.util.List;

public class MyProductList {
    Context context;
    List<ProductsData> productsDataList;

    public static final String base_url = "http://10.0.2.2:3000/";
    String imagePath = base_url;

    public MyProductList(Context context, List<ProductsData> productsDataList, String imagePath) {
        this.context = context;
        this.productsDataList = productsDataList;
        this.imagePath = imagePath;
    }

}