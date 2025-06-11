package com.inn.cafe.dao;

import com.inn.cafe.POJO.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
