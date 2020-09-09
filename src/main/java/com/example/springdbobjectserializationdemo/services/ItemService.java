package com.example.springdbobjectserializationdemo.services;

import com.example.springdbobjectserializationdemo.models.Item;
import com.example.springdbobjectserializationdemo.repositories.ItemRepository;
import com.example.springdbobjectserializationdemo.utils.DomainViewModelMapper;
import com.example.springdbobjectserializationdemo.viewmodels.ItemCreateViewModel;
import com.example.springdbobjectserializationdemo.viewmodels.ItemQueryViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItem(int id) {
        return DomainViewModelMapper.toDomain(this.itemRepository.getItem(id));
    }

    public List<Item> getItems() {
        return this.itemRepository.getItems()
                .stream()
                .map(DomainViewModelMapper::toDomain)
                .collect(Collectors.toList());
    }

    public Set<Item> getItemsByCategoryId(int categoryId) {
        List<ItemQueryViewModel> itemQueryViewModelList = this.itemRepository.getItemsByCategory(categoryId);
        return itemQueryViewModelList.stream()
                .map(vm -> {
                    Item item = new Item();
                    item.setId(vm.getId());
                    item.setPrice(vm.getPrice());
                    item.setName(vm.getName());

                    return item;
                })
                .collect(Collectors.toSet());
    }

    public Set<ItemQueryViewModel> getItemQueryViewModelSetByCategory(int categoryId) {
        return this.itemRepository.getItemsByCategory(categoryId)
                .stream()
                .collect(Collectors.toSet());
    }

    public void createItem(ItemCreateViewModel viewModel) {
        this.itemRepository.createItem(viewModel);
    }
}
