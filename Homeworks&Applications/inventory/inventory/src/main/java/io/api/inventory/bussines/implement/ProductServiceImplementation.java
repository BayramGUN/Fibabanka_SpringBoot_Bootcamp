package io.api.inventory.bussines.implement;

import io.api.inventory.bussines.dto.ProductDto;
import io.api.inventory.bussines.mapping.Mapping;
import io.api.inventory.bussines.service.ProductService;
import io.api.inventory.data.entity.Category;
import io.api.inventory.data.entity.Product;
import io.api.inventory.data.repository.CategoryRepository;
import io.api.inventory.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final Mapping mapping;

    public ProductServiceImplementation(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            Mapping mapping) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.mapping = mapping;
    }

    @Override
    public ProductDto getProductById(long productId) {
        Product product = productRepository.getReferenceById(productId);
        return mapping.productToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts(String categoryName) {
        Category category = categoryRepository.findCategory(categoryName);
        List<Product> products = productRepository.findAllByCategoryId(category.getCategoryId());
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products) {
            mapping.productToProductDto(product);
        }
        return productDtos;
    }

    @Override
    public void deleteProductById(long productId) {

    }

    @Override
    public void updateProductById(ProductDto productDto) {

    }

    @Override
    public long insertProduct(ProductDto productDto) {
        return 0;
    }
}
