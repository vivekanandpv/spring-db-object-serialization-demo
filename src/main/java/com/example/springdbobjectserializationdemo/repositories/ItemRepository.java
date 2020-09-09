package com.example.springdbobjectserializationdemo.repositories;

import com.example.springdbobjectserializationdemo.utils.ItemCategoryQueryRowMapper;
import com.example.springdbobjectserializationdemo.utils.ItemQueryRowMapper;
import com.example.springdbobjectserializationdemo.viewmodels.ItemCategoryQueryViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.ItemCreateViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.ItemQueryViewModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {
    private final JdbcTemplate jdbcTemplate;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ItemCategoryQueryViewModel getItem(int id) {
        String sql = "SELECT item.id, item.name, item.price, item.category_id, category.name, category.tax_rate, category.description FROM item INNER JOIN category ON (item.category_id = category.id) WHERE item.id =?";
        RowMapper<ItemCategoryQueryViewModel> rowMapper = new ItemCategoryQueryRowMapper();
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<ItemCategoryQueryViewModel> getItems() {
        String sql = "SELECT item.id, item.name, item.price, item.category_id, category.name, category.tax_rate, category.description FROM item INNER JOIN category ON (item.category_id = category.id)";
        RowMapper<ItemCategoryQueryViewModel> rowMapper = new ItemCategoryQueryRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void createItem(ItemCreateViewModel viewModel) {
        String sql = "INSERT INTO public.item(name, price, category_id)	VALUES (?, ?, ?)";
        this.jdbcTemplate.update(sql, viewModel.getName(), viewModel.getPrice(),
                viewModel.getCategoryId());
    }

    public List<ItemQueryViewModel> getItemsByCategory(int categoryId) {
        String sql = "SELECT id, name, price FROM item WHERE category_id =?";
        RowMapper<ItemQueryViewModel> rowMapper = new ItemQueryRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper, categoryId);
    }


}
