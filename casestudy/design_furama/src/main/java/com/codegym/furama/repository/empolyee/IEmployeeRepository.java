package com.codegym.furama.repository.empolyee;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee WHERE status_delete = 0", nativeQuery = true)
    Page<Employee> findAll (Pageable p);

    @Modifying
    @Query(value = "update employee set status_delete = 1 where employee_id = :id ", nativeQuery = true)
    void delete(@Param("id") int id);
}
