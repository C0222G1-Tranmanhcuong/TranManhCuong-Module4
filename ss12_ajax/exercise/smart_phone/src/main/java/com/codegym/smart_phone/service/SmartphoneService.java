package com.codegym.smart_phone.service;

import com.codegym.smart_phone.model.Smartphone;
import com.codegym.smart_phone.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartPhoneRepository;

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public void save(Smartphone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Smartphone smartphone) {
        smartPhoneRepository.delete(smartphone);
    }

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return smartPhoneRepository.findAll(pageable);
    }
}
