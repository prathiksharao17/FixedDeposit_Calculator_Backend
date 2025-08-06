package com.customer.module.entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerIdentifier", referencedColumnName = "customerNumber")
    private CustomerDetails customer;

    @ManyToOne
    @JoinColumn(name = "nameComponentType", referencedColumnName = "id")
    private CustomerClassification nameType;

    private String nameValue;
    private LocalDate effectiveDate;

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

    public CustomerClassification getNameType() {
        return nameType;
    }
    public void setNameType(CustomerClassification nameType) {
        this.nameType = nameType;
    }

    public String getNameValue() {
        return nameValue;
    }
    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }
    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
