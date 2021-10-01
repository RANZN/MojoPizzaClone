package com.ranzan.mojopizzaclone.Menu;

import android.content.Intent;
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

import com.ranzan.mojopizzaclone.Adapter.All_Model;
import com.ranzan.mojopizzaclone.CartAdapter.CartModel;
import com.ranzan.mojopizzaclone.Fragments.CartFragment;
import com.ranzan.mojopizzaclone.Helper.PreferenceHelper;
import com.ranzan.mojopizzaclone.MainActivity;
import com.ranzan.mojopizzaclone.R;

import java.util.ArrayList;


public class Detil_ItemFragment extends Fragment {
    private ImageView mTv_Show_Image_Poster,closeBtn;
    private TextView mTv_Show_Name;
    private TextView mTv_Show_Detail;
    private TextView mTv_Show_Prize;
    private Button mBtnAddToCart;
    private TextView mBtnMoreInfo;
    private String CartName;
    private String CartPrize;
    private int CartImage;
    private int Total;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        int imageId = PreferenceHelper.getIntFromPreference(getContext(), "ImagePoster");
        String Name = PreferenceHelper.getStringFromPreference(getContext(), "ItemName");
        String Detail = PreferenceHelper.getStringFromPreference(getContext(), "ItemDetail");
        String Prize = PreferenceHelper.getStringFromPreference(getContext(), "Prize");

        mTv_Show_Image_Poster.setImageResource(imageId);
        mTv_Show_Name.setText(Name);
        mTv_Show_Prize.setText(Prize);
        mTv_Show_Detail.setText(Detail);
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
                String Name =mTv_Show_Name.getText().toString();
                String Prize = mTv_Show_Prize.getText().toString();
//                int Image = mTv_Show_Image_Poster.;
                Bundle bundle = new Bundle();
                bundle.putString("Itemname" ,Name );
                bundle.putString("ItePrize" ,Prize );
                Toast.makeText(getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void initView(View view) {
        mTv_Show_Name= view.findViewById(R.id.Trans_Tv_Show_Name);
        mTv_Show_Image_Poster= view.findViewById(R.id.Trans_Poster_Image);
        mTv_Show_Detail= view.findViewById(R.id.Trans_Tv_Show_Detail);
        mTv_Show_Prize= view.findViewById(R.id.Trans_Tv_Show_Prize);
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