package io.api.inventory.service.mapping;

import io.api.inventory.data.entity.Category;
import io.api.inventory.service.dto.CategoryDto;

public interface CategoryMap {
    CategoryDto categoryToCategoryDto(Category category);
}
