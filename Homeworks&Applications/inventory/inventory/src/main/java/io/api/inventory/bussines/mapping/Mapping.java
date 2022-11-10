package io.api.inventory.bussines.mapping;

import io.api.inventory.bussines.dto.ProductDto;
import io.api.inventory.data.entity.Product;

public interface Mapping {
    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);
}
