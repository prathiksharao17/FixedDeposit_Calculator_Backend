package com.customer.module.repository;



import com.customer.module.entity.CustomerClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerClassificationRepository extends JpaRepository<CustomerClassification, Long> {
    List<CustomerClassification> findByClassificationType(String classificationType);
}

