package io.api.inventory.service.mapping;

import io.api.inventory.data.entity.Category;
import io.api.inventory.data.entity.Product;
import io.api.inventory.service.dto.CategoryDto;
import io.api.inventory.service.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapping implements CategoryMap{
    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        List<String> productNames = new ArrayList<>();
        for (Product p : category.getProductList()) {
            productNames.add(p.getProductName());
        }
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setProductName(productNames);
        return categoryDto;
    }
}
