package com.customer.module.controller;



import com.customer.module.entity.CustomerIdentification;
import com.customer.module.service.CustomerIdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-identification")
public class CustomerIdentificationController {

    @Autowired
    private CustomerIdentificationService service;

    @PostMapping("/add")
    public CustomerIdentification add(@RequestBody CustomerIdentification identification) {
        return service.save(identification);
    }

    @GetMapping("/all")
    public List<CustomerIdentification> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CustomerIdentification getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}

