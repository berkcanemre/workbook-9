package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private List<Product> products = Arrays.asList(
            new Product(1, "Chai", "Beverages", 18.00),
            new Product(2, "Chang", "Beverages", 19.00),
            new Product(3, "Aniseed Syrup", "Condiments", 10.00),
            new Product(4, "Chef Anton's Cajun Seasoning", "Condiments", 22.00)
    );

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double price) {

        return products.stream()
                .filter(p -> name == null || p.getName().equalsIgnoreCase(name))
                .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                .filter(p -> price == null || p.getPrice() == price)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst()
                .orElse(null);
    }
}