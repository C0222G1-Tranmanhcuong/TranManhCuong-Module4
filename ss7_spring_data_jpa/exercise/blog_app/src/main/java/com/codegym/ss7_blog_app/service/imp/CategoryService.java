package com.codegym.ss7_blog_app.service.imp;

import com.codegym.ss7_blog_app.model.Category;
import com.codegym.ss7_blog_app.repository.ICategoryRepository;
import com.codegym.ss7_blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAllCategory();
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }


}
