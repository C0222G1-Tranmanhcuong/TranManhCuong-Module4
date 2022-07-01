package com.codegym.ss11_blog_app.controller.rest;

import com.codegym.ss11_blog_app.model.Blog;
import com.codegym.ss11_blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/display/{size}")
    public ResponseEntity<List<Blog>> findAll(@PathVariable(name = "size") int size) {
        List<Blog> blogs = iBlogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            List<Blog> blogList = new ArrayList<>();
            for (int i = 0; i < size + 1; i++) {
                blogList.add(blogs.get(i));
            }
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody Blog blog) {
        iBlogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> search(@PathVariable("name") String text) {
        List<Blog> blogs = iBlogService.searchByName(text);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}