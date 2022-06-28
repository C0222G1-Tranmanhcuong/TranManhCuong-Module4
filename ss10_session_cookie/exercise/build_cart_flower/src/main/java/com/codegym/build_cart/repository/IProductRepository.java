package com.codegym.build_cart.repository;

import com.codegym.build_cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product", nativeQuery = true)
    Page<Product> findAll(Pageable pageable);
}
