package com.thomascook.services;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomascook.models.Department;
import com.thomascook.models.Employee;
import com.thomascook.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentService departmentService;

    public void saveEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            Department department = departmentService.getOrCreateDepartment(employee.getDepartment().getDepartmentName());
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
    }

    public List<Employee> getEligibleEmployees(LocalDate date) {
        return employeeRepository.findAllByExitDateAfter(date);
    }
}
