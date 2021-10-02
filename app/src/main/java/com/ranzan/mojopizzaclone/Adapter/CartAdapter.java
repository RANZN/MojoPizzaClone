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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ArrayList<CartModel> cartModelsList;

    public CartAdapter(ArrayList<CartModel> cartModelList) {
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
        CartModel cartModel = cartModelsList.get(position);
        holder.setData(cartModel);
    }

    @Override
    public int getItemCount() {
        return cartModelsList.size();
    }

    public void updateUI(ArrayList<CartModel> cartModelList) {
        this.cartModelsList = cartModelList;
        notifyDataSetChanged();
    }



    class CartViewHolder extends RecyclerView.ViewHolder {
        private ImageView ImagePoster, addBtn, subBtn;
        private TextView Name, price, quantity;


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            ImagePoster = itemView.findViewById(R.id.cartImagePoster);
            Name = itemView.findViewById(R.id.cartItemName);
            price = itemView.findViewById(R.id.cartItemPrice);
            addBtn = itemView.findViewById(R.id.cartQuantityAdd);
            subBtn = itemView.findViewById(R.id.cartQuantitySub);
            quantity = itemView.findViewById(R.id.cartQuantity);
        }

        public void setData(CartModel cartModel) {
            if (cartModel != null) {
                ImagePoster.setImageResource(cartModel.getAll_model().getPosterImage());
                Name.setText(cartModel.getAll_model().getNameOfItem());
                price.setText(cartModel.getAll_model().getPrice());
            }
        }
    }
}






