package com.codegym.library.repository;

import com.codegym.library.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IOderRepository extends JpaRepository<Order, Integer> {
}
