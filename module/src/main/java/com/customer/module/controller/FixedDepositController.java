package com.customer.module.controller;

import com.customer.module.dto.FixedDepositRequest;
import com.customer.module.dto.FixedDepositResponse;
import com.customer.module.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fixeddeposit")
public class FixedDepositController {

    @Autowired
    private FixedDepositService fdService;

    @PostMapping("/create")
    public ResponseEntity<FixedDepositResponse> createFD(@RequestBody FixedDepositRequest request) {
        FixedDepositResponse response = fdService.createFixedDeposit(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getFDsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(fdService.getFixedDepositsByCustomer(customerId));
    }

}
