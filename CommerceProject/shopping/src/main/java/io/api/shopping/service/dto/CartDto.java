package io.api.shopping.service.dto;


import io.api.shopping.data.entity.CartProduct;
import io.api.shopping.enumeration.CartStatus;

import java.util.List;

public class CartDto {
    private long cartId;
    private String customerName;
    private List<CartProductDto> cartProductDtos;
    private double totalAmount;

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCartProductDtos(List<CartProductDto> cartProductDtos) {
        this.cartProductDtos = cartProductDtos;
    }

    public List<CartProductDto> getCartProductDtos() {
        return cartProductDtos;
    }

}
