package com.codegym.library.service;

import com.codegym.library.model.Order;

public interface IOrderService {
    void save(Order oder);

    Order findByOrderCode(Integer code);

    void delete(Order orderBook);
}
