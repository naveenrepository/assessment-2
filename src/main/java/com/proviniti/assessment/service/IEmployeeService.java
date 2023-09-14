package com.proviniti.assessment.service;

import com.proviniti.assessment.entity.Employee;
import com.proviniti.assessment.response.Response;

import java.util.List;

public interface IEmployeeService {


    Response save(Employee employee);
    Integer getEmployee(String username, String managerName, String departmentName);
    Response deleteById(Integer id);
    Response update(Employee employee);


}
