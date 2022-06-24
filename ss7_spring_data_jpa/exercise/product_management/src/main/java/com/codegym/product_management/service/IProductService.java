package com.codegym.product_management.service;

import com.codegym.product_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    Page<Product> findAll(Pageable pageable);

    Page<Product> searchByName(String name, Pageable pageable);
}
