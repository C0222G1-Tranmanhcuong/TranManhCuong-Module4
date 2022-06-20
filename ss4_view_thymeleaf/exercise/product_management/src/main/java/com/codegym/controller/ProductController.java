package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String home(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id) {

        iProductService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId(iProductService.size() + 1);
        iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
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
    @GetMapping("/search")
    public String search( String name, Model model){
        model.addAttribute("productList",iProductService.searchByName(name));
        return "list";
    }
}
