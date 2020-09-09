package com.example.springdbobjectserializationdemo.utils;

import com.example.springdbobjectserializationdemo.viewmodels.CategoryQueryViewModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryQueryRowMapper implements RowMapper<CategoryQueryViewModel> {

    @Override
    public CategoryQueryViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryQueryViewModel viewModel = new CategoryQueryViewModel();
        viewModel.setId(rs.getInt("id"));
        viewModel.setName(rs.getString("name"));
        viewModel.setTaxRate(rs.getDouble("tax_rate"));
        viewModel.setDescription(rs.getString("description"));

        return viewModel;
    }
}