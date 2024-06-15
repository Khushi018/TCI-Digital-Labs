package com.thomascook.models;

import java.util.List;

public class CurrencyGroup {
    private String currency;
    private List<EmployeeBonus> employees;

    public CurrencyGroup(String currency, List<EmployeeBonus> employees) {
        this.currency = currency;
        this.employees = employees;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<EmployeeBonus> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBonus> employees) {
        this.employees = employees;
    }
}
