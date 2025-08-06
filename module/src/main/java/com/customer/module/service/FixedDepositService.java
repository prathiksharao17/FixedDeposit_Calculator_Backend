package com.customer.module.service;

import com.customer.module.dto.FixedDepositRequest;
import com.customer.module.dto.FixedDepositResponse;
import com.customer.module.entity.CustomerDetails;
import com.customer.module.entity.FixedDeposit;
import com.customer.module.repository.CustomerDetailsRepository;
import com.customer.module.repository.FixedDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FixedDepositService {

    @Autowired
    private FixedDepositRepository fdRepo;

    @Autowired
    private CustomerDetailsRepository customerRepo;

    public FixedDepositResponse createFixedDeposit(FixedDepositRequest request) {

        CustomerDetails customer = customerRepo.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        FixedDeposit fd = new FixedDeposit();

        fd.setPrincipal(request.getPrincipal());
        fd.setRate(request.getRate());
        fd.setTenureYears(request.getTenureYears());
        fd.setTenureMonths(request.getTenureMonths());
        fd.setTenureDays(request.getTenureDays());
        fd.setCompoundingFrequency(request.getCompoundingFrequency().toUpperCase());
        fd.setInterestType(request.getInterestType().toUpperCase());
        fd.setCurrency(request.getCurrency().toUpperCase());
        fd.setCustomer(customer);

        fd.setStartDate(LocalDate.now());

        // Calculate total tenure in years (convert months, days to fraction of year)
        double totalYears = request.getTenureYears() + 
                            request.getTenureMonths() / 12.0 + 
                            request.getTenureDays() / 365.0;

        double maturityAmount;

        if (fd.getInterestType().equals("SIMPLE")) {
            // Simple Interest = P * r * t / 100
            maturityAmount = fd.getPrincipal() + (fd.getPrincipal() * fd.getRate() * totalYears) / 100.0;
        } else {
            // Compound Interest formula: M = P * (1 + r/(100*n))^(n*t)
            int n = getCompoundingPeriods(fd.getCompoundingFrequency());
            double r = fd.getRate() / 100.0;

            maturityAmount = fd.getPrincipal() * Math.pow(1 + r / n, n * totalYears);
        }

        fd.setMaturityAmount(Math.round(maturityAmount * 100.0) / 100.0);  // round to 2 decimals

        fd.setMaturityDate(fd.getStartDate().plusYears(request.getTenureYears())
                         .plusMonths(request.getTenureMonths())
                         .plusDays(request.getTenureDays()));

        fdRepo.save(fd);

        FixedDepositResponse response = new FixedDepositResponse();
        response.setMaturityAmount(fd.getMaturityAmount());
        response.setCurrency(fd.getCurrency());
        response.setMessage("Fixed Deposit created successfully");

        return response;
    }
    public List<FixedDeposit> getFixedDepositsByCustomer(Long customerId) {
        return fdRepo.findByCustomer_CustomerNumber(customerId);
    }



    private int getCompoundingPeriods(String freq) {
        switch (freq) {
            case "DAILY": return 365;
            case "MONTHLY": return 12;
            case "QUARTERLY": return 4;
            case "SEMIANNUAL": return 2;
            case "ANNUAL": return 1;
            default: throw new IllegalArgumentException("Invalid compounding frequency");
        }
    }
}
