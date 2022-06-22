package com.codegym.ss7_blog_app.controller;

import com.codegym.ss7_blog_app.model.Blog;
import com.codegym.ss7_blog_app.model.Category;
import com.codegym.ss7_blog_app.service.IBlogService;
import com.codegym.ss7_blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("create_day");
        Page<Blog> list = iBlogService.findAll(PageRequest.of(page, 1, sort));
        model.addAttribute("blogList", list);
        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String addNew(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        List<Category> categoryList = iBlogService.categoryList();
        model.addAttribute("categoryList", categoryList);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog) {
        iBlogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id) {
        iBlogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, @RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Blog> list = iBlogService.searchByName(name, PageRequest.of(page, 1));
        model.addAttribute("blogList", list);
        return "list";
    }

}