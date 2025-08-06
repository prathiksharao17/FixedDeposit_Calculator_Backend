package com.customer.module.repository;

import com.customer.module.entity.CustomerName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerNameRepository extends JpaRepository<CustomerName, Long> {
	List<CustomerName> findByCustomer_CustomerNumber(Long customerNumber);

}

