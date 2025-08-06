package com.customer.module.service;

import com.customer.module.entity.CustomerDetails;
import com.customer.module.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsService {

    @Autowired
    private CustomerDetailsRepository repository;

    public CustomerDetails save(CustomerDetails customer) {
        return repository.save(customer);
    }

    public List<CustomerDetails> getAll() {
        return repository.findAll();
    }

    public Optional<CustomerDetails> getById(Long id) {
        return repository.findById(id);
    }
}

