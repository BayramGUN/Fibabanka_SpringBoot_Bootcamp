package io.api.commerce.controller.resource;

import io.api.commerce.data.dto.CategoryDto;
import io.api.commerce.service.implementaton.CategoryServiceImplementation;
import io.api.commerce.service.implementaton.ProductServiceImplementation;
import io.api.commerce.service.model.ProductModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/commerce")
public class ProductResource {
    private final ProductServiceImplementation productServiceImplementation;
    private final CategoryServiceImplementation categoryServiceImplementation;

    public ProductResource(
            ProductServiceImplementation productServiceImplementation,
            CategoryServiceImplementation categoryServiceImplementation
    ) {
        this.productServiceImplementation = productServiceImplementation;
        this.categoryServiceImplementation = categoryServiceImplementation;
    }

    @GetMapping("/product/{productId}")
    @ResponseBody
    public ResponseEntity<ProductModel> getProductById(@PathVariable("productId") long productId) {
        ProductModel productModel = productServiceImplementation.getProductById(productId);
        return ResponseEntity.ok(productModel);
    }
   @GetMapping("/products/{categoryName}")
   @ResponseBody
   public List<ProductModel> getAllProductByCategory(
           @PathVariable("categoryName") String categoryName) {
       return productServiceImplementation.getAllByCategory(categoryName);
   }
   @GetMapping("/categories")
   @ResponseBody
   public List<CategoryDto> getAllCategories() {
        return categoryServiceImplementation.getCategories();
   }
}
