package com.onlineauction.onlineauctionsale.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineauction.onlineauctionsale.LoginActivity;
import com.onlineauction.onlineauctionsale.R;
import com.onlineauction.onlineauctionsale.adapter.ProductListApt;
import com.onlineauction.onlineauctionsale.api.ApiClass;
import com.onlineauction.onlineauctionsale.model.ProductsData;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.RecycleItems);
        String token = new LoginActivity().Token;
        loadCurrentUser(token);
        return view;
    }
    private void loadCurrentUser(String token) {
        ApiClass usersAPI = new ApiClass();
        Call<List<ProductsData>> userCall=usersAPI.calls().getproducts(token);
        userCall.enqueue(new Callback<List<ProductsData>>() {
            @Override
            public void onResponse(Call<List<ProductsData>> call, Response<List<ProductsData>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Code"+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<ProductsData>productsData=response.body();
//                Toast.makeText(getContext(), ""+productsData.size(), Toast.LENGTH_SHORT).show();

                ProductListApt productListApt=new ProductListApt(getContext(),productsData);
                recyclerView.setAdapter(productListApt);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure(Call<List<ProductsData>> call, Throwable t) {
                Toast.makeText(getContext(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

