package com.example.orders_service.domain.port;

import com.example.orders_service.domain.models.OrderProduct;

public interface IOrderProductRepository {
    OrderProduct save(OrderProduct orderProduct);

}
