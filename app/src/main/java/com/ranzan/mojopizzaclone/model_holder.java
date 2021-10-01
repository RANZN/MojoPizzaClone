package com.ranzan.mojopizzaclone;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.communication.ItemClickListener;
import com.ranzan.mojopizzaclone.communication.ItemClickListener_1;

public class model_holder extends RecyclerView.ViewHolder {
    private ItemClickListener_1 itemClickListener_1;
    private ImageView mImgBtn;
    private RecyclerView recyclerView;

    public model_holder(@NonNull View itemView,ItemClickListener_1 itemClickListener_1) {
        super(itemView);
        this.itemClickListener_1 = itemClickListener_1;
        initViews(itemView);

    }

    private void initViews(View itemView) {
        mImgBtn = itemView.findViewById(R.id.imgImage);
        recyclerView=itemView.findViewById(R.id.recycler1);
    }

    public void setData(Image_model model) {
        mImgBtn.setImageResource(model.getImageId());
        mImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener_1.onClickItem(getAdapterPosition(),model);
            }
        });
    }
}
