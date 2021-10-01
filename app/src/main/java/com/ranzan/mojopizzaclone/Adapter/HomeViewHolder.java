package com.ranzan.mojopizzaclone.Adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.R;

public class HomeViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImgBtn;
    private RecyclerView recyclerView;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);

    }

    private void initViews(View itemView) {
        mImgBtn = itemView.findViewById(R.id.imgImage);
        recyclerView=itemView.findViewById(R.id.recycler1);
    }

    public void setData(HomeModel model) {
        mImgBtn.setImageResource(model.getImageId());
    }
}
