package com.inn.cafe.service;

import com.inn.cafe.DTO.ProductForGet;
import com.inn.cafe.POJO.Product;

import java.util.List;

public interface ProductService {
    ProductForGet createProduct(Product product);
    List<ProductForGet>getAllProducts(int page,int size);
    ProductForGet updateProduct(Product product);
    String assignProductOnCategory(int productId,int categoryId);
    ProductForGet getProductById(int productId);
}
