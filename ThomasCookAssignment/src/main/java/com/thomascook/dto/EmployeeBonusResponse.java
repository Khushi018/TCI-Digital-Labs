package com.thomascook.dto;

import java.util.List;

import com.thomascook.models.CurrencyGroup;

public class EmployeeBonusResponse {
    private String errorMessage;
    private List<CurrencyGroup> data;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<CurrencyGroup> getData() {
        return data;
    }

    public void setData(List<CurrencyGroup> data) {
        this.data = data;
    }
}
