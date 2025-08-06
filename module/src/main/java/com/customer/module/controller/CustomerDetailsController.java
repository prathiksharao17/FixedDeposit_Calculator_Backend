package com.customer.module.controller;



import com.customer.module.entity.CustomerDetails;
import com.customer.module.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerDetailsController {

    @Autowired
    private CustomerDetailsService service;

    @PostMapping("/add")
    public CustomerDetails addCustomer(@RequestBody CustomerDetails customer) {
        return service.save(customer);
    }

    @GetMapping("/all")
    public List<CustomerDetails> getAllCustomers() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CustomerDetails> getCustomerById(@PathVariable Long id) {
        return service.getById(id);
    }
}

