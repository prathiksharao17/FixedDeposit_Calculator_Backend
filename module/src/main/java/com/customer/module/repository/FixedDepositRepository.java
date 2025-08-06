package com.customer.module.repository;

import com.customer.module.entity.FixedDeposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedDepositRepository extends JpaRepository<FixedDeposit, Long> {
	List<FixedDeposit> findByCustomer_CustomerNumber(Long customerNumber);

    // you can add methods later if needed (e.g. findByCustomer)
}
