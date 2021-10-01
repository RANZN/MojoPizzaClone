package com.ranzan.mojopizzaclone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.communication.OnClickListener;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<HomeModel> imageButtons;
    private OnClickListener onClickListener;

    public HomeAdapter(ArrayList<HomeModel> imageButtons, OnClickListener onClickListener) {
        this.imageButtons = imageButtons;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_layout, parent, false);
        return new HomeViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HomeModel model = imageButtons.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return imageButtons.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgBtn;
        private CardView cardView;
        private OnClickListener onClickListener;

        public HomeViewHolder(@NonNull View itemView,OnClickListener onClickListener) {
            super(itemView);
            initViews(itemView);
            this.onClickListener=onClickListener;
        }

        private void initViews(View itemView) {
            mImgBtn = itemView.findViewById(R.id.imgImage);
            cardView = itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClickRecyclerView(getAdapterPosition());
                }
            });
        }

        public void setData(HomeModel model) {
            mImgBtn.setImageResource(model.getImageId());
        }
    }


}

