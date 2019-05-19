package com.receipt.calculator.model;

public class CartItem {

    private Item item;
    private float quantity;

    public CartItem(Item item, float quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public float getQuantity() {
        return quantity;
    }
}
