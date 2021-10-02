package com.ranzan.mojopizzaclone.Adapter

import com.ranzan.mojopizzaclone.Adapter.HomeModel
import androidx.recyclerview.widget.RecyclerView
import com.ranzan.mojopizzaclone.Adapter.HomeAdapter.HomeViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.ranzan.mojopizzaclone.R
import androidx.cardview.widget.CardView
import com.ranzan.mojopizzaclone.communication.OnClickListener
import java.util.ArrayList

class HomeAdapter(
    private val imageButtons: ArrayList<HomeModel>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return HomeViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val model = imageButtons[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return imageButtons.size
    }

    inner class HomeViewHolder(itemView: View, onClickListener: OnClickListener) :
        RecyclerView.ViewHolder(itemView) {
        private var mImgBtn: ImageView? = null
        private lateinit var cardView: CardView
        private val onClickListener: OnClickListener
        private fun initViews(itemView: View) {
            mImgBtn = itemView.findViewById(R.id.imgImage)
            cardView = itemView.findViewById(R.id.cardView)
            cardView.setOnClickListener(View.OnClickListener {
                onClickListener.onClickRecyclerView(
                    adapterPosition
                )
            })
        }

        fun setData(model: HomeModel) {
            mImgBtn!!.setImageResource(model.imageId)
        }

        init {
            initViews(itemView)
            this.onClickListener = onClickListener
        }
    }
}