package com.customer.module.controller;

import com.customer.module.entity.CustomerAddress;
import com.customer.module.service.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService service;

    @PostMapping("/add")
    public CustomerAddress addAddress(@RequestBody CustomerAddress address) {
        return service.save(address);
    }

    @GetMapping("/customer/{customerNumber}")
    public List<CustomerAddress> getByCustomer(@PathVariable Long customerNumber) {
        return service.getByCustomerNumber(customerNumber);
    }



    @GetMapping("/all")
    public List<CustomerAddress> getAll() {
        return service.getAll();
    }
}
