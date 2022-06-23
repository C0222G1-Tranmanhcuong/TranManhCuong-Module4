package com.codegym.register_form.repository;

import com.codegym.register_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "insert into user(first_name,last_name,phone_number,age,email) value(:first_name,:last_name,:phone_number,:age,:email) ", nativeQuery = true)
    void save(@Param("first_name") String firstName, @Param("last_name") String lastName, @Param("phone_number") String phoneNumber, @Param("age") Integer age, @Param("email") String email);

    @Query(value = "select * from user", nativeQuery = true)
    Page<User> findAllUser(Pageable pageable);

    @Query(value = "select * from user", nativeQuery = true)
    List<User> findAllUser();
}
