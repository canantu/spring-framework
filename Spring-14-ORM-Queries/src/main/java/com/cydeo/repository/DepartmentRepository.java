package com.cydeo.repository;

import com.cydeo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    // display all departments in the Furniture department
    List<Department> findByDepartment(String department);

    // display all departments in the Health division
    List<Department> findByDivisionEquals(String division);

    // display top 3 departments with division name includes "Hea" without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);

    @Query("select d from Department  d where d.division in ?1")
    List<Department> getDepartmentDivision(List<String> divisionList);

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);

}
