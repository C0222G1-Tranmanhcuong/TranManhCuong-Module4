package com.codegym.product_management.controller;


import com.codegym.product_management.model.Product;
import com.codegym.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;


    @GetMapping("/")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> list = iProductService.findAll(PageRequest.of(page, 1));
        model.addAttribute("productList", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product) {
        iProductService.update(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id) {
        iProductService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, @RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> list = iProductService.searchByName(name, PageRequest.of(page, 1));
        model.addAttribute("productList", list);
        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

}
