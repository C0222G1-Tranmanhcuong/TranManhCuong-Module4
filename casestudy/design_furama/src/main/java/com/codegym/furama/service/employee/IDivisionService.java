package com.codegym.furama.service.employee;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.model.employee.Division;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();

    void save(Division division);

    Division findById(int id);

    void update(Division division);

    void remove(int id);

    List<Division> divisionList();

    Page<Division> findAll(Pageable pageable);

    Page<Division> searchByName(String name, Pageable pageable);
}
