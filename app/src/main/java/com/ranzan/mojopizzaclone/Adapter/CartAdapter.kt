package com.ranzan.mojopizzaclone.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ranzan.mojopizzaclone.Adapter.CartAdapter.CartViewHolder
import com.ranzan.mojopizzaclone.R
import com.ranzan.mojopizzaclone.communication.ItemClickListener
import java.util.*

class CartAdapter : RecyclerView.Adapter<CartViewHolder> {
    private var cartModelsList: ArrayList<CartModel>
    private var itemClickListener: ItemClickListener? = null

    constructor(cartModelsList: ArrayList<CartModel>, itemClickListener: ItemClickListener?) {
        this.cartModelsList = cartModelsList
        this.itemClickListener = itemClickListener
    }

    constructor(cartModelList: ArrayList<CartModel>) {
        cartModelsList = cartModelList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout, parent, false)
        return CartViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartModel = cartModelsList[position]
        holder.setData(cartModel)
    }

    override fun getItemCount(): Int {
        return cartModelsList.size
    }

    fun updateUI(cartModelList: ArrayList<CartModel>) {
        cartModelsList = cartModelList
        notifyDataSetChanged()
    }

    inner class CartViewHolder(itemView: View, itemClickListener: ItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        private var ImagePoster: ImageView? = null
        private var addBtn: ImageView? = null
        private var subBtn: ImageView? = null
        private var deleteBtn: ImageView? = null
        private var Name: TextView? = null
        private var price: TextView? = null
        private var quantity: TextView? = null
        private val itemClickListener: ItemClickListener?
        private val cardView: CardView? = null
        private fun initView(itemView: View) {
            ImagePoster = itemView.findViewById(R.id.cartImagePoster)
            Name = itemView.findViewById(R.id.cartItemName)
            price = itemView.findViewById(R.id.cartItemPrice)
            addBtn = itemView.findViewById(R.id.cartQuantityAdd)
            subBtn = itemView.findViewById(R.id.cartQuantitySub)
            quantity = itemView.findViewById(R.id.cartQuantity)
            deleteBtn = itemView.findViewById(R.id.cartItemDelete)
        }

        fun setData(cartModel: CartModel?) {
            if (cartModel != null) {
                ImagePoster!!.setImageResource(cartModel.all_model.posterImage)
                Name!!.text = cartModel.all_model.nameOfItem
                price!!.text = cartModel.all_model.price
                addBtn!!.setOnClickListener {
                    if (cartModel.quantity < 10) {
                        cartModel.quantity = cartModel.quantity + 1
                        quantity!!.text = cartModel.quantity.toString() + ""
                    } else Toast.makeText(ImagePoster!!.context, "Max", Toast.LENGTH_SHORT).show()
                }
                subBtn!!.setOnClickListener {
                    if (cartModel.quantity > 1) {
                        cartModel.quantity = cartModel.quantity - 1
                        quantity!!.text = cartModel.quantity.toString() + ""
                    } else Toast.makeText(ImagePoster!!.context, "Min", Toast.LENGTH_SHORT).show()
                }
                deleteBtn!!.setOnClickListener {
                    itemClickListener!!.onItemClick(
                        adapterPosition,
                        cartModel.all_model
                    )
                }
            }
        }

        init {
            initView(itemView)
            this.itemClickListener = itemClickListener
        }
    }
}