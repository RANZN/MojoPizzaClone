package com.ranzan.mojopizzaclone.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ranzan.mojopizzaclone.Adapter.All_Model;
import com.ranzan.mojopizzaclone.Adapter.CartAdapter;
import com.ranzan.mojopizzaclone.R;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class CartFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<All_Model> cartModelsList = new ArrayList<>();
    private CartAdapter cartAdapter;
    private TextView tvTotal;
    private static int total = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    private void loadData() {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("dataList", null);
        Type type = new TypeToken<ArrayList<All_Model>>() {
        }.getType();
        cartModelsList = gson.fromJson(json, type);
        if (cartModelsList == null) {
            cartModelsList = new ArrayList<>();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

        setCartAdapter();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
        cartAdapter.updateUI(cartModelsList);
    }

    private void setCartAdapter() {
        cartAdapter = new CartAdapter(cartModelsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartAdapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.CartRecyclerView);
        tvTotal = view.findViewById(R.id.TvShowCart_Prize);
    }
}