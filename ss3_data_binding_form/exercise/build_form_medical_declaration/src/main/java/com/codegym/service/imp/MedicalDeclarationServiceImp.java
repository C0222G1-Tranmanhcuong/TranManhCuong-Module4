package com.codegym.service.imp;

import com.codegym.service.IMedicalDeclarationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MedicalDeclarationServiceImp implements IMedicalDeclarationService {
    @Override
    public List<Integer> dayOfBirth() {
        List<Integer> dayOfBirth = new ArrayList<>();
        dayOfBirth.add( 1990);
        dayOfBirth.add( 1995);
        dayOfBirth.add( 1998);
        dayOfBirth.add( 2000);
        return dayOfBirth;

    }

    @Override
    public List<String> gender() {
        List<String> gender = new ArrayList<>();
        gender.add("Nam");
        gender.add("Nữ");
        return gender;
    }

    @Override
    public List<String> nationality() {
        List<String> nationality = new ArrayList<>();
        nationality.add("Việt Nam");
        nationality.add("Nhật Bản");
        nationality.add("Lào");
        return nationality;
    }


    @Override
    public List<Integer> startDay() {
        List<Integer> startDay = new ArrayList<>();
        startDay.add(1);
        startDay.add(2);
        startDay.add(3);
        startDay.add(4);
        startDay.add(5);
        startDay.add(6);
        return startDay;
    }

    @Override
    public List<Integer> startMonth() {
        List<Integer> startMonth = new ArrayList<>();
        startMonth.add(1);
        startMonth.add(2);
        startMonth.add(3);
        startMonth.add(4);
        startMonth.add(5);
        startMonth.add(6);
        startMonth.add(7);
        startMonth.add(8);
        startMonth.add(9);
        startMonth.add(10);
        startMonth.add(11);
        startMonth.add(12);
        return startMonth;
    }

    @Override
    public List<Integer> startYear() {
        List<Integer> startYear = new ArrayList<>();
        startYear.add(2020);
        startYear.add(2021);
        startYear.add(2022);
        return startYear;
    }

    @Override
    public List<Integer> endDay() {
        List<Integer> endDay = new ArrayList<>();
        endDay.add(1);
        endDay.add(2);
        endDay.add(3);
        endDay.add(4);
        endDay.add(5);
        endDay.add(6);
        return endDay;
    }

    @Override
    public List<Integer> endMonth() {
        List<Integer> endMonth = new ArrayList<>();
        endMonth.add(1);
        endMonth.add(2);
        endMonth.add(3);
        endMonth.add(4);
        endMonth.add(5);
        endMonth.add(6);
        return endMonth;
    }

    @Override
    public List<Integer> endYear() {
        List<Integer> endYear = new ArrayList<>();
        endYear.add(2020);
        endYear.add(2021);
        endYear.add(2022);
        return endYear;
    }
}
