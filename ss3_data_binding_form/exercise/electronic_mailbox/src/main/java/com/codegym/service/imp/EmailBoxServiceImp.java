package com.codegym.service.imp;

import com.codegym.service.IEmailBoxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailBoxServiceImp implements IEmailBoxService {

    @Override
    public List<String> languages() {
        List<String> languages = new ArrayList<>();
        languages.add("Vietnamese");
        languages.add("English");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }

    @Override
    public List<Integer> pageSize() {
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(20);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        return pageSize;
    }
}
