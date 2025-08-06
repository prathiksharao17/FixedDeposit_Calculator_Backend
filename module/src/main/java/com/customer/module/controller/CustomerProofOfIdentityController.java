package com.customer.module.controller;

import com.customer.module.entity.CustomerProofOfIdentity;
import com.customer.module.service.CustomerProofOfIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proof")
public class CustomerProofOfIdentityController {

    @Autowired
    private CustomerProofOfIdentityService service;

    @PostMapping("/add")
    public CustomerProofOfIdentity addProof(@RequestBody CustomerProofOfIdentity proof) {
        return service.save(proof);
    }

    @GetMapping("/customer/{customerNumber}")
    public List<CustomerProofOfIdentity> getByCustomer(@PathVariable Long customerNumber) {
        return service.getByCustomerNumber(customerNumber);
    }


    @GetMapping("/all")
    public List<CustomerProofOfIdentity> getAll() {
        return service.getAll();
    }
}
