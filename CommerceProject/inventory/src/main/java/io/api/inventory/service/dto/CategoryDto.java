package io.api.inventory.service.dto;

import io.api.inventory.data.entity.Product;

import java.util.List;

public class CategoryDto {
    private String categoryName;
    private List<String> productName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getProductName() {
        return productName;
    }

    public void setProductName(List<String> productName) {
        this.productName = productName;
    }
}
