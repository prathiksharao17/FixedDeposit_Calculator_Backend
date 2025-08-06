package com.customer.module.service;

import com.customer.module.entity.CustomerDetails;
import com.customer.module.entity.CustomerName;
import com.customer.module.repository.CustomerDetailsRepository;
import com.customer.module.repository.CustomerNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerNameService {

    @Autowired
    private CustomerNameRepository repository;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    public CustomerName save(CustomerName name) {
        Long customerId = name.getCustomer().getCustomerNumber();
        CustomerDetails customer = customerDetailsRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        name.setCustomer(customer);
        return repository.save(name);
    }

    public List<CustomerName> getByCustomerNumber(Long customerNumber) {
        return repository.findByCustomer_CustomerNumber(customerNumber);
    }

    public List<CustomerName> getAll() {
        return repository.findAll();
    }
}
