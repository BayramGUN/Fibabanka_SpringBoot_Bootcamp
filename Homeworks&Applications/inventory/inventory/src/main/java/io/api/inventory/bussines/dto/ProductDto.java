package io.api.inventory.bussines.dto;

import io.api.inventory.data.entity.Category;

public class ProductDto {
    private String productName;
    private double salesPrice;
    private String categoryName;
    public  ProductDto() {}
    public ProductDto(long productId, String productName, double salesPrice, String categoryName) {
        this.productName = productName;
        this.salesPrice = salesPrice;
        this.categoryName = categoryName;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
