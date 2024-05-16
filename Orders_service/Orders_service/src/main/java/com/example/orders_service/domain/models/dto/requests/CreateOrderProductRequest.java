package com.example.orders_service.domain.models.dto.requests;

import lombok.Data;

@Data
public class CreateOrderProductRequest {
    private Long price;
    private Long quantity;
    private String productUuid;
}