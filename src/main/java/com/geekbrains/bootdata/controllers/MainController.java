package com.geekbrains.bootdata.controllers;

import com.geekbrains.bootdata.entities.Item;
import com.geekbrains.bootdata.repositories.ItemRepository;
import com.geekbrains.bootdata.repositories.ItemSpecifications;
import com.geekbrains.bootdata.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private ItemService itemService;

    @Autowired
    public MainController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")

        public String pagingString(Model model,
                @RequestParam(required = false, name = "min_price") Integer minPrice,
                @RequestParam(required = false, name = "max_price") Integer maxPrice
    ) {
        Specification<Item> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ItemSpecifications.priceGreaterThanOrEq(minPrice));
        }
        if (maxPrice != null) {
           spec = spec.and(ItemSpecifications.priceLesserThanOrEq(maxPrice));
        }

        Page<Item> page = itemService.findAll(spec, PageRequest.of(0, 10, Sort.Direction.ASC, "price"));
        model.addAttribute("items", page.getContent());
        model.addAttribute("itemsCount", page.getTotalElements());
        return "index";
    }



}
