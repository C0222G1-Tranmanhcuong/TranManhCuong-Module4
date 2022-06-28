package com.codegym.build_cart.controller;


import com.codegym.build_cart.model.Product;
import com.codegym.build_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public List<Product> creatCartList() {
        return new ArrayList<>();
    }

    @GetMapping("shop/{id}")
    public String addToCart(@PathVariable("id") Long id, @ModelAttribute("cart") List<Product> products,
                            RedirectAttributes redirectAttributes) {
        Product product = iProductService.findById(id);
        products.add(product);
        redirectAttributes.addFlashAttribute("msg", "Đã thêm vào giỏ hàng");
        return "redirect:/shop";


    }

    @GetMapping("/shop")
    public String showShop(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> list = iProductService.findAll(PageRequest.of(page, 4));
        model.addAttribute("products", list);
        return "shop";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("item", iProductService.findById(id));
        return "view";
    }

    @GetMapping("/order-list")
    public String order(@ModelAttribute("cart") List<Product> productList, Model model) {
        model.addAttribute("productList", productList);
        int total = 0;
        for (Product item : productList) {
            total += item.getPrice();
        }
        model.addAttribute("item", total);
        return "order-list";
    }

}
