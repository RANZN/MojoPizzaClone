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

import com.ranzan.mojopizzaclone.Adapter.HomeAdapter;
import com.ranzan.mojopizzaclone.Adapter.HomeModel;
import com.ranzan.mojopizzaclone.DataActivity;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.communication.OnClickListener;

import java.util.ArrayList;

public class Home_Fragment extends Fragment implements OnClickListener {

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
        initViews(view);
        buildList();
        setRecyclerView();
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
        HomeAdapter adapter = new HomeAdapter(imageButtons, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler1);
        textView = view.findViewById(R.id.tvCategory);
    }

    @Override
    public void onClickRecyclerView(int pos) {
        Intent intent = new Intent(getContext(), DataActivity.class);
        intent.putExtra("pos", pos);
        startActivity(intent);
    }
}