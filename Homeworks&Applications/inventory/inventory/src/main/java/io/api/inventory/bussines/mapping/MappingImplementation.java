package io.api.inventory.bussines.mapping;

import io.api.inventory.bussines.dto.ProductDto;
import io.api.inventory.data.entity.Category;
import io.api.inventory.data.entity.Product;
import io.api.inventory.data.repository.CategoryRepository;

public class MappingImplementation implements Mapping {
    private CategoryRepository categoryRepository;

    public MappingImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setSalesPrice(product.getSalesPrice());
        productDto.setCategoryName(product.getCategory().getCategoryName());
        return productDto;
    }

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        Category category = categoryRepository.findCategory(productDto.getCategoryName());
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        product.setCategory(category);
        return product;
    }
}
