package com.example.springdbobjectserializationdemo.repositories;

import com.example.springdbobjectserializationdemo.utils.CategoryQueryRowMapper;
import com.example.springdbobjectserializationdemo.viewmodels.CategoryCreateViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.CategoryQueryViewModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CategoryQueryViewModel getCategory(int id) {
        String sql = "SELECT id, name, tax_rate, description FROM category WHERE id =?";
        RowMapper<CategoryQueryViewModel> rowMapper = new CategoryQueryRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<CategoryQueryViewModel> getCategories() {
        String sql = "SELECT id, name, tax_rate, description FROM category";
        RowMapper<CategoryQueryViewModel> rowMapper = new CategoryQueryRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void createItem(CategoryCreateViewModel viewModel) {
        String sql = "INSERT INTO public.category(name, tax_rate, description)	VALUES (?, ?, ?)";
        this.jdbcTemplate.update(sql, viewModel.getName(), viewModel.getTaxRate(),
                viewModel.getDescription());
    }
}
