package com.codegym.furama.service.employee.imp;

import com.codegym.furama.model.employee.Division;
import com.codegym.furama.repository.empolyee.IDivisionRepository;
import com.codegym.furama.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        iDivisionRepository.save(division);
    }

    @Override
    public Division findById(int id) {
        return iDivisionRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Division division) {
        iDivisionRepository.save(division);
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public List<Division> divisionList() {
        return iDivisionRepository.findAll();
    }

    @Override
    public Page<Division> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Division> searchByName(String name, Pageable pageable) {
        return null;
    }
}
