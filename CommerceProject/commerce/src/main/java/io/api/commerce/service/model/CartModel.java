package io.api.commerce.service.model;


import io.api.commerce.data.dto.CartProductDto;

import java.util.List;

public class CartModel {
    private String CustomerName;

    private List<CartProductDto> cartProductDtos;
    private double totalAmount;
    public String getCustomerName() {
        return CustomerName;
    }
    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public List<CartProductDto> getCartProductDtos() {
        return cartProductDtos;
    }

    public void setCartProductDtos(List<CartProductDto> cartProductDtos) {
        this.cartProductDtos = cartProductDtos;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
