package com.codegym.furama.repository.empolyee;

import com.codegym.furama.model.userRole.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
}
