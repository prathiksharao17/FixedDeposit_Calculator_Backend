package com.customer.module.controller;



import com.customer.module.entity.CustomerClassification;
import com.customer.module.service.CustomerClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classification")
public class CustomerClassificationController {

    @Autowired
    private CustomerClassificationService service;

    @PostMapping("/add")
    public CustomerClassification addClassification(@RequestBody CustomerClassification classification) {
        return service.save(classification);
    }

    @GetMapping("/type/{type}")
    public List<CustomerClassification> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    @GetMapping("/all")
    public List<CustomerClassification> getAll() {
        return service.getAll();
    }
}

