package io.api.inventory.service.implementation;


import io.api.inventory.data.entity.Category;
import io.api.inventory.data.entity.Product;
import io.api.inventory.data.repository.CategoryRepository;
import io.api.inventory.service.CategoryService;
import io.api.inventory.service.dto.CategoryDto;
import io.api.inventory.service.mapping.CategoryMapping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapping mapping;
    public CategoryServiceImplementation(
            CategoryRepository categoryRepository,
            CategoryMapping mapping) {
        this.categoryRepository = categoryRepository;
        this.mapping = mapping;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            categoryDtos.add(mapping.categoryToCategoryDto(category));
        }
        return categoryDtos;
    }
}
