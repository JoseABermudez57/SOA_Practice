package com.example.orders_service.application.dtos.response;

import lombok.Data;

@Data
public class OrderProductsResponse {
    private String uuid;

    private Long price;

    private Long quantity;

    private String productUuid;

    private String orderUuid;
}