package com.thomascook.models;

public class EmployeeBonus {
    private String empName;
    private int amount;

    public EmployeeBonus(String empName, int amount) {
        this.empName = empName;
        this.amount = amount;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
