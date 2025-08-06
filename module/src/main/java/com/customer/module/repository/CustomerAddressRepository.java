package com.customer.module.repository;

import com.customer.module.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long> {
	List<CustomerAddress> findByCustomer_CustomerNumber(Long customerNumber);
}