package com.onlineauction.onlineauctionsale.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineauction.onlineauctionsale.R;
import com.onlineauction.onlineauctionsale.adapter.ProductListApt;
import com.onlineauction.onlineauctionsale.model.ProductsData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.RecycleItems);
        List<ProductsData> productsData = new ArrayList<>();
        productsData.add(new ProductsData("Chair", "Furniture", "24 days left", R.drawable.chair));
        productsData.add(new ProductsData("Laptop", "Electronics", "12 days left", R.drawable.laptop));
        productsData.add(new ProductsData("Oppo", "Electronics", "17 days left", R.drawable.phone));
        productsData.add(new ProductsData("Painting", "Art and Crafts", "22 days left", R.drawable.painting));

        ProductListApt productListApt=new ProductListApt(getActivity(),productsData);
        recyclerView.setAdapter(productListApt);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        return view;
    }
}

