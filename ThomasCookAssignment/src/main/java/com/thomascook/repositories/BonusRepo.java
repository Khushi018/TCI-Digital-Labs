package com.thomascook.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomascook.models.Employee;

@Service
public class BonusRepo {
	
	 @Autowired
	    private EmployeeRepository employeeRepository;

	public List<Employee> getActiveEmployeesOnDate(LocalDate date) {
        return employeeRepository.findByJoiningDateLessThanEqualAndExitDateGreaterThanEqual(date, date);
    }

}
