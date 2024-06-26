package com.example.orders_service.domain.port;

import com.example.orders_service.domain.models.Order;
import com.example.orders_service.domain.models.OrderProduct;

import java.util.List;


public interface IOrderRepository {

    Order save(Order order);
    List<Order> getOrders();
    Order findByUuidOrder(String uuid);
    Order updateOrderStatus(String uuid, String status);
    OrderProduct saveOrderProduct(OrderProduct orderProduct, String orderUuid);

}
