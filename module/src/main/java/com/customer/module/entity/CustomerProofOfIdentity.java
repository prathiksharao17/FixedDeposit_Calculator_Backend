package com.customer.module.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerProofOfIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerIdentifier", referencedColumnName = "customerNumber")
    private CustomerDetails customer;

    @ManyToOne
    @JoinColumn(name = "proofOfIdType", referencedColumnName = "id")
    private CustomerClassification proofType;

    private String proofValue;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate effectiveDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }

    public CustomerClassification getProofType() {
        return proofType;
    }

    public void setProofType(CustomerClassification proofType) {
        this.proofType = proofType;
    }

    public String getProofValue() {
        return proofValue;
    }

    public void setProofValue(String proofValue) {
        this.proofValue = proofValue;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
