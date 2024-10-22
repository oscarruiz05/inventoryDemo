package com.example.inventoryDemo.dao;

import com.example.inventoryDemo.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {
}
