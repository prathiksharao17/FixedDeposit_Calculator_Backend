package com.customer.module.service;

import com.customer.module.entity.CustomerClassification;
import com.customer.module.repository.CustomerClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerClassificationService {

    @Autowired
    private CustomerClassificationRepository repository;

    public CustomerClassification save(CustomerClassification classification) {
        return repository.save(classification);
    }

    public List<CustomerClassification> getByType(String type) {
        return repository.findByClassificationType(type);
    }

    public List<CustomerClassification> getAll() {
        return repository.findAll();
    }
}
