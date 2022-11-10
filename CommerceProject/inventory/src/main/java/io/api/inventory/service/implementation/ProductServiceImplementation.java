package io.api.inventory.service.implementation;

import io.api.inventory.data.entity.Product;
import io.api.inventory.data.repository.ProductRepository;
import io.api.inventory.service.ProductService;
import io.api.inventory.service.dto.ProductDto;
import io.api.inventory.service.mapping.ProductMap;
import io.api.inventory.service.mapping.ProductMapping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    private ProductRepository productRepository;
    private final ProductMapping mapping;
    public ProductServiceImplementation(ProductRepository productRepository, ProductMapping mapping) {
        this.productRepository = productRepository;
        this.mapping = mapping;
    }

    @Override
    public long createProduct(ProductDto productDto) {
        return 0;
    }

    @Override
    public void updateProduct(ProductDto productDto) {

    }

    @Override
    public ProductDto findProduct(long productId) {
        Product product = productRepository.getReferenceById(productId);
        ProductDto productDto = mapping.productToProductDto(product);
        return productDto;
    }

    @Override
    public List<ProductDto> findAllByCategory(String categoryName) {
        List<Product> products = productRepository.findAllByCategoryId(categoryName);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(mapping.productToProductDto(product));
        }
        return productDtos;
    }
}
