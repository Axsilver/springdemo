package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.*;
import com.example.demo.Entities.*;
import com.example.demo.Services.*;
import com.example.demo.Services.Implementations.ItemServiceImplementation;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    @Autowired
    ItemServiceImplementation itemService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/allItems")
    public String allItems(Model model) {
        List<Item> listItems = itemService.getAllItems();
        System.out.println(listItems);
        model.addAttribute("listItems", listItems);
        return "allItems";
    }

    @GetMapping("/addItem")
    public String addItem(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "addItem";
    }

    @GetMapping("/editItem")
    public String editItem(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "editItem";
    }

    @PostMapping("/editItem")
    public String editItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "editItem";
    }

    @GetMapping("/deleteItem")
    public String deleteItem(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);
        return "deleteItem";
    }

    @PostMapping("/deleteItem")
    public String deleteItem(@ModelAttribute("item") Item item) {
        itemService.deleteItemById(item.getId());
        return "deleteItem";
    }
}
