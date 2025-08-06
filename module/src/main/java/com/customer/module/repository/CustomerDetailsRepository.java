package com.customer.module.repository;

import com.customer.module.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
}
