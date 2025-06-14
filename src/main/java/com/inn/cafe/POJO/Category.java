package com.inn.cafe.POJO;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",unique = true,nullable = true)
    private String name;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product>products;


    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void addProductToCategory(Product product){
        if(products==null){
            products=new ArrayList<>();
        }
        products.add(product);
        product.setCategory(this);
    }
}
