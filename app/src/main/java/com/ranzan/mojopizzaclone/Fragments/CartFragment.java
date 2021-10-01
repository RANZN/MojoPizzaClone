package com.ranzan.mojopizzaclone.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.CartAdapter.CartAdapter;
import com.ranzan.mojopizzaclone.CartAdapter.CartModel;
import com.ranzan.mojopizzaclone.Menu.Detil_ItemFragment;
import com.ranzan.mojopizzaclone.R;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView TvPrize;
    private ImageView ImagePoster;
    private TextView CartNameItem;
    private TextView CartPrizeItem;
    private String Name;
    private String Prize;
    private ArrayList<CartModel> cartModelsList = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            Name =getArguments().getString("Itemname");
            Prize =getArguments().getString("ItemPrize");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CartModel cartModel = new CartModel(Name,0,Prize,0);
        cartModelsList.add(cartModel);
        recyclerView = view.findViewById(R.id.CartRecyclerView);
        CartAdapter cartAdapter = new CartAdapter(cartModelsList);
        CartNameItem= view.findViewById(R.id.CartNameItem);
        CartPrizeItem = view.findViewById(R.id.TvShowCart_Prize);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartAdapter);
        TvPrize = view.findViewById(R.id.TvShowCart_Prize);
        CartNameItem.setText(Name);
        CartPrizeItem.setText(Prize);

    }
}