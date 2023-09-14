package com.proviniti.assessment.repository;

import com.proviniti.assessment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Transactional
    @Modifying
    @Query(value = "{CALL ADD_DEPARTMENT(:name)}",nativeQuery = true)
    void save(@Param("name") String name);

    @Query(value = "{CALL DEPARTMENTS()}",nativeQuery = true)
    List<Department> findAll();

    @Transactional
    @Modifying
    @Query(value = "{CALL UPDATE_DEPARTMENT_BY_ID(:id,:name)}",nativeQuery = true)
    void update(@Param("id") Integer id, @Param("name") String name);

    Department findByName(String name);
}