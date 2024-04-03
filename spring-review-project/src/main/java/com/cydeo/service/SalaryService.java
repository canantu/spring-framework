package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository regularHours;

    public SalaryService(EmployeeRepository employeeRepository, @Qualifier("regular") HoursRepository regularHours) {
        this.employeeRepository = employeeRepository;
        this.regularHours = regularHours;
    }

    public void calculateRegularSalary(){
        // hourly rate * regular hours
        System.out.println(employeeRepository.getHourlyRate() * regularHours.getHours());
    }
}
