package com.proviniti.assessment.service.impl;

import com.proviniti.assessment.entity.Department;
import com.proviniti.assessment.repository.DepartmentRepository;
import com.proviniti.assessment.response.Response;
import com.proviniti.assessment.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Response save(Department department) {
        departmentRepository.save(department.getName().toLowerCase());
        return Response.builder().message("SUCCESS").build();
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Response update(Department departmentInput) {
        Department department = departmentRepository.findById(departmentInput.getDeptId()).get();
        if(departmentInput.getName()!=null){
            department.setName(departmentInput.getName());
        }
        departmentRepository.update(department.getDeptId(),department.getName());
        return Response.builder().message("SUCCESS").build();
    }
}
