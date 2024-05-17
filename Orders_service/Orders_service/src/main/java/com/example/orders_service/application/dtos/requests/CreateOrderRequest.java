package com.example.orders_service.application.dtos.requests;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private List<CreateOrderProductRequest> products;
}
