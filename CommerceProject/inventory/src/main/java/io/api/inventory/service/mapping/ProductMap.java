package io.api.inventory.service.mapping;

import io.api.inventory.data.entity.Product;
import io.api.inventory.service.dto.ProductDto;


public interface ProductMap {
    Product productDtoToProduct(ProductDto productDto);
    ProductDto productToProductDto(Product product);
}
