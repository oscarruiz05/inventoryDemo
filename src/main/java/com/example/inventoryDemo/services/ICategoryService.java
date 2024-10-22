package com.example.inventoryDemo.services;

import com.example.inventoryDemo.response.CategoryResponseREST;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    public ResponseEntity<CategoryResponseREST> getAll();
}
