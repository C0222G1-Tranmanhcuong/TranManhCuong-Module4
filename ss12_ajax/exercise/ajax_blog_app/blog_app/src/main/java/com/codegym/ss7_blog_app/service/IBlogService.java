package com.codegym.ss7_blog_app.service;


import com.codegym.ss7_blog_app.model.Blog;
import com.codegym.ss7_blog_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);

    List<Category> categoryList();

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> searchByName(String name, Pageable pageable);
}
