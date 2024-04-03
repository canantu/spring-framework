package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OvertimeSalaryService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository overtimeHours;

    public OvertimeSalaryService(EmployeeRepository employeeRepository, HoursRepository overtimeHours) {
        this.employeeRepository = employeeRepository;
        this.overtimeHours = overtimeHours;
    }

    public void calculateOvertimeSalary(){
        System.out.println(employeeRepository.getHourlyRate() * overtimeHours.getHours());
    }
}
