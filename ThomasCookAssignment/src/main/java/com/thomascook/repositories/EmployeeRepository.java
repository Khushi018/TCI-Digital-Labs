package com.thomascook.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thomascook.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {      
    List<Employee> findByJoiningDateLessThanEqualAndExitDateGreaterThanEqual(LocalDate date1, LocalDate date2);	
}
