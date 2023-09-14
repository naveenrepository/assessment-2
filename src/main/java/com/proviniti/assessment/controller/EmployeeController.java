package com.proviniti.assessment.controller;

import com.proviniti.assessment.entity.Employee;
import com.proviniti.assessment.response.Response;
import com.proviniti.assessment.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/{username}/{managerName}/{departmentName}")
    public ResponseEntity<Integer> getEmployee(@PathVariable("username") String username,
                                               @PathVariable("managerName") String managerName,
                                               @PathVariable("departmentName") String departmentName){
        return ResponseEntity.ok(employeeService.getEmployee(username,managerName,departmentName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEmployeeById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.deleteById(id));
    }


    @PutMapping
    public ResponseEntity<Response> update(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.update(employee));
    }

}
