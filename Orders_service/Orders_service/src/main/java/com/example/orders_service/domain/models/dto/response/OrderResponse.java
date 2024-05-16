package com.example.orders_service.domain.models.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private String uuid;
    private Long total;
    private String date;
    private String status;
    private List<OrderProductsResponse> products;
}

