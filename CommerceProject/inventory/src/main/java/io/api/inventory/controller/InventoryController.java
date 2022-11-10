package io.api.inventory.controller;

import io.api.inventory.data.repository.CategoryRepository;
import io.api.inventory.service.dto.CategoryDto;
import io.api.inventory.service.dto.ProductDto;
import io.api.inventory.service.implementation.CategoryServiceImplementation;
import io.api.inventory.service.implementation.ProductServiceImplementation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final ProductServiceImplementation productServiceImplementation;
    private final CategoryRepository repo;
    private final CategoryServiceImplementation categoryServiceImplementation;

    public InventoryController(
            ProductServiceImplementation productServiceImplementation,
            CategoryRepository repo,
            CategoryServiceImplementation categoryServiceImplementation) {
        this.productServiceImplementation = productServiceImplementation;
        this.repo = repo;
        this.categoryServiceImplementation = categoryServiceImplementation;
    }
    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories(){
        return categoryServiceImplementation.getAllCategories();
    }
    @GetMapping("/product/{id}")
    public ProductDto getProductById(@PathVariable("id") long productId) {
        return productServiceImplementation.findProduct(productId);
    }
    @GetMapping("/products/{name}")
    public List<ProductDto> getCategory(@PathVariable("name") String categoryName) {
        List<ProductDto> productDtoList = productServiceImplementation.findAllByCategory(categoryName);
        return productDtoList;
    }
    /* @GetMapping("/product/add")
    public long addProduct() {
        Category category = new Category(0, "electronics");
        category.setProductList(new ArrayList<>());
        Product product = new Product(0, "cell phone", 1250, category);
        category.getProductList().add(product);
        Product productTwo = new Product(0, "macbook", 22499.99, category);
        category.getProductList().add(productTwo);
        return product.getProductId();
    } */
}
