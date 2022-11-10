package com.example.service.controller;

import com.example.service.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductResource {
    @GetMapping("/api/product")
    public Product getProduct() {
        Product product = new Product(301, "Cep Telofonu", 1450.0);
        return product;
    }
    @GetMapping("/api/product/{id}")
    public Product getProductById(@PathVariable("id") long productId) {

        Product product = new Product(productId,"Cep telefonu", 1450.0);
        return product;
    }
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(302, "Dizüstü Bilgisayar", 6575.0));
        productList.add(new Product(303, "Akıllı Telefon", 4499.0));
        productList.add(new Product(304, "Masaüstü bilgisayar", 3490.0));
        return productList;
    }
    @PostMapping("/api/product")
    public Product addProduct(@RequestBody Product product) {
        product.setProductId(310);
        System.out.println("Ürün eklendi " + product.getProductId()
                + " " + product.getProductName()
                + " " + product.getSalesPrice()
        );
        return product;
    }
    @PutMapping("/api/product")
    public void updateProduct(@RequestBody Product product) {
        System.out.println("Ürün güncellendi " + product.getProductId()
                + " " + product.getProductName()
                + " " + product.getSalesPrice()
        );
    }
    @DeleteMapping("/api/product/{id}")
    public void deleteProductById(@PathVariable("id") long productId) {
        System.out.println(productId + " idli ürün silindi!");
    }
}
