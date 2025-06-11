package com.inn.cafe.serviceImpl;

import com.inn.cafe.POJO.Category;
import com.inn.cafe.dao.CategoryRepository;
import com.inn.cafe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(int categoryId, Category category) {
        Optional<Category>categoryOptional =categoryRepository.findById(categoryId);
        if(categoryOptional.isPresent()){
            category.setId(categoryId);
            return categoryRepository.save(category);
        }else{
            throw new RuntimeException("category not found");
        }
    }
}
