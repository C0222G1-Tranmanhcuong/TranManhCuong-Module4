package com.codegym.furama.repository.empolyee;

import com.codegym.furama.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
