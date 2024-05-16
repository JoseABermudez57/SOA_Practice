package com.example.orders_service.domain.models.dto.requests;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private List<CreateOrderProductRequest> products;
}
