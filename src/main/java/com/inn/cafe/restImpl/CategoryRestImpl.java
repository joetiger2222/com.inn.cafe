package com.inn.cafe.restImpl;

import com.inn.cafe.POJO.Category;
import com.inn.cafe.rest.CategoryRest;
import com.inn.cafe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRestImpl implements CategoryRest {
    @Autowired
    CategoryService categoryService;
    @Override
    public ResponseEntity<Category> createCategory(Category category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> updateCategory(int categoryId, Category category) {
        return new ResponseEntity<>(categoryService.updateCategory(categoryId,category),HttpStatus.OK);
    }
}
