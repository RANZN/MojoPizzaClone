package com.ranzan.mojopizzaclone.ImageSlider

import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderClass
import androidx.viewpager2.widget.ViewPager2
import androidx.recyclerview.widget.RecyclerView
import com.ranzan.mojopizzaclone.ImageSlider.ImageSliderAdapter.SlideHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.ranzan.mojopizzaclone.R
import com.makeramen.roundedimageview.RoundedImageView

class ImageSliderAdapter(
    private val sliderItem: List<ImageSliderClass>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<SlideHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideHolder {
        return SlideHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slider_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SlideHolder, position: Int) {
        val imageSliderClass = sliderItem[position]
        holder.setimage(imageSliderClass)
    }

    override fun getItemCount(): Int {
        return sliderItem.size
    }

    inner class SlideHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val roundedImageView: RoundedImageView
        fun setimage(imageSliderClass: ImageSliderClass) {
            roundedImageView.setImageResource(imageSliderClass.img)
        }

        init {
            roundedImageView = itemView.findViewById(R.id.image_slider_item)
        }
    }
}