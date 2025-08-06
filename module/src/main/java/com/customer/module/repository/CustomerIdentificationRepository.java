package com.customer.module.repository;



import com.customer.module.entity.CustomerIdentification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerIdentificationRepository extends JpaRepository<CustomerIdentification, Long> {
    Optional<CustomerIdentification> findByIdentificationItem(String item);
}

