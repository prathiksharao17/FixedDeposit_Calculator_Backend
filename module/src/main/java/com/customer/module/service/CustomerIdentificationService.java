package com.customer.module.service;



import com.customer.module.entity.CustomerIdentification;
import com.customer.module.repository.CustomerIdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerIdentificationService {

    @Autowired
    private CustomerIdentificationRepository repository;

    public CustomerIdentification save(CustomerIdentification identification) {
        // Check if value already exists
        Optional<CustomerIdentification> existing = repository.findByIdentificationItem(identification.getIdentificationItem());
        if (existing.isPresent()) {
            throw new RuntimeException("Duplicate identification value!");
        }
        return repository.save(identification);
    }

    public List<CustomerIdentification> getAll() {
        return repository.findAll();
    }

    public Optional<CustomerIdentification> getById(Long id) {
        return repository.findById(id);
    }
}

