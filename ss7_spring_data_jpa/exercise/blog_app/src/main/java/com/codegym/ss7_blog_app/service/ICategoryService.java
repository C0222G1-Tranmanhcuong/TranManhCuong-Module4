package com.codegym.ss7_blog_app.service;

import com.codegym.ss7_blog_app.model.Category;
import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);
}
