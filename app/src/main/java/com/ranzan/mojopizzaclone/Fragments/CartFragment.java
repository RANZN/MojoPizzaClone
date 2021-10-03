package com.ranzan.mojopizzaclone.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ranzan.mojopizzaclone.Adapter.All_Model;
import com.ranzan.mojopizzaclone.Adapter.CartAdapter;
import com.ranzan.mojopizzaclone.Adapter.CartModel;
import com.ranzan.mojopizzaclone.Login.LoginActivity;
import com.ranzan.mojopizzaclone.OrderActivity;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.communication.ItemClickListener;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class CartFragment extends Fragment implements ItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<CartModel> cartModelsList = new ArrayList<>();
    private CartAdapter cartAdapter;
    private TextView tvTotal;
    private Button btn;
    private int total = 0;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    private void loadData() {
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("dataList", null);
        Type type = new TypeToken<ArrayList<CartModel>>() {
        }.getType();
        if (cartModelsList == null) {
            cartModelsList = new ArrayList<>();
        } else if (gson.fromJson(json, type) != null)
            cartModelsList.addAll(gson.fromJson(json, type));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setCartAdapter();
        loadData();
        cartAdapter.updateUI(cartModelsList);
        setTotalAmount();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentUser != null) {
                    Intent intent = new Intent(getContext(), OrderActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "You need to login first", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    void setTotalAmount() {
        for (CartModel i : cartModelsList) {
            String s = i.getAll_model().getPrice();
            int n = Integer.parseInt(s.substring(1));
            total += n;
        }
        tvTotal.setText("$ " + total);
    }

    private void setCartAdapter() {
        cartAdapter = new CartAdapter(cartModelsList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartAdapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.CartRecyclerView);
        tvTotal = view.findViewById(R.id.cartTotalPrice);
        tvTotal = view.findViewById(R.id.cartTotalPrice);
        btn = view.findViewById(R.id.cartOrderBtn);
    }

    @Override
    public void onItemClick(int position, All_Model all_model) {
        cartModelsList.remove(position);
        cartAdapter.updateUI(cartModelsList);
        setTotalAmount();
        addDataToPreference();
    }


    private void addDataToPreference() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(cartModelsList);
        editor.putString("dataList", json);
        editor.apply();
    }
}