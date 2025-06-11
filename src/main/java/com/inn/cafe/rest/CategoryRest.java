package com.inn.cafe.rest;

import com.inn.cafe.POJO.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/category")
public interface CategoryRest {
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody(required = true)Category category);

    @GetMapping
    public ResponseEntity<List<Category>>getAllCategories();

    @PutMapping
    public ResponseEntity<Category>updateCategory(@RequestParam(required = true)int categoryId,@RequestBody(required = true)Category category);
}
