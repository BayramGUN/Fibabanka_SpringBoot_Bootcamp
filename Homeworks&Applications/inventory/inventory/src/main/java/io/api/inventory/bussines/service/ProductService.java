package io.api.inventory.bussines.service;

import io.api.inventory.bussines.dto.ProductDto;

import java.util.List;


public interface ProductService {
    ProductDto getProductById(long productId);
    List<ProductDto> getAllProducts(String categoryName);
    void deleteProductById(long productId);
    void updateProductById(ProductDto productDto);
    long insertProduct(ProductDto productDto);

}
