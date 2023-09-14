package com.proviniti.assessment.service;

import com.proviniti.assessment.entity.Department;
import com.proviniti.assessment.entity.Employee;
import com.proviniti.assessment.exception.UserNotFoundException;
import com.proviniti.assessment.repository.DepartmentRepository;
import com.proviniti.assessment.repository.EmployeeRepository;
import com.proviniti.assessment.service.impl.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private DepartmentRepository departmentRepository;

    @Test
    public void getEmployee_HappyPath() {
        Department department = new Department(1, "departmentName");
        Employee manager = new Employee(1, "Manager", "LastName", "managerName", department, null);

        when(employeeRepository.findByUsername("managerName")).thenReturn(manager);
        when(departmentRepository.findByName("departmentName")).thenReturn(department);
        when(employeeRepository.getEmployee("username", 1, 1)).thenReturn(123);

        employeeService.getEmployee("username", "managerName", "departmentName");

    }

    @Test
    public void getEmployee_UnHappyPath() {
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setUsername("username");
        employee.setDepartment(new Department(1, "dept"));
        when(departmentRepository.findByName(Mockito.anyString()))
                .thenReturn(new Department(1, "dept"));
        when(employeeRepository.findByUsername(Mockito.anyString()))
                .thenReturn(employee);
        when(employeeRepository.getEmployee("username", 123, 1))
                .thenReturn(1);
        employeeService.getEmployee("username", "manager name", "department name");
    }


    @Test
    public void testGetEmployeeEmpIdNotFound() {
        // Create a sample department
        Department department = new Department(1, "departmentName");

        // Create a sample manager
        Employee manager = new Employee(1, "Manager", "LastName", "managerName", department, null);

        // Mock repository responses
        when(employeeRepository.findByUsername("managerName")).thenReturn(manager);
        when(departmentRepository.findByName("departmentName")).thenReturn(department);
        when(employeeRepository.getEmployee("username", 1, 1)).thenReturn(null); // Simulate emp_id not found

        // Execute the method and expect a UserNotFoundException
        assertThrows(UserNotFoundException.class, () ->
                employeeService.getEmployee("username", "managerName", "departmentName")
        );
    }

}
