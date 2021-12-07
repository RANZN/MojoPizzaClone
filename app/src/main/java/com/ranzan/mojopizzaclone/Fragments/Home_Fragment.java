package com.ranzan.mojopizzaclone.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ranzan.mojopizzaclone.Adapter.HomeAdapter;
import com.ranzan.mojopizzaclone.Adapter.HomeModel;
import com.ranzan.mojopizzaclone.DataActivity;
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderAdapter;
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderClass;
import com.ranzan.mojopizzaclone.Location.AppLocationService;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.communication.OnClickListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Home_Fragment extends Fragment implements TabLayout.OnTabSelectedListener , OnClickListener     {

    private ArrayList<HomeModel> imageButtons = new ArrayList<>();
    private List<ImageSliderClass> imageSliderClassList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ViewPager2 viewPager2;
    private AppLocationService appLocationService;
    private TextView getLocation;
    private TextView textView;
    private Handler slideHandler = new Handler();
    private TabLayout tabLayout;
    private String address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        appLocationService = new AppLocationService(getContext());
        reqPermission();
        return inflater.inflate(R.layout.fragment_home_, container, false);
    }

    private void reqPermission() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        boolean isPermissionGranted = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        if (isPermissionGranted)
            getLocation();
    }


    private void getLocation() {
        Location location = appLocationService
                .getLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
//            String result = "(" + latitude + ", " + longitude + ")";
//            getLocation.setText(result);
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
            try {
                List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                String addressLine = addressList.get(0).getSubLocality();
                String addressCity = addressList.get(0).getLocality();
                String addressState = addressList.get(0).getAdminArea();
                String pinCode = addressList.get(0).getPostalCode();
                address = addressLine + ", " + addressCity + ", " + addressState + ", " + pinCode;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildList();
        setRecyclerView();
        getLocation.setText(address);
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
        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reqPermission();
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
        imageSliderClassList.add(new ImageSliderClass(R.drawable.a));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.b));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.c));

        imageSliderClassList.add(new ImageSliderClass(R.drawable.garlic_2));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.garlic_3));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.half_3));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.half_6));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.desserts_4));
        imageSliderClassList.add(new ImageSliderClass(R.drawable.big_2));
    }

    private void setRecyclerView() {
        HomeAdapter adapter = new HomeAdapter(imageButtons, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initViews(View view) {
        viewPager2 = view.findViewById(R.id.Slider);
        recyclerView = view.findViewById(R.id.recycler1);
        getLocation = view.findViewById(R.id.location);
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

    @Override
    public void onClickRecyclerView(int pos) {
        Intent intent = new Intent(getContext(), DataActivity.class);
        intent.putExtra("pos", pos);
        startActivity(intent);
    }

}