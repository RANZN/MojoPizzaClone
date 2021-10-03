package com.ranzan.mojopizzaclone.ImageSlider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;
import com.ranzan.mojopizzaclone.R;

import java.util.List;
import java.util.zip.Inflater;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.SlideHolder> {
    private List<ImageSliderClass> sliderItem;
    private ViewPager2 viewPager2;

    public ImageSliderAdapter(List<ImageSliderClass> sliderItem, ViewPager2 viewPager2) {
        this.sliderItem = sliderItem;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SlideHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SlideHolder holder, int position) {
        ImageSliderClass imageSliderClass= sliderItem.get(position);
        holder.setimage(imageSliderClass);
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItem.addAll(sliderItem);
            notifyDataSetChanged();
        }
    };

    @Override
    public int getItemCount() {
        return sliderItem.size();
    }

    public class SlideHolder extends RecyclerView.ViewHolder{
        private RoundedImageView roundedImageView;
        public SlideHolder(@NonNull View itemView) {
            super(itemView);
            roundedImageView=itemView.findViewById(R.id.image_slider_item);
        }
        void setimage(ImageSliderClass imageSliderClass)
        {
            roundedImageView.setImageResource(imageSliderClass.getImg());
        }
    }
}
