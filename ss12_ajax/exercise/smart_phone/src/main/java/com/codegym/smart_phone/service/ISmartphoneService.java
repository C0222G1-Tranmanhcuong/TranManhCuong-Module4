package com.codegym.smart_phone.service;

import com.codegym.smart_phone.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface ISmartphoneService {

    Optional<Smartphone> findById(Long id);

    void save(Smartphone smartPhone);

    void remove(Smartphone smartphone);

    Page<Smartphone> findAll(Pageable pageable);
}
