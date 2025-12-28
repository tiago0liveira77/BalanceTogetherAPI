package com.titos.balancetogether.service;


import com.titos.balancetogether.dto.CategoryDto;
import com.titos.balancetogether.dto.CreateCategoryRequest;
import com.titos.balancetogether.model.Category;
import com.titos.balancetogether.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<CategoryDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public CategoryDto create(CreateCategoryRequest request) {

        Category category = Category.builder()
                .name(request.name())
                .type(request.type())
                .system(true)
                .build();

        return toDto(repository.save(category));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    /* =========================
       MAPPER
       ========================= */

    private CategoryDto toDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getType(),
                category.isSystem()
        );
    }
}
