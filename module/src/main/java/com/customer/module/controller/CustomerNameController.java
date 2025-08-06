package com.customer.module.controller;

import com.customer.module.entity.CustomerName;
import com.customer.module.service.CustomerNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-name")
public class CustomerNameController {

    @Autowired
    private CustomerNameService service;

    @PostMapping("/add")
    public CustomerName addName(@RequestBody CustomerName name) {
        return service.save(name);
    }

    @GetMapping("/customer/{customerNumber}")
    public List<CustomerName> getByCustomer(@PathVariable Long customerNumber) {
        return service.getByCustomerNumber(customerNumber);
    }


    @GetMapping("/all")
    public List<CustomerName> getAll() {
        return service.getAll();
    }
}
