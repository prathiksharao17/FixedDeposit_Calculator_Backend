package com.customer.module.service;

import com.customer.module.entity.CustomerAddress;
import com.customer.module.entity.CustomerDetails;
import com.customer.module.repository.CustomerAddressRepository;
import com.customer.module.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressService {

    @Autowired
    private CustomerAddressRepository repository;

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    public CustomerAddress save(CustomerAddress address) {
        Long customerId = address.getCustomer().getCustomerNumber();
        CustomerDetails customer = customerDetailsRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        address.setCustomer(customer);
        return repository.save(address);
    }

    public List<CustomerAddress> getByCustomerNumber(Long customerNumber) {
        return repository.findByCustomer_CustomerNumber(customerNumber);
    }

    public List<CustomerAddress> getAll() {
        return repository.findAll();
    }
}
