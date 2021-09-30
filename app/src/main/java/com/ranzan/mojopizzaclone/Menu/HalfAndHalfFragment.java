package com.ranzan.mojopizzaclone.Menu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.Adapter.All_Model;
import com.ranzan.mojopizzaclone.Adapter.MenuAdapter;
import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.communication.CommunicationListener;

import java.util.ArrayList;


public class HalfAndHalfFragment extends Fragment {
    private ImageView btnBack;
    private ImageView TvFavorite;
    private TextView mTvPredict;
    private TextView mTvHalfAndHalf;
    private TextView mTvPartyCombo;
    private TextView mTvBig_10;
    private TextView mTvStarters;
    private TextView mTvGarlicBread;
    private TextView mTvDesserts;
    private CommunicationListener listener;
    private ArrayList<All_Model> all_modelsList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_half_and_half, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.HalfAndHalf_recyclerView);
        initView(view);
        buildRecyclerViewData();
        setRecyclerviewAdapter();
        onclick();
    }

    private void onclick() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Under Progress", Toast.LENGTH_SHORT).show();
            }
        });
        mTvDesserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.launchDessertAndDrinkFragment();
            }
        });
        TvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Under Progress", Toast.LENGTH_SHORT).show();
            }
        });
        mTvPredict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mTvHalfAndHalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.launchHalfAndHalfFragment();
            }
        });
        mTvPartyCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.launchPartyComboFragment();
            }
        });
        mTvBig_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.launchBig10Fragment();
            }
        });
        mTvStarters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.launchStartersFragment();
            }
        });
        mTvGarlicBread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.launchGarlicFragment();
            }
        });
    }

    private void initView(View view) {
        btnBack = view.findViewById(R.id.btnback);
        TvFavorite = view.findViewById(R.id.btnfavorite);
        mTvPredict = view.findViewById(R.id.predict);
        mTvHalfAndHalf = view.findViewById(R.id.HalfAndHalf);
        mTvPartyCombo = view.findViewById(R.id.partycombo);
        mTvBig_10 = view.findViewById(R.id.Big_10);
        mTvStarters = view.findViewById(R.id.Starters);
        mTvGarlicBread = view.findViewById(R.id.GarlicBread);
        mTvDesserts = view.findViewById(R.id.Desserts);
    }

    private void setRecyclerviewAdapter() {
        MenuAdapter menuAdapter = new MenuAdapter(all_modelsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(menuAdapter);

    }

    private void buildRecyclerViewData() {
        all_modelsList = new ArrayList<>();
        all_modelsList.add(new All_Model("Half & Half Pizzas", "Veg - Non-Veg Half Half", "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza", "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ", R.drawable.half_1, "$410"));
        all_modelsList.add(new All_Model("Half & Half Pizzas", "Veg - Non-Veg Half Half", "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza", "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ", R.drawable.half_2, "$300"));
        all_modelsList.add(new All_Model("Half & Half Pizzas", "Veg - Non-Veg Half Half", "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza", "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ", R.drawable.half_3, "$200"));
        all_modelsList.add(new All_Model("Half & Half Pizzas", "Veg - Non-Veg Half Half", "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza", "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ", R.drawable.half_4, "$260"));
        all_modelsList.add(new All_Model("Half & Half Pizzas", "Veg - Non-Veg Half Half", "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza", "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ", R.drawable.half_5, "$390"));
        all_modelsList.add(new All_Model("Half & Half Pizzas", "Veg - Non-Veg Half Half", "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza", "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ", R.drawable.half_6, "$400"));
        all_modelsList.add(new All_Model("Half & Half Pizzas", "Veg - Non-Veg Half Half", "Cant't make up your mind? No worries get 2 different haves in one big 10-inch pizza", "The fight ends today! Get your own half now. pick a half each of any 2  & make 1 big 10 inch pizza ", R.drawable.half_7, "$540"));
    }
}