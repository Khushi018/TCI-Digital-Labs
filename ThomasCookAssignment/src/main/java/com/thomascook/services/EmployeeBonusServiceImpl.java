package com.thomascook.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomascook.dto.EmployeeBonusResponse;
import com.thomascook.models.CurrencyGroup;
import com.thomascook.models.Department;
import com.thomascook.models.Employee;
import com.thomascook.models.EmployeeBonus;
import com.thomascook.repositories.DepartmentRepository;
import com.thomascook.repositories.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeBonusServiceImpl implements EmployeeBonusService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public void saveEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            Department department = departmentRepository.findByDepartmentName(employee.getDepartment().getDepartmentName());
            if (department == null) {
                department = new Department(employee.getDepartment().getDepartmentName());
                departmentRepository.save(department);
            }
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
    }

    @Override
    public EmployeeBonusResponse getEligibleEmployees(LocalDate date) {
        List<Employee> eligibleEmployees = employeeRepository.findByJoiningDateBeforeAndExitDateAfter(date, date);

        Map<String, List<EmployeeBonus>> employeesByCurrency = eligibleEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getCurrency,
                        Collectors.mapping(emp -> new EmployeeBonus(emp.getEmpName(), emp.getAmount()),
                                Collectors.toList())));

        List<CurrencyGroup> data = employeesByCurrency.entrySet().stream()
                .map(entry -> new CurrencyGroup(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        EmployeeBonusResponse response = new EmployeeBonusResponse();
        response.setErrorMessage("");
        response.setData(data);
        return response;
    }
}
