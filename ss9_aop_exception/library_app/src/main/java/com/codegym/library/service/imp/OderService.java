package com.codegym.library.service.imp;

import com.codegym.library.model.Order;
import com.codegym.library.repository.IOderRepository;
import com.codegym.library.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderService implements IOrderService {
    @Autowired
    private IOderRepository iOderRepository;

    @Override
    public void save(Order oder) {
        iOderRepository.save(oder);
    }

    @Override
    public Order findByOrderCode(Integer code) {
        return iOderRepository.findById(code).orElse(null);
    }

    @Override
    public void delete(Order orderBook) {
        iOderRepository.delete(orderBook);
    }
}
