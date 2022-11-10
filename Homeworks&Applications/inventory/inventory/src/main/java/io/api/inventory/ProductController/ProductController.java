package io.api.inventory.ProductController;

import io.api.inventory.bussines.dto.ProductDto;
import io.api.inventory.bussines.implement.ProductServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ProductController{
    private final ProductServiceImplementation productServiceImplementation;

    public ProductController(ProductServiceImplementation productServiceImplementation) {
        this.productServiceImplementation = productServiceImplementation;
    }


    @GetMapping("/products/{name}")
    @ResponseBody
    public List<ProductDto> getAllProductsFromCategory(@PathVariable("name") String categoryName) {
        return productServiceImplementation.getAllProducts(categoryName);
    }
    @GetMapping("/product/{id}")
    @ResponseBody
    public ProductDto getProductById(@PathVariable("id") long productId) {
        return  productServiceImplementation.getProductById(productId);
    }
}
