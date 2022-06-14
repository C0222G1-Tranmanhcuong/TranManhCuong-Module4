package com.codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImp implements IDictionaryService {
    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("age", "Tuổi");
        stringMap.put("tree", "Cái cây");
        stringMap.put("ball", "Quả bóng");
        stringMap.put("hello", "Xin chào");
    }

    @Override
    public String dictionary(String english) {
        if (stringMap.containsKey(english)) {
            return stringMap.get(english);
        } else {
            return "Not found";
        }
    }
}
