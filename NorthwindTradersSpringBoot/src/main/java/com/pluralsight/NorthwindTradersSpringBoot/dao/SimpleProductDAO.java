package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO {
    private List<Product> products;

    public SimpleProductDAO() {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 999.99));
        products.add(new Product(2, "Book", "Education", 19.99));
        products.add(new Product(3, "Coffee Mug", "Kitchen", 7.49));
    }

    @Override
    public void add(Product product) {
        products.add(product); // Add new product to the list
    }

    @Override
    public List<Product> getAll() {
        return products; // Return all products
    }

    @Override
    public void delete(int productId) {
        products.removeIf(p -> p.getProductId() == productId); // Remove by ID
    }

    @Override
    public Product findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null); // Search by name (case-insensitive)
    }

    @Override
    public void update(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == updatedProduct.getProductId()) {
                products.set(i, updatedProduct); // Replace with updated product
                return;
            }
        }
    }
}