package com.example.orders_service.infrastructure.repositories;

import com.example.orders_service.domain.models.OrderProduct;
import com.example.orders_service.domain.port.IOrderProductRepository;
import com.example.orders_service.domain.port.IOrderRepository;
import com.example.orders_service.infrastructure.entities.OrderProductEntity;
import com.example.orders_service.infrastructure.mappers.IOrderEntitiesMapper;
import com.example.orders_service.infrastructure.mappers.IOrderProductEntitiesMapper;
import com.example.orders_service.infrastructure.repositories.jpa.IJpaOrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderProductRepository implements IOrderProductRepository {

    @Autowired
    private IJpaOrderProductRepository jpaRepository;

    @Autowired
    private IOrderProductEntitiesMapper orderProductMapper;

    @Autowired
    private IOrderEntitiesMapper orderMapper;

    @Autowired
    @Lazy
    private IOrderRepository orderRepository;

    @Override
    public OrderProduct save(OrderProduct orderProduct) {
        OrderProductEntity orderProductEntity = orderProductMapper.toEntity(orderProduct);
        orderProductEntity.setOrder(orderMapper.toEntity(orderRepository.findByUuidOrder(orderProduct.getOrderUuid())));
        return orderProductMapper.toDomain(jpaRepository.save(orderProductEntity));
    }
}
