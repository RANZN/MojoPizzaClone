package com.ranzan.mojopizzaclone.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.ranzan.mojopizzaclone.DataActivity;
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderAdapter;
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderClass;
import com.ranzan.mojopizzaclone.Image_model;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.model_adapter;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {
    private ViewPager2 viewPager2;
    private ArrayList<Image_model> imageButtons = new ArrayList<>();
    private List<ImageSliderClass> imageSliderClassList=new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView textView;
    private Handler slideHandler=new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildList();
        setRecyclerView();

        viewPager2.setAdapter(new ImageSliderAdapter(imageSliderClassList,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
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
        imageSliderClassList.add(new ImageSliderClass(R.drawable.a));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.b));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.c));
    }

    private void setRecyclerView() {
        model_adapter adapter = new model_adapter(imageButtons);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initViews(View view) {
        viewPager2=view.findViewById(R.id.Slider);
        recyclerView = view.findViewById(R.id.recycler1);
        textView=view.findViewById(R.id.tvCategory);
    }
}