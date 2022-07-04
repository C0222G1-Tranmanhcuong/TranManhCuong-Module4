package com.codegym.furama.service.employee.imp;

import com.codegym.furama.model.employee.Employee;
import com.codegym.furama.repository.empolyee.IEmployeeRepository;
import com.codegym.furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        iEmployeeRepository.delete(id);
    }

    @Override
    public List<Employee> employeeList() {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> searchByName(String name, Pageable pageable) {
        return null;
    }
}
