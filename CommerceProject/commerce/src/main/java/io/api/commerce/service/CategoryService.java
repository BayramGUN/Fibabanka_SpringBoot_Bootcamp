package io.api.commerce.service;

import io.api.commerce.data.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
}
