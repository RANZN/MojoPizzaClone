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
import com.ranzan.mojopizzaclone.Adapter.HomeModel;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.Adapter.HomeAdapter;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {
//    private ImageSlider imageSlider;
//    private ArrayList<SlideModel> imageList = new ArrayList<>();
    private ArrayList<HomeModel> imageButtons = new ArrayList<>();
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
//        imageList.add(new SlideModel(R.drawable.pizza1, ScaleTypes.FIT));
//        imageList.add(new SlideModel(R.drawable.pizza1, ScaleTypes.FIT));
//        imageList.add(new SlideModel(R.drawable.pizza1, ScaleTypes.FIT));
//        imageList.add(new SlideModel(R.drawable.pizza1, ScaleTypes.FIT));
        initViews(view);
//        imageSlider.setImageList(imageList);
        buildList();
        setRecyclerView();

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(getContext(), DataActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }

    private void buildList() {
        imageButtons.add(new HomeModel(R.drawable.d));
        imageButtons.add(new HomeModel(R.drawable.e));
        imageButtons.add(new HomeModel(R.drawable.f));
        imageButtons.add(new HomeModel(R.drawable.g));
        imageButtons.add(new HomeModel(R.drawable.h));
        imageButtons.add(new HomeModel(R.drawable.i));
        imageButtons.add(new HomeModel(R.drawable.j));
        imageButtons.add(new HomeModel(R.drawable.k));
        imageButtons.add(new HomeModel(R.drawable.l));
        imageButtons.add(new HomeModel(R.drawable.m));
    }

    private void setRecyclerView() {
        HomeAdapter adapter = new HomeAdapter(imageButtons);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initViews(View view) {
//        imageSlider = view.findViewById(R.id.image_slider);
        recyclerView = view.findViewById(R.id.recycler1);
        textView=view.findViewById(R.id.tvCategory);
    }
}