package com.ranzan.mojopizzaclone.Adapter;

public class All_Model {
    private String NameOfItem;
    private String NameOfItem_1;
    private String DetailOfItem;
    private String DetailOfItem_1;
    private int PosterImage;
    private String Prize;

    public All_Model(String nameOfItem, String nameOfItem_1, String detailOfItem, String detailOfItem_1, int posterImage, String prize) {
        NameOfItem = nameOfItem;
        NameOfItem_1 = nameOfItem_1;
        DetailOfItem = detailOfItem;
        DetailOfItem_1 = detailOfItem_1;
        PosterImage = posterImage;
        Prize = prize;
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
        return PosterImage;
    }

    public String getPrize() {
        return Prize;
    }
}
