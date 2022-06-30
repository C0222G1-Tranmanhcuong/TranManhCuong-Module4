package com.codegym.ss11_blog_app.controller;


import com.codegym.ss11_blog_app.model.Category;
import com.codegym.ss11_blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Category> list = iCategoryService.findAll(PageRequest.of(page, 1));
        model.addAttribute("categoryList", list);
        return "category";
    }

    @GetMapping("/create-category")
    public String createCate(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "create-category";
    }

    @PostMapping("/save-category")
    public String addNew(Category category) {
        iCategoryService.save(category);
        return "redirect:/";
    }
}
