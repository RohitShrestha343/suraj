package com.onlineauction.onlineauctionsale.ui.myList;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onlineauction.onlineauctionsale.R;

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
        return inflater.inflate(R.layout.fragment_bid_items_list, container, false);
    }

}
