package com.thomascook.services;

import java.time.LocalDate;
import java.util.List;

import com.thomascook.models.Employee;

public interface EmployeeBonusService {
    void saveEmployees(List<Employee> employees);
    com.thomascook.dto.EmployeeBonusResponse getEligibleEmployees(LocalDate date);
}
