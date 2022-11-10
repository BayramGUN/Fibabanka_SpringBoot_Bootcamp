package io.api.commerce.service.mapping;

import io.api.commerce.data.dto.ProductDto;
import io.api.commerce.service.model.ProductModel;

public interface ProductMap {
    ProductDto productModelToProductDto(ProductModel productModel);
    ProductModel prodoctDtoToProductModel(ProductDto productDto);
}
