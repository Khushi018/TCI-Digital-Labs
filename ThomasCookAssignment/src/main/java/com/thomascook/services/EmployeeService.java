package com.thomascook.services;
import com.thomascook.dto.EmployeeBonusResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface EmployeeService {
    String addEmployee(List<com.thomascook.models.Employee> employees) ;
    Map<String, List<EmployeeBonusResponse>> getEmployeesEligible(LocalDate date);
    
	
}