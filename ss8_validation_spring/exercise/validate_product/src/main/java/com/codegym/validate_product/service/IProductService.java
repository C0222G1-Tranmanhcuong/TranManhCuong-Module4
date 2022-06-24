package com.codegym.validate_product.service;


import com.codegym.validate_product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Page<Product> searchByName(String name, Pageable pageable);
}
