package com.ranzan.mojopizzaclone.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.DataActivity;
import com.ranzan.mojopizzaclone.Image_model;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.model_adapter;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {
    private ArrayList<Image_model> imageButtons = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildList();
        setRecyclerView();

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DataActivity.class);
                startActivity(intent);
            }
        });
    }

    private void buildList() {
        imageButtons.add(new Image_model(R.drawable.d));
        imageButtons.add(new Image_model(R.drawable.e));
        imageButtons.add(new Image_model(R.drawable.f));
        imageButtons.add(new Image_model(R.drawable.g));
        imageButtons.add(new Image_model(R.drawable.h));
        imageButtons.add(new Image_model(R.drawable.i));
        imageButtons.add(new Image_model(R.drawable.j));
        imageButtons.add(new Image_model(R.drawable.k));
        imageButtons.add(new Image_model(R.drawable.l));
        imageButtons.add(new Image_model(R.drawable.m));
    }

    private void setRecyclerView() {
        model_adapter adapter = new model_adapter(imageButtons);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler1);
        textView=view.findViewById(R.id.tvCategory);
    }
}