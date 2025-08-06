package com.customer.module.service;

import com.customer.module.entity.CustomerDetails;
import com.customer.module.entity.CustomerClassification;
import com.customer.module.entity.CustomerProofOfIdentity;
import com.customer.module.repository.CustomerDetailsRepository;
import com.customer.module.repository.CustomerClassificationRepository;
import com.customer.module.repository.CustomerProofOfIdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProofOfIdentityService {

    @Autowired
    private CustomerProofOfIdentityRepository repository;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    private CustomerClassificationRepository classificationRepository;

    public CustomerProofOfIdentity save(CustomerProofOfIdentity identity) {
        // Fetch full CustomerDetails using ID
        Long customerId = identity.getCustomer().getCustomerNumber();
        CustomerDetails customer = customerDetailsRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Fetch full Classification (ProofType) using ID
        Long proofTypeId = identity.getProofType().getId();
        CustomerClassification proofType = classificationRepository.findById(proofTypeId)
                .orElseThrow(() -> new RuntimeException("ProofType not found"));

        // Set fully loaded entities
        identity.setCustomer(customer);
        identity.setProofType(proofType);

        return repository.save(identity);
    }

    public List<CustomerProofOfIdentity> getByCustomerNumber(Long customerNumber) {
        return repository.findByCustomer_CustomerNumber(customerNumber);
    }

    public List<CustomerProofOfIdentity> getAll() {
        return repository.findAll();
    }
}
