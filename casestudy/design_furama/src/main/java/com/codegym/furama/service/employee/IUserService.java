package com.codegym.furama.service.employee;

import com.codegym.furama.model.employee.Position;
import com.codegym.furama.model.userRole.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user);

    void update(User user);

    void remove(User user);

    void delete(int id);

    List<User>userList();

    Page<User> findAll(Pageable pageable);
}
