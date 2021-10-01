package com.ranzan.mojopizzaclone.CartAdapter;

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
    private ArrayList<CartModel> cartModelsList;
    public CartAdapter(ArrayList<CartModel> cartModelList){
        this.cartModelsList = cartModelList;
    }
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
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

   public  void updateUI(ArrayList<CartModel> cartModelList){
        this.cartModelsList=cartModelList;
        notifyDataSetChanged();
    }
}
class CartViewHolder extends RecyclerView.ViewHolder{
    private ImageView ImagePoster;
    private TextView Name;
    private TextView Prize;
    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        ImagePoster= itemView.findViewById(R.id.TvCartImageItem);
        Name  = itemView.findViewById(R.id.CartNameItem);
        Prize  = itemView.findViewById(R.id.CartprizeItem);
    }
    public void setData(CartModel cartModel){
        ImagePoster.setImageResource(cartModel.getImage());
        Name.setText(cartModel.getName());
        Prize.setText(cartModel.getPrize());
    }
}
