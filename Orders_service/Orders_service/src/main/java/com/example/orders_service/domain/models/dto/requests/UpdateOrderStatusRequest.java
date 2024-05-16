package com.example.orders_service.domain.models.dto.requests;

import lombok.Data;

@Data
public class UpdateOrderStatusRequest {
    private String status;
}
