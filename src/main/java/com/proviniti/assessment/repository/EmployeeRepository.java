package com.proviniti.assessment.repository;

import com.proviniti.assessment.entity.Employee;
import com.proviniti.assessment.response.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Transactional
    @Query(value = "{CALL SAVE_EMPLOYEE(:firstName, :lastName, :username, :manager_id, :department_dept_id)}", nativeQuery = true)
    void save(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("username") String username,
                  @Param("manager_id") Integer manager_id, @Param("department_dept_id") Integer dept_id);


    @Query(value = "{CALL EMPLOYEES()}",nativeQuery = true)
    List<Employee> findAll();

    @Query(value = "{CALL GET_EMPLOYEE(:username,:manager_id,:department_id)}",nativeQuery = true)
    Integer getEmployee(@Param("username") String username, @Param("manager_id") Integer manager_id,
                               @Param("department_id") Integer department_id);

    @Transactional
    @Query(value = "{CALL DELETE_EMPLOYEE_BY_ID(:id)}",nativeQuery = true)
    void deleteEmployeeById(@Param("id") Integer id);

    @Query(value = "{CALL GET_EMPLOYEE_BY_ID(:id)}",nativeQuery = true)
    Employee getById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "{CALL UPDATE_EMPLOYEE_BY_ID(:id,:first_name,:last_name, :user_name, :dept_id,:manager_id)}",nativeQuery = true)
    void update(@Param("id") Integer id,@Param("first_name") String firstName, @Param("last_name") String lastName, @Param("user_name") String username,
                @Param("manager_id") Integer manager_id, @Param("dept_id") Integer dept_id);


    Employee findByUsername(String username);

}