package com.cpan252.brands.controller;
import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cpan252.brands.repository.itemRepository;
import com.cpan252.brands.model.item;
import com.cpan252.brands.model.item.Brand;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @GetMapping
    public String order() {
        return "order";
    }


    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("brands converted to string:  {}", brands);
    }


    @Autowired
    private itemRepository itemRepository;


    @ModelAttribute
    public item item() {
        return item
                .builder()
                .build();
    }


    @PostMapping
    public String processitemAddition(@Valid item item, BindingResult result) {
        if (result.hasErrors()) {
            return "/order";
        }
            log.info("Processing item: {}", item);
            itemRepository.save(item);
            return "redirect:/itemlist";
}}
