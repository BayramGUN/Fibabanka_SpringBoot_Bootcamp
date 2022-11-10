package io.api.commerce.service.model;

public class CartProductModel {
    private long cartId;
    private String cartProductName;
    private int salesQuantity;
    private double salesPrice;
    private long productId;

    public String getCartProductName() {
        return cartProductName;
    }

    public void setCartProductName(String cartProductName) {
        this.cartProductName = cartProductName;
    }

    public long getProductId() {
        return productId;
    }

    public void setCartProductId(long productId) {
        this.productId = productId;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }



    public long getCartId() {
        return cartId;
    }
    public void setCartId(long cartId) {
        this.cartId = cartId;
    }
}
