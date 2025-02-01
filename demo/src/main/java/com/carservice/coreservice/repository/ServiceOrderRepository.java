package com.carservice.coreservice.repository;

import com.carservice.coreservice.service.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}