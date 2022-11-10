package io.api.inventory.data.entity;


import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String productName;
    private double salesPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    public Product() {}

    public Product(long productId, String productName, double salesPrice, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.salesPrice = salesPrice;
        this.category = category;
    }

    public void setCategory(String categoryName) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}
