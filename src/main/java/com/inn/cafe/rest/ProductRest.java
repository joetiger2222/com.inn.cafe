package com.inn.cafe.rest;

import com.inn.cafe.DTO.ProductForGet;
import com.inn.cafe.POJO.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/product")
public interface ProductRest {
    @PostMapping
    public ResponseEntity<ProductForGet>createProduct(@RequestBody(required = true) Product product);

    @GetMapping
    public ResponseEntity<List<ProductForGet>>getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @PutMapping
    public ResponseEntity<String>assignProductToCategory(@RequestParam(required = true)int productId,@RequestParam(required = true)int categoryId);
    @GetMapping(path = "/single")
    public ResponseEntity<ProductForGet>getSingleProduct(@RequestParam(required = true)int productId);
}
