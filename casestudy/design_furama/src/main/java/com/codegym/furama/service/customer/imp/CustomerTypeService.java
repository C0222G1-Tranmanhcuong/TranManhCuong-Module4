package com.codegym.furama.service.customer.imp;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.customer.ICustomerTypeRepository;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
    iCustomerTypeRepository.save(customerType);
    }

    @Override
    public Optional<CustomerType> findById(int id) {
        return iCustomerTypeRepository.findById(id);
    }

    @Override
    public void update(CustomerType customerType) {
    iCustomerTypeRepository.save(customerType);
    }

    @Override
    public void remove(CustomerType customerType) {
        iCustomerTypeRepository.delete(customerType);
    }

    @Override
    public void delete(int id) {
        iCustomerTypeRepository.deleteById(id);
    }

    @Override
    public List<CustomerType> customerTypeList() {
        return null;
    }

    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return iCustomerTypeRepository.findAll(pageable);
    }

    @Override
    public Page<CustomerType> searchByName(String name, Pageable pageable) {
        return null;
    }
}
