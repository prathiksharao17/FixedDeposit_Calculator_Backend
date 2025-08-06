package com.customer.module.entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificationType;     // e.g., PAN, AADHAR
    private String identificationItem;     // actual ID number or value
    private LocalDate effectiveDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}
	public String getIdentificationItem() {
		return identificationItem;
	}
	public void setIdentificationItem(String identificationItem) {
		this.identificationItem = identificationItem;
	}
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

    
}

