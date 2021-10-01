package com.ranzan.mojopizzaclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.communication.ItemClickListener;
import com.ranzan.mojopizzaclone.communication.ItemClickListener_1;

import java.util.ArrayList;

public class model_adapter extends RecyclerView.Adapter<model_holder>{
    private ItemClickListener_1 itemClickListener_1;
    private ArrayList<Image_model> imageButtons;

    public model_adapter(ArrayList<Image_model> imageButtons , ItemClickListener_1 itemClickListener_1 ) {
        this.imageButtons = imageButtons;
        this.itemClickListener_1 = itemClickListener_1;
    }

    @NonNull
    @Override
    public model_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_layout,parent,false);
        return new model_holder(view,itemClickListener_1);
    }

    @Override
    public void onBindViewHolder(@NonNull model_holder holder, int position) {
        Image_model model=imageButtons.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return imageButtons.size();
    }
}
