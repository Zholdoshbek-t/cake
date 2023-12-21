package com.inai.cakes.controller;

import com.inai.cakes.dto.*;
import com.inai.cakes.service.CakeService;
import com.inai.cakes.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cake")
@RequiredArgsConstructor
public class CakeController {

    private final CakeService cakeService;
    private final OrderService orderService;

    @GetMapping("/menu")
    public String getCakeMenu(Model model) {
        List<CakeMenu> cakeMenuList = cakeService.getCakes();
        model.addAttribute("cakeMenuList", cakeMenuList);
        return "cakeMenu";
    }

    @GetMapping("/details/{id}")
    public String getCakeDetails(@PathVariable Long id, Model model) {
        CakeDetail cakeDetail = cakeService.getCake(id);

        model.addAttribute("makeOrderDto", new MakeOrderDto());
        model.addAttribute("cakeDetail", cakeDetail);

        return "cakeDetails";
    }

    @PostMapping("/order")
    public String placeOrder(@ModelAttribute MakeOrderDto makeOrderDto) {
        orderService.makeOrder(makeOrderDto);
        return "redirect:/cake/menu";
    }
}

