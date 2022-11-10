package com.example.service.web.controller;


import com.example.service.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/product")
    @ResponseBody
    public String getProduct() {
        long productId = 360;
        String url = "http://localhost:8080/api/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println("Ürün: " + product.getProductName());
        return "<h1>Edinme başarılı!</h1><br>" + product.getProductName() + " adlı ürünün fiyatı: " + product.getSalesPrice() + " TL";
    }
    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct() {
        Product product = new Product(0, "Firitöz", 2199.99);
        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        Product result = restTemplate.postForObject(url, product, Product.class);
        return "<h1>Yollama başarılı!</h1><br>" + result.getProductId() + " numaralı id ile ürün oluşturuldu!";
    }
    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct() {
        Product product = new Product(302, "Tablet Bilgisayar", 3199.99);
        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<Product>(product),
                Void.class
        );

        // restTemplate.put(url, product);

        return "<h1>Koyma başarılı!</h1><br>" + product.getProductId() + " idli ürün güncellendi";
    }
    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct() {
        long productId = 303;
        String url = "http://localhost:8080/api/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "<h1>Silme başarılı!</h1><br>" + productId + " idli ürün silindi";
    }
}
