package com.example.springdbobjectserializationdemo.controllers;

import com.example.springdbobjectserializationdemo.models.Category;
import com.example.springdbobjectserializationdemo.models.Item;
import com.example.springdbobjectserializationdemo.services.ItemCategoryService;
import com.example.springdbobjectserializationdemo.viewmodels.CategoryCreateViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.ItemCreateViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {
    private final ItemCategoryService itemCategoryService;

    public ProductsController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @GetMapping("items/{id}")
    public Item getItem(@PathVariable int id) {
        return this.itemCategoryService.getItem(id);
    }

    @GetMapping("items")
    public List<Item> getItems() {
        return this.itemCategoryService.getItems();
    }

    @PostMapping("items")
    public ResponseEntity createItem(@RequestBody ItemCreateViewModel viewModel) {
        this.itemCategoryService.createItem(viewModel);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("categories/{id}")
    public Category getCategory(@PathVariable int id) {
        return this.itemCategoryService.getCategory(id);
    }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return this.itemCategoryService.getCategories();
    }

    @PostMapping("categories")
    public ResponseEntity createCategory(@RequestBody CategoryCreateViewModel viewModel) {
        this.itemCategoryService.createCategory(viewModel);

        return new ResponseEntity(HttpStatus.OK);
    }
}
