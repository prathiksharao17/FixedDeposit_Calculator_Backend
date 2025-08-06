package com.customer.module.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fixed_deposits")
public class FixedDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double principal;

    private double rate;

    private int tenureYears;

    private int tenureMonths;

    private int tenureDays;

    private String compoundingFrequency;  // DAILY, MONTHLY, QUARTERLY, SEMIANNUAL, ANNUAL

    private String interestType;  // SIMPLE or COMPOUND

    private double maturityAmount;

    private String currency;  // INR, USD, EUR, GBP

    private LocalDate startDate;

    private LocalDate maturityDate;

    // Optional: relation to User or CustomerDetails
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerDetails customer;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public double getMaturityAmount() { return maturityAmount; }
    public void setMaturityAmount(double maturityAmount) { this.maturityAmount = maturityAmount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getMaturityDate() { return maturityDate; }
    public void setMaturityDate(LocalDate maturityDate) { this.maturityDate = maturityDate; }

    public CustomerDetails getCustomer() { return customer; }
    public void setCustomer(CustomerDetails customer) { this.customer = customer; }
}
