package com.ranzan.mojopizzaclone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private ArrayList<All_Model> cartModelsList;

    public CartAdapter(ArrayList<All_Model> cartModelList) {
        this.cartModelsList = cartModelList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        All_Model cartModel = cartModelsList.get(position);
        holder.setData(cartModel);
    }

    @Override
    public int getItemCount() {
        return cartModelsList.size();
    }

    public void updateUI(ArrayList<All_Model> cartModelList) {
        this.cartModelsList = cartModelList;
        notifyDataSetChanged();
    }
}
class CartViewHolder extends RecyclerView.ViewHolder{
    private ImageView ImagePoster;
    private TextView Name;
    private TextView price;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        ImagePoster = itemView.findViewById(R.id.cartImagePoster);
        Name = itemView.findViewById(R.id.cartItemName);
        price = itemView.findViewById(R.id.cartItemPrice);
    }

    public void setData(All_Model cartModel) {
        if(cartModel!=null) {
            ImagePoster.setImageResource(cartModel.getPosterImage());
            Name.setText(cartModel.getNameOfItem());
            price.setText(cartModel.getPrice());
        }
    }
}
