package com.inn.cafe.dao;

import com.inn.cafe.POJO.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
