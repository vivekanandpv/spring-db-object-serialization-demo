package com.example.springdbobjectserializationdemo.utils;

import com.example.springdbobjectserializationdemo.models.Category;
import com.example.springdbobjectserializationdemo.models.Item;
import com.example.springdbobjectserializationdemo.viewmodels.CategoryQueryViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.ItemCategoryQueryViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.ItemQueryViewModel;

public class DomainViewModelMapper {
    public static Item toDomain(ItemQueryViewModel viewModel) {
        Item item = new Item();

        item.setId(viewModel.getId());
        item.setPrice(viewModel.getPrice());
        item.setName(viewModel.getName());

        return item;
    }

    public static Item toDomain(ItemCategoryQueryViewModel viewModel) {
        Item item = new Item();
        Category category = new Category();

        item.setId(viewModel.getId());
        item.setPrice(viewModel.getPrice());
        item.setName(viewModel.getItemName());

        category.setId(viewModel.getCategoryId());
        category.setTaxRate(viewModel.getTaxRate());
        category.setName(viewModel.getCategoryName());
        category.setDescription(viewModel.getDescription());

        item.setCategory(category);

        return item;
    }

    public static Category toDomain(CategoryQueryViewModel viewModel) {
        Category category = new Category();

        category.setId(viewModel.getId());
        category.setDescription(viewModel.getDescription());
        category.setName(viewModel.getName());
        category.setTaxRate(viewModel.getTaxRate());

        return category;
    }
}
