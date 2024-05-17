package com.example.orders_service.infrastructure.repositories.jpa;

import com.example.orders_service.infrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IJpaOrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByUuid(String uuid);
}
