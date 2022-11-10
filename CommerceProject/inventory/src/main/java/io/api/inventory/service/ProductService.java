package io.api.inventory.service;

import io.api.inventory.service.dto.ProductDto;

import java.util.List;

public interface ProductService {
    long createProduct(ProductDto productDto);
    void updateProduct(ProductDto productDto);
    ProductDto findProduct(long productId);
    List<ProductDto> findAllByCategory(String categoryId);
}
