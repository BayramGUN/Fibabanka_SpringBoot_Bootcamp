package io.api.inventory.service.mapping;

import io.api.inventory.data.entity.Product;
import io.api.inventory.service.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapping implements ProductMap{
    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        return product;
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setSalesPrice(product.getSalesPrice());
        productDto.setCategoryName(product.getCategory().getCategoryName());
        return productDto;
    }
}
