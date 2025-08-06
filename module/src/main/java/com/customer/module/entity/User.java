package com.customer.module.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password; // will be stored as encoded

    private String role; // CUSTOMER or MANAGER

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerDetails customer;
    
    public enum Role {
        CUSTOMER,
        BANK_MANAGER
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
    
    
}

