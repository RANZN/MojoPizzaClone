package com.ranzan.mojopizzaclone.Adapter;

public class CartModel {
    private All_Model all_model;
    private int quantity;

    public CartModel(All_Model all_model, int quantity) {
        this.all_model = all_model;
        this.quantity = quantity;
    }

    public All_Model getAll_model() {
        return all_model;
    }

    public int getQuantity() {
        return quantity;
    }
}
