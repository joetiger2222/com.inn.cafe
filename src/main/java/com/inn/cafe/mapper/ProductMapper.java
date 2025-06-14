package com.inn.cafe.mapper;

import com.inn.cafe.DTO.ProductForGet;
import com.inn.cafe.POJO.Product;

public class ProductMapper {
    public static ProductForGet productToProductForGetAll(Product product){
        return new ProductForGet(product.getId(),product.getName());
    }
    public static ProductForGet productToProductForGetSingle(Product product){
        return new ProductForGet(product.getId(),product.getName(),product.getCategory().getName());
    }
    public static Product productToProductForGet(ProductForGet productForGet){
        return new Product(productForGet.getName());
    }
}
