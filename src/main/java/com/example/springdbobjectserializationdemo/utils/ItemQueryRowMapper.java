package com.example.springdbobjectserializationdemo.utils;

import com.example.springdbobjectserializationdemo.viewmodels.ItemQueryViewModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemQueryRowMapper implements RowMapper<ItemQueryViewModel> {

    @Override
    public ItemQueryViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemQueryViewModel viewModel = new ItemQueryViewModel();
        viewModel.setId(rs.getInt("id"));
        viewModel.setName(rs.getString("name"));
        viewModel.setPrice(rs.getDouble("price"));


        return viewModel;
    }
}