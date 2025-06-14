package com.inn.cafe.DTO;

import com.inn.cafe.POJO.Category;

public class ProductForGet {
    private int id;
    private String name;
    private String categoryName;

    public ProductForGet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductForGet(int id, String name, String categoryName) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
