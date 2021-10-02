package com.ranzan.mojopizzaclone.Adapter;

import java.io.Serializable;

public class All_Model implements Serializable {
    private String NameOfItem;
    private String NameOfItem_1;
    private String DetailOfItem;
    private String DetailOfItem_1;
    private int posterImage;
    private String price;

    public All_Model(String nameOfItem, String nameOfItem_1, String detailOfItem, String detailOfItem_1, int posterImage, String price) {
        NameOfItem = nameOfItem;
        NameOfItem_1 = nameOfItem_1;
        DetailOfItem = detailOfItem;
        DetailOfItem_1 = detailOfItem_1;
        this.posterImage = posterImage;
        this.price = price;
    }

    public String getNameOfItem() {
        return NameOfItem;
    }

    public String getNameOfItem_1() {
        return NameOfItem_1;
    }

    public String getDetailOfItem() {
        return DetailOfItem;
    }

    public String getDetailOfItem_1() {
        return DetailOfItem_1;
    }

    public int getPosterImage() {
        return posterImage;
    }

    public String getPrice() {
        return price;
    }
}
