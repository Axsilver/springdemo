package com.example.demo.Services.Implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.*;
import com.example.demo.Entities.*;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Services.*;

@Service
public class ItemServiceImplementation implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()) {
            return item.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getItemsByTitle(String title) {
        return itemRepository.findByTitle(title);
    }

    @Override
    public List<Item> getItemsByDescription(String description) {
        return itemRepository.findByDescription(description);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
