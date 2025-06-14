package com.inn.cafe.restImpl;

import com.inn.cafe.DTO.ProductForGet;
import com.inn.cafe.POJO.Product;
import com.inn.cafe.rest.ProductRest;
import com.inn.cafe.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductRestImpl implements ProductRest {
    ProductService productService;

    public ProductRestImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductForGet> createProduct(Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductForGet>> getAllProducts(int page, int size) {
        return new ResponseEntity<>(productService.getAllProducts(page,size),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> assignProductToCategory(int productId, int categoryId) {
        return new ResponseEntity<>(productService.assignProductOnCategory(productId,categoryId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductForGet> getSingleProduct(int productId) {
        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }
}
