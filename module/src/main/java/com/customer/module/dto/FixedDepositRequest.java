package com.customer.module.dto;

public class FixedDepositRequest {

    private double principal;

    private double rate;

    private int tenureYears;

    private int tenureMonths;

    private int tenureDays;

    private String compoundingFrequency; // DAILY, MONTHLY, QUARTERLY, SEMIANNUAL, ANNUAL

    private String interestType; // SIMPLE or COMPOUND

    private String currency; // INR, USD, EUR, GBP

    private Long customerId;  // to link with customer

    // Getters and setters
    public double getPrincipal() { return principal; }
    public void setPrincipal(double principal) { this.principal = principal; }

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }

    public int getTenureYears() { return tenureYears; }
    public void setTenureYears(int tenureYears) { this.tenureYears = tenureYears; }

    public int getTenureMonths() { return tenureMonths; }
    public void setTenureMonths(int tenureMonths) { this.tenureMonths = tenureMonths; }

    public int getTenureDays() { return tenureDays; }
    public void setTenureDays(int tenureDays) { this.tenureDays = tenureDays; }

    public String getCompoundingFrequency() { return compoundingFrequency; }
    public void setCompoundingFrequency(String compoundingFrequency) { this.compoundingFrequency = compoundingFrequency; }

    public String getInterestType() { return interestType; }
    public void setInterestType(String interestType) { this.interestType = interestType; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
