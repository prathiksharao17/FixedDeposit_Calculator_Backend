package com.customer.module.dto;

import com.customer.module.entity.CustomerDetails;
import com.customer.module.entity.CustomerProofOfIdentity;

public class RegisterRequest {
    private String username;
    private String password;
    private String role;
    private CustomerDetails customer;
    private CustomerProofOfIdentity proof;

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public CustomerDetails getCustomer() { return customer; }
    public void setCustomer(CustomerDetails customer) { this.customer = customer; }

    public CustomerProofOfIdentity getProof() { return proof; }
    public void setProof(CustomerProofOfIdentity proof) { this.proof = proof; }
}
