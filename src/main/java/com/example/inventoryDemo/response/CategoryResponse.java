package com.example.inventoryDemo.response;

import com.example.inventoryDemo.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {

    private List<Category> categoryList;
    private Category category;
}
