package com.ranzan.mojopizzaclone.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
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
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.ranzan.mojopizzaclone.Adapter.HomeAdapter;
import com.ranzan.mojopizzaclone.Adapter.HomeModel;
import com.ranzan.mojopizzaclone.DataActivity;
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderAdapter;
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderClass;
import com.ranzan.mojopizzaclone.Location.Api;
import com.ranzan.mojopizzaclone.Location.AppLocationService;
import com.ranzan.mojopizzaclone.Location.Network;
import com.ranzan.mojopizzaclone.Location.ResponseDTO;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.communication.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_Fragment extends Fragment implements OnClickListener {

    private ArrayList<HomeModel> imageButtons = new ArrayList<>();
    private List<ImageSliderClass> imageSliderClassList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ViewPager2 viewPager2;
    private AppLocationService appLocationService;
    private TextView getLocation;
    private ResponseDTO locationApi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        appLocationService = new AppLocationService(getContext());
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

            Api api = Network.getInstance().create(Api.class);
            api.getmodels(latitude, longitude).enqueue(new Callback<ResponseDTO>() {
                @Override
                public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                    if (response.body() != null) {
                        locationApi=response.body();
                        String address = locationApi.getResults().get(0).getLocality() + ", " +
                                locationApi.getResults().get(0).getCity() + ", " +
                                locationApi.getResults().get(0).getState() + " " +
                                locationApi.getResults().get(0).getArea() + " " +
                                locationApi.getResults().get(0).getPincode();
                        getLocation.setText(address);
                    }
                }

                @Override
                public void onFailure(Call<ResponseDTO> call, Throwable t) {

                }
            });

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        reqPermission();
        buildList();
        setRecyclerView();
        viewPager2.setAdapter(new ImageSliderAdapter(imageSliderClassList, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {

            @Override
            public void transformPage(@NonNull View page, float position) {

                page.setTranslationX(-position * page.getWidth());

                page.setAlpha(1 - Math.abs(position));
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
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
    }

    @Override
    public void onClickRecyclerView(int pos) {
        Intent intent = new Intent(getContext(), DataActivity.class);
        intent.putExtra("pos", pos);
        startActivity(intent);
    }

}