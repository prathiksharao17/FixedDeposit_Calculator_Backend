package com.customer.module.repository;

import com.customer.module.entity.CustomerProofOfIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerProofOfIdentityRepository extends JpaRepository<CustomerProofOfIdentity, Long> {
	List<CustomerProofOfIdentity> findByCustomer_CustomerNumber(Long customerNumber);
}
