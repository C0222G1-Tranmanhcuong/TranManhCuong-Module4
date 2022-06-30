package com.codegym.smart_phone.controller.rest;

import com.codegym.smart_phone.model.Smartphone;
import com.codegym.smart_phone.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(smartphone, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> allPhones(@RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Smartphone> phones = smartphoneService.findAll(PageRequest.of(page, 2));
        if (phones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPhoneById(@PathVariable Long id) {
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        if (!smartphone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphone.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deletePhone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(smartphoneOptional.get());
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> editPhone(@PathVariable Long id, @RequestBody Smartphone smartphone) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphone.setId(smartphoneOptional.get().getId());
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }
}
