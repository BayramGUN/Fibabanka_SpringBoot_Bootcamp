package io.api.commerce.data.dto;

import java.util.List;

public class CartDto {
    private long cartId;
    private String customerName;
    private double totalAmount;
    private List<CartProductDto> cartProductDtos;

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public List<CartProductDto> getCartProductDtos() {
        return cartProductDtos;
    }

    public void setCartProductDtos(List<CartProductDto> cartProductDtos) {
        this.cartProductDtos = cartProductDtos;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
