package com.titos.balancetogether.controller;

import com.titos.balancetogether.dto.CategoryDto;
import com.titos.balancetogether.dto.CreateCategoryRequest;
import com.titos.balancetogether.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public CategoryDto create(@RequestBody CreateCategoryRequest request) {
        return categoryService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
