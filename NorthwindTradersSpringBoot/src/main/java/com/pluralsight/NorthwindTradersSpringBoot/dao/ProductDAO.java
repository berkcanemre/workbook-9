package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDAO {
    void add(Product product);
    List<Product> getAll();
    void delete(int productId);
    Product findByName(String name);
    void update(Product updatedProduct);
}