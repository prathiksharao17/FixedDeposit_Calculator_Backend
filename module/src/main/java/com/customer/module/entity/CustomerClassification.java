package com.customer.module.entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CustomerClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classificationType; // e.g., ID_TYPE
    private String classificationValue; // e.g., PAN, AADHAR
    private LocalDate effectiveDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClassificationType() {
		return classificationType;
	}
	public void setClassificationType(String classificationType) {
		this.classificationType = classificationType;
	}
	public String getClassificationValue() {
		return classificationValue;
	}
	public void setClassificationValue(String classificationValue) {
		this.classificationValue = classificationValue;
	}
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

    // Getters and Setters
    
}
