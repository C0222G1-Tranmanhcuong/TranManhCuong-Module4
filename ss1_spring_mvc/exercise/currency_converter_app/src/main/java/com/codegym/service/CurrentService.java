package com.codegym.service;

import org.springframework.stereotype.Service;
@Service
public class CurrentService implements ICurrentService{
    @Override
    public Double convertUsdToVnd(Double usd) {
        return usd *23000;
    }
}
