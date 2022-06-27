package com.codegym.furama.service.customer;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);

    Optional<CustomerType> findById(int id);

    void update(CustomerType customerType);

    void remove(CustomerType customerType);

    void delete(int id);

    List<CustomerType> customerTypeList();

    Page<CustomerType> findAll(Pageable pageable);

    Page<CustomerType> searchByName(String name, Pageable pageable);
}
