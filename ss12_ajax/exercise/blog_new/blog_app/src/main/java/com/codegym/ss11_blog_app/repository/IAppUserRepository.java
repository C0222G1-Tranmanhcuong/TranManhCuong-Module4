package com.codegym.ss11_blog_app.repository;

import com.codegym.ss11_blog_app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String username);
}
