package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private List<Category> categories = Arrays.asList(
            new Category(1, "Beverages"),
            new Category(2, "Condiments"),
            new Category(3, "Confections")
    );

    @GetMapping
    public List<Category> getAllCategories() {
        return categories;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categories.stream()
                .filter(c -> c.getCategoryId() == id)
                .findFirst()
                .orElse(null);
    }
}