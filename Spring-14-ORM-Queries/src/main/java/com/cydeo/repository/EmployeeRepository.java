package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // display all employees with email address
    List<Employee> findEmployeeByEmail(String email);

    // display all employees with firstname and lastname, show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);

    // display all employees firstname is not "something "
    List<Employee> findByFirstNameIsNot(String firstname);

    // display all employees lastname starts with "something"
    List<Employee> findByLastNameStartsWith(String pattern);

    // display all employees with salary more than something
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // display all employees with salary less than something
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // display all employees has been hired between dates
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // display all employees where salaries greater or equal to something and in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // display top unique 3 employees making less than some salary
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // display all employees that don't have email address
    List<Employee> findByEmailIsNull();




}
