package com.example.springdbobjectserializationdemo.services;

import com.example.springdbobjectserializationdemo.models.Category;
import com.example.springdbobjectserializationdemo.models.Item;
import com.example.springdbobjectserializationdemo.viewmodels.CategoryCreateViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.ItemCreateViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemCategoryService {
    private final ItemService itemService;
    private final CategoryService categoryService;

    public ItemCategoryService(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
    }

    public Item getItem(int id) {
        return this.itemService.getItem(id);
    }

    public List<Item> getItems() {
        return this.itemService.getItems();
    }

    public void createItem(ItemCreateViewModel viewModel) {
        this.itemService.createItem(viewModel);
    }

    public Category getCategory(int id) {
        Category category = this.categoryService.getCategoryById(id);
        category.setItems(this.itemService.getItemsByCategoryId(id));

        return category;
    }

    public List<Category> getCategories() {
        return this.categoryService.getCategories()
                .stream()
                .map(c -> {
                    c.setItems(this.itemService.getItemsByCategoryId(c.getId()));
                    return c;
                })
                .collect(Collectors.toList());
    }

    public void createCategory(CategoryCreateViewModel viewModel) {
        this.categoryService.createCategory(viewModel);
    }
}
