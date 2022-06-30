package com.codegym.ss7_blog_app.service;


import com.codegym.ss7_blog_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    Page<Category> findAll(Pageable pageable);
}
