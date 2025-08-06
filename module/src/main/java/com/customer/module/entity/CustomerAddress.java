package com.customer.module.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerIdentifier", referencedColumnName = "customerNumber")
    private CustomerDetails customer;

    @ManyToOne
    @JoinColumn(name = "addressComponentType", referencedColumnName = "id")
    private CustomerClassification addressType;

    private String addressValue;
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

    public CustomerClassification getAddressType() {
        return addressType;
    }

    public void setAddressType(CustomerClassification addressType) {
        this.addressType = addressType;
    }

    public String getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(String addressValue) {
        this.addressValue = addressValue;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
