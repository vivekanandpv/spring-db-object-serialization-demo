package com.example.springdbobjectserializationdemo.utils;

import com.example.springdbobjectserializationdemo.viewmodels.ItemCategoryQueryViewModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemCategoryQueryRowMapper implements RowMapper<ItemCategoryQueryViewModel> {

    @Override
    public ItemCategoryQueryViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemCategoryQueryViewModel viewModel = new ItemCategoryQueryViewModel();
        viewModel.setId(rs.getInt(1));
        viewModel.setItemName(rs.getString(2));
        viewModel.setPrice(rs.getDouble(3));
        viewModel.setCategoryId(rs.getInt(4));
        viewModel.setCategoryName(rs.getString(5));
        viewModel.setTaxRate(rs.getDouble(6));
        viewModel.setDescription(rs.getString(7));

        return viewModel;
    }
}