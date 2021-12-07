package com.ranzan.mojopizzaclone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.communication.ItemClickListener;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private ArrayList<All_Model> all_modelsList;
    private ItemClickListener itemClickListener;

    public MenuAdapter(ArrayList<All_Model> all_modelsList, ItemClickListener itemClickListener) {
        this.all_modelsList = all_modelsList;
        this.itemClickListener = itemClickListener;
    }

    public MenuAdapter(ArrayList<All_Model> all_modelsList) {
        this.all_modelsList = all_modelsList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_data, parent, false);
        return new MenuViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        All_Model all_model = all_modelsList.get(position);
        holder.setData(all_model);
    }

    @Override
    public int getItemCount() {
        return all_modelsList.size();
    }

    public void updateUI(ArrayList<All_Model> all_modelsList) {
        this.all_modelsList = all_modelsList;
        notifyDataSetChanged();

    }

}

class MenuViewHolder extends RecyclerView.ViewHolder {
    private TextView TvName;
    private TextView TvName_1;
    private TextView TvDetail;
    private TextView TvDetail_1;
    private ImageView TvPosterImage;
    private TextView TvPrize;
    private ItemClickListener itemClickListener;
    private RelativeLayout relativeLayout;

    public MenuViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        TvName = itemView.findViewById(R.id.nameofitem);
        TvName_1 = itemView.findViewById(R.id.nameofitem_2);
        TvDetail = itemView.findViewById(R.id.aboutItem);
        TvDetail_1 = itemView.findViewById(R.id.aboutItem_2);
        TvPosterImage = itemView.findViewById(R.id.imageifitem);
        TvPrize = itemView.findViewById(R.id.prize);
        relativeLayout = itemView.findViewById(R.id.item_RelativeLayout);
    }

    public void setData(All_Model all_model) {
        TvName.setText(all_model.getNameOfItem());
        TvName_1.setText(all_model.getNameOfItem_1());
        TvDetail.setText(all_model.getDetailOfItem());
        TvDetail_1.setText(all_model.getDetailOfItem_1());
        TvPosterImage.setImageResource(all_model.getPosterImage());
        TvPrize.setText(all_model.getPrice());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(getAdapterPosition(), all_model);
            }
        });
    }
}
