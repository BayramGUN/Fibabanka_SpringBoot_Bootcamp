package io.api.inventory.service;

import io.api.inventory.service.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
}
