package com.ranzan.mojopizzaclone.CartAdapter;

public class CartModel {
    private String Name;
    private int Image;
    private String Prize;
    private int Total;

    public CartModel(String name, int image, String prize, int total) {
        Name = name;
        Image = image;
        Prize = prize;
        Total = total;
    }

    public String getName() {
        return Name;
    }

    public int getImage() {
        return Image;
    }

    public String getPrize() {
        return Prize;
    }

    public int getTotal() {
        return Total;
    }
}
