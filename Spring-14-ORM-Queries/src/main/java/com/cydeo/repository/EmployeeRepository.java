package com.cydeo.repository;

import com.cydeo.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT e FROM Employee e WHERE e.email = 'btrow5@technorati.com'")
    Employee getEmployeeDetails();

    @Query("select e.salary from Employee e where e.email = 'btrow5@technorati.com'")
    Integer getEmployeeSalary();

    @Query("select e from Employee  e where e.email = ?1")
    Employee getEmployeeDetail(String email);

    @Query("select e from Employee  e where e.email = ?1 and e.salary = ?2")
    Employee getEmployeeDetail(String email, Integer salary);

    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween( int salary1, int salary2);
    @Query("select e from Employee e where e.email is null ")
    List<Employee> getEmployeeEmailIsNull();

    @Query("select e from Employee e where e.email is not null ")
    List<Employee> getEmployeeEmailIsNotNull();

    // sorting acs
    @Query("select e from Employee e order by e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    // sorting desc
    @Query("select e from Employee e order by e.salary desc ")
    List<Employee> getEmployeeSalaryOrderDesc();
    @Query(value = "select * from employees where salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);

    @Query(value = "select e from employees where e.salary = :salary", nativeQuery = true)
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("update Employee e set e.email ='admin@cydeo.com' where e.id = :id")
    void updateEmployeeJPQL(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update employees set e.email ='admin@cydeo.com' where e.id = :id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);

}
