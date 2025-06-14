package com.inn.cafe.serviceImpl;

import com.inn.cafe.DTO.ProductForGet;
import com.inn.cafe.POJO.Category;
import com.inn.cafe.POJO.Product;
import com.inn.cafe.dao.CategoryRepository;
import com.inn.cafe.dao.ProductRepository;
import com.inn.cafe.mapper.ProductMapper;
import com.inn.cafe.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductForGet createProduct(Product product) {
        return ProductMapper.productToProductForGetSingle(productRepository.save(product));
    }

    @Override
    public List<ProductForGet> getAllProducts(int page,int size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Product> productPage=productRepository.findAll(pageable);
        List<ProductForGet>productForGetList=productPage.stream().map(p->ProductMapper.productToProductForGetAll(p)).toList();
        return productForGetList;
    }

    @Override
    public ProductForGet updateProduct(Product product) {
        return null;
    }

    @Override
    public String assignProductOnCategory(int productId, int categoryId) {
        Optional<Category> categoryOption=categoryRepository.findById(categoryId);
        Optional<Product>productOption=productRepository.findById(productId);
        if(categoryOption.isPresent()&&productOption.isPresent()){
            Category category=categoryOption.get();
            Product product=productOption.get();
            category.addProductToCategory(product);
            productRepository.save(product);
            return "Product added to category successfully";
        }
        throw new RuntimeException("Category or product not found");
    }

    @Override
    public ProductForGet getProductById(int productId) {
        return ProductMapper.productToProductForGetSingle(productRepository.findById(productId).get());
    }
}
