package com.thomascook.controllers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thomascook.dto.EmployeeBonusResponse;
import com.thomascook.models.Employee;
import com.thomascook.services.EmployeeBonusService;

@RestController
public class EmployeeBonusController {

    @Autowired
    private EmployeeBonusService employeeBonusService;

    @PostMapping("/tci/employee-bonus")
    public void saveEmployees(@RequestBody List<Employee> employees) {
        employeeBonusService.saveEmployees(employees);
    }

    @GetMapping("/tci/employee-bonus")
    public EmployeeBonusResponse getEligibleEmployees(@RequestParam("date") @DateTimeFormat(pattern = "MMM-dd-yyyy") String date) {
    	
    	DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("MMM-dd-yyyy");
DateTimeFormatter formatter = builder.toFormatter(Locale.ENGLISH);
LocalDate requestDate = LocalDate.parse(date, formatter);

  //LocalDate joiningDate = dateConverter(employeePostDTO.getJoiningDate());

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy", Locale.ENGLISH);
        //LocalDate requestDate = LocalDate.parse(date, formatter);

        return employeeBonusService.getEligibleEmployees(requestDate);
    }
}
