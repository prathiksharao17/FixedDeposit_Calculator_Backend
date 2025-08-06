package com.customer.module.entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
    @SequenceGenerator(name = "cust_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long customerNumber;

    private String customerType; // FK to classification
    private String fullName;
    private LocalDate dateOfBirth;
    private String status;
    private String contactNumber;
    private String mobileNumber;
    private String email;
    private String countryOfOrigination;
    private LocalDate effectiveDate;
	public Long getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountryOfOrigination() {
		return countryOfOrigination;
	}
	public void setCountryOfOrigination(String countryOfOrigination) {
		this.countryOfOrigination = countryOfOrigination;
	}
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

    // Getters and Setters
    
}

