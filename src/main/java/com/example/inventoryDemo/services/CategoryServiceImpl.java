package com.example.inventoryDemo.services;

import com.example.inventoryDemo.dao.ICategoryDao;
import com.example.inventoryDemo.model.Category;
import com.example.inventoryDemo.response.CategoryResponseREST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseREST> getAll() {
        CategoryResponseREST response = new CategoryResponseREST();
        try {
            List<Category> categoryList = (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategoryList(categoryList);
            response.setData("success", "200", "Request Success");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            response.setData("error", "500", "Internal Server Error");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseREST>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseREST>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseREST> getById(Long id) {
        CategoryResponseREST response = new CategoryResponseREST();
        if (id == null) {
            response.setData("error", "400", "The given id must not be null");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            Category category = categoryDao.findById(id).orElse(null);
            if (category == null) {
                response.setData("error", "404", "Category not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            response.getCategoryResponse().setCategory(category);
            response.setData("success", "200", "Request Success");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            response.setData("error", "500", "Internal Server Error");
            e.getStackTrace();
            return new ResponseEntity<CategoryResponseREST>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoryResponseREST>(response, HttpStatus.OK);
    }

}
