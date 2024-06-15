package com.thomascook.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomascook.dto.EmployeeBonusResponse;
import com.thomascook.exceptions.CustomExceptionHandler;
import com.thomascook.models.Employee;
import com.thomascook.repositories.BonusRepo;
import com.thomascook.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeBonusServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BonusRepo bonusrepo;
   
    @Override
    public String addEmployee(List<Employee> employees) {
        employeeRepository.saveAll(employees);
        return "Employees Addedd in the database";
    }
    
    
    @Override
    public Map<String, List<EmployeeBonusResponse>> getEmployeesEligible(LocalDate date) {
        
        List<Employee> activeEmployees = bonusrepo.getActiveEmployeesOnDate(date);

        
        if (activeEmployees.isEmpty()) {
            throw new CustomExceptionHandler("Employee not found : " + date);
        }

        Map<String, List<EmployeeBonusResponse>> bonusInfoMap = new HashMap<>();
        for (Employee employee : activeEmployees) {
            String currency = employee.getCurrency();
            double amount = employee.getAmount();

            
            EmployeeBonusResponse bonus = new EmployeeBonusResponse(employee.getEmpName(), amount);

            
            ((Map<String, List<EmployeeBonusResponse>>) bonus).computeIfAbsent(currency, data -> new ArrayList<>()).add(bonus);
        }

        return bonusInfoMap;
    }


    
    

	
}