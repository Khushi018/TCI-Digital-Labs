package com.thomascook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thomascook.models.Department;
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);
}
