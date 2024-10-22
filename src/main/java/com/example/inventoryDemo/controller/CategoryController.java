package com.example.inventoryDemo.controller;

import com.example.inventoryDemo.response.CategoryResponseREST;
import com.example.inventoryDemo.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<CategoryResponseREST> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseREST> getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }
}
