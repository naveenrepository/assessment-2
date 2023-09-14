package com.proviniti.assessment.controller;

import com.proviniti.assessment.entity.Department;
import com.proviniti.assessment.response.Response;
import com.proviniti.assessment.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {

    private final IDepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Response> addDepartment(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.save(department));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Department>> findAll(){
        return ResponseEntity.ok(departmentService.findAll());
    }

    @PutMapping
    public ResponseEntity<Response> update(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.update(department));
    }
}
