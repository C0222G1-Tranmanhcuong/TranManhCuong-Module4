package com.codegym.ss11_blog_app.controller.rest;

import com.codegym.ss11_blog_app.model.Blog;
import com.codegym.ss11_blog_app.model.Category;
import com.codegym.ss11_blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category category = iCategoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}/view")
    public Set<Blog> viewBlog(@PathVariable Integer id) {
        Set<Blog> blogs = iCategoryService.findById(id).getBlogs();
        return blogs;
    }

}
