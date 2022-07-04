package com.codegym.furama.service.employee;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();

    void save(EducationDegree educationDegree);

    EducationDegree findById(int id);

    void update(EducationDegree educationDegree);

    void remove(int id);

    List<EducationDegree> educationDegreeList();

    Page<EducationDegree> findAll(Pageable pageable);

    Page<EducationDegree> searchByName(String name, Pageable pageable);
}
