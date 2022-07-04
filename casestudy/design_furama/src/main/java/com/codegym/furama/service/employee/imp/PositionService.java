package com.codegym.furama.service.employee.imp;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.model.employee.Position;
import com.codegym.furama.repository.empolyee.IPositionRepository;
import com.codegym.furama.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }

    @Override
    public void save(Position position) {
iPositionRepository.save(position);
    }


    @Override
    public void update(Position position) {

    }

    @Override
    public void remove(Position position) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Position> positionList() {
        return iPositionRepository.findAll();
    }

    @Override
    public Page<Position> findAll(Pageable pageable) {
        return null;
    }
}
