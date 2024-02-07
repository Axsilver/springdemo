package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.*;
import com.example.demo.Entities.*;

public interface ItemService {

    public void saveItem(Item item);

    public List<Item> getAllItems();

    public Item getItemById(Long itemId);

    public List<Item> getItemsByTitle(String title);

    public List<Item> getItemsByDescription(String description);

    public void deleteItem(Item item);

    public void deleteItemById(Long id);
}