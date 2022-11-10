package io.api.commerce.service.mapping;

import io.api.commerce.data.dto.ProductDto;
import io.api.commerce.service.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapping implements ProductMap{
    @Override
    public ProductDto productModelToProductDto(ProductModel productModel) {
        return null;
    }

    @Override
    public ProductModel prodoctDtoToProductModel(ProductDto productDto) {
        ProductModel productModel = new ProductModel();
        productModel.setProductName(productDto.getProductName());
        productModel.setCategoryName(productDto.getCategoryName());
        productModel.setSalesPrice(productDto.getSalesPrice());
        return productModel;
    }
}
