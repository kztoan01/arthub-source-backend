package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.OrdersDetails;

import java.util.List;

public class CartResponse {
    private List<OrdersDetails> cartItems;
    private float totalAmount;

    public List<OrdersDetails> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<OrdersDetails> cartItems) {
        this.cartItems = cartItems;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public CartResponse(List<OrdersDetails> cartItems, float totalAmount) {
        this.cartItems = cartItems;
        this.totalAmount = totalAmount;
    }
}
