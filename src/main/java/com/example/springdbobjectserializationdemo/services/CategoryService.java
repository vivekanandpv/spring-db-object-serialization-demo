package com.example.springdbobjectserializationdemo.services;

import com.example.springdbobjectserializationdemo.models.Category;
import com.example.springdbobjectserializationdemo.repositories.CategoryRepository;
import com.example.springdbobjectserializationdemo.utils.DomainViewModelMapper;
import com.example.springdbobjectserializationdemo.viewmodels.CategoryCreateViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.CategoryQueryViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryById(int id) {
        CategoryQueryViewModel viewModel = this.categoryRepository.getCategory(id);
        return DomainViewModelMapper.toDomain(viewModel);
    }

    public List<Category> getCategories() {
        return this.categoryRepository.getCategories()
                .stream()
                .map(DomainViewModelMapper::toDomain)
                .collect(Collectors.toList());
    }

    public CategoryQueryViewModel getCategoryQueryViewModel(int id) {
        return this.categoryRepository.getCategory(id);
    }

    public void createCategory(CategoryCreateViewModel viewModel) {
        this.categoryRepository.createItem(viewModel);
    }
}
