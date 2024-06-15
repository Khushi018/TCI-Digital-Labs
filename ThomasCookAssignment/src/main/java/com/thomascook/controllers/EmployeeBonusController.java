package com.thomascook.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thomascook.dto.EmployeeBonusResponse;
import com.thomascook.models.Employee;
import com.thomascook.services.EmployeeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tci")
public class EmployeeBonusController {
    @Autowired
    private EmployeeService empService;

    
    @PostMapping("/employee-bonus")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> employees) {
        return new ResponseEntity<>(empService.addEmployee(employees), HttpStatus.ACCEPTED);
    }

   
    @GetMapping("/employee-bonus")
    public ResponseEntity<Map<String, List<EmployeeBonusResponse>>> getEmployeesEligible(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return new ResponseEntity<>(empService.getEmployeesEligible(date), HttpStatus.OK);
    }
}