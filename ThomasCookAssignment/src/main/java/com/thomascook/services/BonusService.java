package com.thomascook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomascook.models.Employee;
import com.thomascook.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class BonusService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getActiveEmployeesOnDate(LocalDate date) {
        return employeeRepository.findByJoiningDateLessThanEqualAndExitDateGreaterThanEqual(date, date);
    }
}

