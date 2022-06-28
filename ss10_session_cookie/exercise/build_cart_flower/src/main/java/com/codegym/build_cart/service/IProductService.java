package com.codegym.build_cart.service;

import com.codegym.build_cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);
}
