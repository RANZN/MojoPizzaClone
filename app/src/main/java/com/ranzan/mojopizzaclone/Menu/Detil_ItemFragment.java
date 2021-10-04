package com.ranzan.mojopizzaclone.Menu;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.ranzan.mojopizzaclone.Adapter.All_Model;
import com.ranzan.mojopizzaclone.Adapter.CartModel;
import com.ranzan.mojopizzaclone.R;

import java.util.ArrayList;


public class Detil_ItemFragment extends Fragment {
    private ImageView mTv_Show_Image_Poster, closeBtn;
    private TextView mTv_Show_Name;
    private TextView mTv_Show_Detail;
    private TextView mTv_Show_Price;
    private Button mBtnAddToCart;
    private TextView mBtnMoreInfo;
    private static ArrayList<CartModel> cartList = new ArrayList<>();
    private All_Model all_model;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        if(getArguments()!=null){
            all_model = (All_Model) getArguments().getSerializable("data");
        }
        if (all_model != null) {
            mTv_Show_Image_Poster.setImageResource(all_model.getPosterImage());
            mTv_Show_Name.setText(all_model.getNameOfItem_1());
            mTv_Show_Price.setText(all_model.getPrice());
            mTv_Show_Detail.setText(all_model.getDetailOfItem());
        }


//        mBtnMoreInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), Item_Detail_Activity.class);
//                startActivity(intent);
//            }
//        });
        mBtnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartList.add(new CartModel(all_model, 1));
                mBtnAddToCart.setText("ADDED TO CART");
                addDataToPreference();
                Toast.makeText(getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addDataToPreference() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(cartList);
        editor.putString("dataList", json);
        editor.apply();
    }

    private void initView(View view) {
        mTv_Show_Name= view.findViewById(R.id.Trans_Tv_Show_Name);
        mTv_Show_Image_Poster= view.findViewById(R.id.Trans_Poster_Image);
        mTv_Show_Detail= view.findViewById(R.id.Trans_Tv_Show_Detail);
        mTv_Show_Price = view.findViewById(R.id.Trans_Tv_Show_Prize);
        mBtnAddToCart= view.findViewById(R.id.Trans_Btn_addToCart);
        mBtnMoreInfo= view.findViewById(R.id.Btnmoreinfo);
        closeBtn=view.findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getFragmentManager().popBackStack();
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detil__item, container, false);
    }
}