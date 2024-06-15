package com.thomascook.models;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empName;
    private String department;
    private Double amount;
    private String currency;
    private LocalDate joiningDate;
    private LocalDate exitDate;

    public Employee(String empName, String department, Double amount, String currency, LocalDate joiningDate, LocalDate exitDate) {

        this.empName = empName;
        this.department = department;
        this.amount = amount;
        this.currency = currency;
        this.joiningDate = joiningDate;
        this.exitDate = exitDate;
    }
}