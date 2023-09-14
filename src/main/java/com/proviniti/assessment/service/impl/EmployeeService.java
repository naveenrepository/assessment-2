package com.proviniti.assessment.service.impl;

import com.proviniti.assessment.entity.Employee;
import com.proviniti.assessment.exception.UserFoundException;
import com.proviniti.assessment.exception.UserNotFoundException;
import com.proviniti.assessment.repository.DepartmentRepository;
import com.proviniti.assessment.repository.EmployeeRepository;
import com.proviniti.assessment.response.Response;
import com.proviniti.assessment.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public Response save(Employee employee) {
        if(employeeRepository.findByUsername(employee.getUsername()) != null){
            throw new UserFoundException("username already present");
        }
        if(employeeRepository.findByUsername(employee.getManager().getUsername()) == null){
            throw new UserNotFoundException("Manager not found");
        }
        employeeRepository.save(employee.getFirstName(), employee.getLastName(), employee.getUsername(),
                employee.getManager().getEmpId(), employee.getDepartment().getDeptId());
        return Response.builder().message("SUCCESS").build();
    }

    @Override
    public Integer getEmployee(String username, String managerName, String departmentName) {
        Integer manager_id = employeeRepository.findByUsername(managerName).getEmpId();
        if(manager_id == null){
            throw new UserNotFoundException("Manager not found");
        }
        Integer dept_id = departmentRepository.findByName(departmentName).getDeptId();
        Integer emp_id = employeeRepository.getEmployee(username, manager_id, dept_id);
        if(emp_id == null){
            throw new UserNotFoundException("User Not found");
        }
        return emp_id;
    }

    @Override
    public Response deleteById(Integer id) {
        employeeRepository.deleteById(id);
        return Response.builder().message("SUCCESS").build();
    }


    @Override
    public Response update(Employee employeeInput) {
        Employee employee = employeeRepository.findById(employeeInput.getEmpId()).orElseThrow(()-> new UserNotFoundException("User Not found"));
        if (employeeInput.getFirstName() != null) {
            employee.setFirstName(employeeInput.getFirstName());
        }
        if (employeeInput.getLastName() != null) {
            employee.setLastName(employeeInput.getLastName());
        }
        if (employeeInput.getUsername() != null) {
            employee.setUsername(employeeInput.getUsername());
        }
        if (employeeInput.getDepartment() != null) {
            employee.setDepartment(employeeInput.getDepartment());
        }
        if (employeeInput.getManager() != null) {
            employee.setManager(employeeInput.getManager());
        }
        if(employeeRepository.findByUsername(employee.getUsername()) != null){
            throw new UserFoundException("Username already exists");
        }
        employeeRepository.update(employee.getEmpId(), employee.getFirstName(), employee.getLastName(), employee.getUsername(),
                employee.getManager().getEmpId(), employee.getDepartment().getDeptId());
        return Response.builder().message("SUCCESS").build();
    }
}
