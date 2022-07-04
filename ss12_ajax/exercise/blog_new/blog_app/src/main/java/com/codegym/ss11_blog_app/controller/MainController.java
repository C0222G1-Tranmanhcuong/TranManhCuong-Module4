package com.codegym.ss11_blog_app.controller;

import com.codegym.ss11_blog_app.model.Blog;
import com.codegym.ss11_blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/display")
    public String home(Model model) {
        List<Blog> blogList = iBlogService.findAll();
        List<Blog> blogs = new ArrayList<>();
        blogs.add(blogList.get(0));
        model.addAttribute("blogList", blogs);
        return "/list";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }


}