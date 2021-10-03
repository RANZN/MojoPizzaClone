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

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ranzan.mojopizzaclone.DataActivity;
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderAdapter;
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderClass;
import com.ranzan.mojopizzaclone.Image_model;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.model_adapter;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment implements TabLayout.OnTabSelectedListener{
    private ViewPager2 viewPager2;
    private ArrayList<Image_model> imageButtons = new ArrayList<>();
    private List<ImageSliderClass> imageSliderClassList=new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView textView;
    private Handler slideHandler=new Handler();
    private TabLayout tabLayout;
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

        tabLayout.addOnTabSelectedListener(this);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

            }
        }).attach();

        Runnable sliderRunnable = new Runnable() {
            @Override
            public void run() {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        };
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable, 2000); // slide duration 2 seconds
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
        imageSliderClassList.add(new ImageSliderClass(R.drawable.garlic_2));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.garlic_3));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.half_3));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.half_6));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.desserts_4));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.big_2));
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
        tabLayout=view.findViewById(R.id.tabLayout);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}