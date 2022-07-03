package com.codegym.furama.service.customer;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(int id);

    List<Customer> customerList();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> searchByName(String name, Pageable pageable);
}
