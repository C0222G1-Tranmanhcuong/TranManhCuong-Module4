package com.codegym.service;

import java.util.ArrayList;
import java.util.List;

public interface IMedicalDeclarationService {
    List<Integer> dayOfBirth();
    List<String> gender();
    List<String> nationality();
    List<Integer>startDay();
    List<Integer>startMonth();
    List<Integer>startYear();
    List<Integer>endDay();
    List<Integer>endMonth();
    List<Integer>endYear();
}
