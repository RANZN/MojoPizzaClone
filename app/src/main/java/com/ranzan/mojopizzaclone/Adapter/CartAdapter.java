package com.ranzan.mojopizzaclone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.mojopizzaclone.R;
import com.ranzan.mojopizzaclone.communication.ItemClickListener;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private ArrayList<CartModel> cartModelsList;
    private ItemClickListener itemClickListener;

    public CartAdapter(ArrayList<CartModel> cartModelsList, ItemClickListener itemClickListener) {
        this.cartModelsList = cartModelsList;
        this.itemClickListener = itemClickListener;
    }

    public CartAdapter(ArrayList<CartModel> cartModelList) {
        this.cartModelsList = cartModelList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
        return new CartViewHolder(view, itemClickListener);
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
        private ImageView ImagePoster, addBtn, subBtn, deleteBtn;
        private TextView Name, price, quantity;
        private ItemClickListener itemClickListener;
        private CardView cardView;

        public CartViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            initView(itemView);
            this.itemClickListener = itemClickListener;
        }

        private void initView(View itemView) {
            ImagePoster = itemView.findViewById(R.id.cartImagePoster);
            Name = itemView.findViewById(R.id.cartItemName);
            price = itemView.findViewById(R.id.cartItemPrice);
            addBtn = itemView.findViewById(R.id.cartQuantityAdd);
            subBtn = itemView.findViewById(R.id.cartQuantitySub);
            quantity = itemView.findViewById(R.id.cartQuantity);
            deleteBtn = itemView.findViewById(R.id.cartItemDelete);
        }

        public void setData(CartModel cartModel) {
            if (cartModel != null) {
                ImagePoster.setImageResource(cartModel.getAll_model().getPosterImage());
                Name.setText(cartModel.getAll_model().getNameOfItem());
                price.setText(cartModel.getAll_model().getPrice());
                addBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cartModel.getQuantity() < 10) {
                            cartModel.setQuantity(cartModel.getQuantity()+1    );
                            quantity.setText(cartModel.getQuantity() + "");
                        } else
                            Toast.makeText(ImagePoster.getContext(), "Max", Toast.LENGTH_SHORT).show();
                    }
                });
                subBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (cartModel.getQuantity() > 1) {
                            cartModel.setQuantity(cartModel.getQuantity() - 1);
                            quantity.setText(cartModel.getQuantity() + "");
                        } else
                            Toast.makeText(ImagePoster.getContext(), "Min", Toast.LENGTH_SHORT).show();
                    }
                });
                deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.onItemClick(getAdapterPosition(), cartModel.getAll_model());
                    }
                });
            }

        }
    }
}






