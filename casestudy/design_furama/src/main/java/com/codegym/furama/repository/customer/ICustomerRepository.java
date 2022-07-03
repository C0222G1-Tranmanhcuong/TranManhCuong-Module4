package com.codegym.furama.repository.customer;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customer WHERE delete_status = 0", nativeQuery = true)
    Page<Customer> findAll (Pageable p);

    @Modifying
    @Query(value = "update customer set status_delete =1 where id_customer=:id", nativeQuery = true)
    void deleteById(@Param("id") Integer idCustomer);

    @Query(value = "SELECT * FROM customer WHERE id_customer = :id", nativeQuery = true)
    Customer findByCustomerId(@Param("id") Integer id);


    @Modifying
    @Query(value = "update customer set delete_status = 1 where id_customer = :id ", nativeQuery = true)
    void delete(@Param("id") int id);
}
