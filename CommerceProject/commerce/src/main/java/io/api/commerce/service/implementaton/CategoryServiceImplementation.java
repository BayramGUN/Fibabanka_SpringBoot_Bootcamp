package io.api.commerce.service.implementaton;

import io.api.commerce.data.component.ProductComponent;
import io.api.commerce.data.dto.CategoryDto;
import io.api.commerce.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {
    private final ProductComponent productComponent;

    public CategoryServiceImplementation(ProductComponent productComponent) {
        this.productComponent = productComponent;
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<CategoryDto> categoryDtos = productComponent.getCategories();

        return categoryDtos;
    }
}
