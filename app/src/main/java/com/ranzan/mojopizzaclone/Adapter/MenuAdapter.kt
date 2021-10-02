package com.ranzan.mojopizzaclone.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ranzan.mojopizzaclone.Adapter.MenuAdapter.MenuViewHolder
import com.ranzan.mojopizzaclone.R
import com.ranzan.mojopizzaclone.communication.ItemClickListener
import java.util.*

class MenuAdapter(
    private val all_modelsList: ArrayList<All_Model>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_data, parent, false)
        return MenuViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val all_model = all_modelsList[position]
        holder.setData(all_model)
    }

    override fun getItemCount(): Int {
        return all_modelsList.size
    }

    inner class MenuViewHolder(itemView: View, private val itemClickListener: ItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        private var TvName: TextView? = null
        private var TvName_1: TextView? = null
        private var TvDetail: TextView? = null
        private var TvDetail_1: TextView? = null
        private var TvPosterImage: ImageView? = null
        private var TvPrize: TextView? = null
        private var relativeLayout: RelativeLayout? = null
        private fun initView(itemView: View) {
            TvName = itemView.findViewById(R.id.nameofitem)
            TvName_1 = itemView.findViewById(R.id.nameofitem_2)
            TvDetail = itemView.findViewById(R.id.aboutItem)
            TvDetail_1 = itemView.findViewById(R.id.aboutItem_2)
            TvPosterImage = itemView.findViewById(R.id.imageifitem)
            TvPrize = itemView.findViewById(R.id.prize)
            relativeLayout = itemView.findViewById(R.id.item_RelativeLayout)
        }

        fun setData(all_model: All_Model) {
            TvName!!.text = all_model.nameOfItem
            TvName_1!!.text = all_model.nameOfItem_1
            TvDetail!!.text = all_model.detailOfItem
            TvDetail_1!!.text = all_model.detailOfItem_1
            TvPosterImage!!.setImageResource(all_model.posterImage)
            TvPrize!!.text = all_model.price
            relativeLayout!!.setOnClickListener {
                itemClickListener.onItemClick(
                    adapterPosition, all_model
                )
            }
        }

        init {
            initView(itemView)
        }
    }
}