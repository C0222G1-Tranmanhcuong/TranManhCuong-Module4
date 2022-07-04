package com.codegym.furama.service.employee;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {


    void save(Employee employee);

    Employee findById(int id);

    void update(Employee employee);

    void remove(int id);

    List<Employee> employeeList();

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> searchByName(String name, Pageable pageable);
}
