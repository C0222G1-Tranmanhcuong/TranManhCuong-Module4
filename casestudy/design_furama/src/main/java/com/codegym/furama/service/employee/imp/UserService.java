package com.codegym.furama.service.employee.imp;

import com.codegym.furama.model.userRole.User;
import com.codegym.furama.repository.empolyee.IUserRepository;
import com.codegym.furama.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void update(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> userList() {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }
}
