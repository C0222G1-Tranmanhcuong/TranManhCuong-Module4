package com.codegym.furama.service.employee.imp;

import com.codegym.furama.model.employee.EducationDegree;
import com.codegym.furama.repository.empolyee.IEducationDegreeRepository;
import com.codegym.furama.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeService  implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        iEducationDegreeRepository.save(educationDegree);
    }

    @Override
    public EducationDegree findById(int id) {
        return iEducationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(EducationDegree educationDegree) {
    iEducationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<EducationDegree> educationDegreeList() {
        return iEducationDegreeRepository.findAll();
    }

    @Override
    public Page<EducationDegree> findAll(Pageable pageable) {
        return iEducationDegreeRepository.findAll(pageable);
    }

    @Override
    public Page<EducationDegree> searchByName(String name, Pageable pageable) {
        return null;
    }
}
