package com.example.orders_service.application.dtos.requests;

import lombok.Data;

@Data
public class UpdateOrderStatusRequest {
    private String status;
}
