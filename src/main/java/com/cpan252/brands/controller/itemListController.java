package com.cpan252.brands.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.brands.repository.itemRepository;

@Controller
@RequestMapping("/itemlist")
public class itemListController {
    private itemRepository itemRepository;

    public itemListController(itemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String showitems(Model model) {
        return "itemlist";
    }

    @ModelAttribute
    public void items(Model model) {
        model.addAttribute("items", itemRepository.findAll());
    }
}
