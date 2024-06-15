package com.thomascook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomascook.models.Department;
import com.thomascook.repositories.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getOrCreateDepartment(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        if (department == null) {
            department = new Department();
            department.setDepartmentName(departmentName);
            departmentRepository.save(department);
        }
        return department;
    }
}
