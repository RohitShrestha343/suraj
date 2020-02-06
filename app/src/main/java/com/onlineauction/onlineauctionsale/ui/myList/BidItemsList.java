package com.onlineauction.onlineauctionsale.ui.myList;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlineauction.onlineauctionsale.LoginActivity;
import com.onlineauction.onlineauctionsale.R;
import com.onlineauction.onlineauctionsale.api.ApiClass;
import com.onlineauction.onlineauctionsale.model.MyProductModel;

import java.util.List;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class BidItemsList extends Fragment {

RecyclerView myrecycler;
View view;
    public BidItemsList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_bid_items_list, container, false);

        myrecycler=view.findViewById(R.id.MyRecycle);
        String token=new LoginActivity().Token;
        return view;
    }

//    public void LoadMyProducts(String token){
//        ApiClass apiClass=new ApiClass();
//        Call<List<MyProductModel>>productCall=apiClass.calls().
//
//    }

}
