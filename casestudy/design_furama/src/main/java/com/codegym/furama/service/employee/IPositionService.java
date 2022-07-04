package com.codegym.furama.service.employee;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPositionService {

    List<Position> findAll();

    void save(Position position);

    void update(Position position);

    void remove(Position position);

    void delete(int id);

    List<Position>positionList();

    Page<Position> findAll(Pageable pageable);
}
