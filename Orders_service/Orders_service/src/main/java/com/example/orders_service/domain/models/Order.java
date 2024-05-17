package com.example.orders_service.domain.models;

import com.example.orders_service.domain.models.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class Order {
    private String uuid;
    private Long total;
    private Date date;
    private Status status;
    private List<OrderProduct> products;
}
