package com.inn.cafe.service;

import com.inn.cafe.POJO.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category>getAll();
    Category updateCategory(int categoryId,Category category);
}
