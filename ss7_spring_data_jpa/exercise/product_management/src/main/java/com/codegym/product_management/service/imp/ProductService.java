package com.codegym.product_management.service.imp;


import com.codegym.product_management.model.Product;
import com.codegym.product_management.repository.IProductRepository;
import com.codegym.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService implements IProductService {
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAllProduct();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product.getName(), String.valueOf(product.getPrice()), product.getProducer(), product.getStatus());
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAllProduct(pageable);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return iProductRepository.searchByName("%" + name + "%", pageable);
    }
}

