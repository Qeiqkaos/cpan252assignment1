package com.cpan252.brands.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cpan252.brands.model.dto.ItemSearchByDTO;
import com.cpan252.brands.repository.itemRepository;
import java.time.LocalDate;
import java.util.Optional;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;
import com.cpan252.brands.repository.itemRepositoryPaginated;
@Controller
@RequestMapping("/itemlist")
public class itemListController {
    private static final int PAGE_SIZE = 5;
    private itemRepository itemRepository;

    private itemRepositoryPaginated itemRepositoryPaginated;

    public itemListController(itemRepository itemRepository,
            itemRepositoryPaginated itemRepositoryPaginated) {
        this.itemRepository = itemRepository;
        this.itemRepositoryPaginated = itemRepositoryPaginated;
    }

    @GetMapping
    public String showitems(Model model) {
        return "itemlist";
    }

    @ModelAttribute
    public void items(Model model) {
        var itemPage = itemRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("items", itemPage);
        model.addAttribute("currentPage", itemPage.getNumber());
        model.addAttribute("totalPages", itemPage.getTotalPages());
    }
    
    @GetMapping("/switchPage")
    public String switchPage(Model model,
            @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "itemlist";
        }
        var itemPage = itemRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0),
                PAGE_SIZE));
        model.addAttribute("items", itemPage.getContent());
        model.addAttribute("currentPage", itemPage.getNumber());
        return "itemlist";
    }

    @ModelAttribute
    public void itemsByDateDto(Model model) {
        model.addAttribute("itemsByDateDto", new ItemSearchByDTO());
    }

    @PostMapping
    public String searchItemsByDate(@ModelAttribute ItemSearchByDTO itemSearchByDTO,
            Model model) {
        var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("items", itemRepository.findByNameStartsWithAndCreatedAtBetween(
            itemSearchByDTO.getName(), LocalDate.parse(itemSearchByDTO.getStartDate(), dateFormatter),
                LocalDate.parse(itemSearchByDTO.getEndDate(), dateFormatter)));
        return "itemlist";
    }
}
