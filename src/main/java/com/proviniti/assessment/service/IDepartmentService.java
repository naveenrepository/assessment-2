package com.proviniti.assessment.service;

import com.proviniti.assessment.entity.Department;
import com.proviniti.assessment.response.Response;

import java.util.List;

public interface IDepartmentService {

    Response save(Department department);
    List<Department> findAll();
    Response update(Department department);

}
