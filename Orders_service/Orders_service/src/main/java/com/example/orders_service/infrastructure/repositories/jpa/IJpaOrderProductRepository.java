package com.example.orders_service.infrastructure.repositories.jpa;

import com.example.orders_service.infrastructure.entities.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpaOrderProductRepository extends JpaRepository<OrderProductEntity, Long> {
}
