package com.ranzan.mojopizzaclone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<HomeModel> imageButtons;

    public HomeAdapter(ArrayList<HomeModel> imageButtons) {
        this.imageButtons = imageButtons;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_layout, parent, false);
        return new HomeViewHolder(view);
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
        private RecyclerView recyclerView;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);

        }

        private void initViews(View itemView) {
            mImgBtn = itemView.findViewById(R.id.imgImage);
            recyclerView = itemView.findViewById(R.id.recycler1);
        }

        public void setData(HomeModel model) {
            mImgBtn.setImageResource(model.getImageId());
        }
    }


}

