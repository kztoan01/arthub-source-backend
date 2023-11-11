package com.example.ArtHub.DTO;

import java.util.List;

public class CheckoutDTO {
    private int accountId;
    private List<CartDTO> cartItems;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<CartDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartDTO> cartItems) {
        this.cartItems = cartItems;
    }
}
