package com.codegym.furama.repository.customer;

import com.codegym.furama.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICustomerTypeRepository  extends JpaRepository<CustomerType,Integer> {
//    @Query(value = "SELECT * FROM customer_type ", nativeQuery = true)
//    List<CustomerType> findAllType ();
}
