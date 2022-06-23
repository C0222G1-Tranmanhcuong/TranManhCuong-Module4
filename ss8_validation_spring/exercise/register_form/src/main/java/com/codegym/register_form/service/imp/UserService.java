package com.codegym.register_form.service.imp;

import com.codegym.register_form.model.User;
import com.codegym.register_form.repository.IUserRepository;
import com.codegym.register_form.service.IUserService;
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
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAllUser(pageable);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAllUser();
    }
}
