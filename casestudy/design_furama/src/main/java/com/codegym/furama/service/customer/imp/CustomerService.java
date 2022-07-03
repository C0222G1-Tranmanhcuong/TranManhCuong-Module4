package com.codegym.furama.service.customer.imp;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.repository.customer.ICustomerRepository;
import com.codegym.furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
       iCustomerRepository.delete(id);
    }

    @Override
    public List<Customer> customerList() {
        return null;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> searchByName(String name, Pageable pageable) {
        return null;
    }
}
