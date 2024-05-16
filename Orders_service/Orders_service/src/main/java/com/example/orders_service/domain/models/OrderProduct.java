package com.example.orders_service.domain.models;

import lombok.Data;

@Data
public class OrderProduct {
    private String uuid;
    private Long price;
    private Long quantity;
    private String productUuid;
    private String orderUuid;
}
