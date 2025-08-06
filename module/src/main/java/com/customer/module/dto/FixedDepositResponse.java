package com.customer.module.dto;

public class FixedDepositResponse {

    private double maturityAmount;

    private String currency;

    private String message; // optional message

    // getters & setters
    public double getMaturityAmount() { return maturityAmount; }
    public void setMaturityAmount(double maturityAmount) { this.maturityAmount = maturityAmount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
