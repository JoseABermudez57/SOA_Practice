package com.example.orders_service.infrastructure.mappers;

import com.example.orders_service.application.dtos.response.OrderProductsResponse;
import com.example.orders_service.domain.models.Order;
import com.example.orders_service.domain.models.OrderProduct;
import com.example.orders_service.infrastructure.entities.OrderEntity;
import com.example.orders_service.infrastructure.entities.OrderProductEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring", uses = IOrderProductEntitiesMapper.class)
public interface IOrderEntitiesMapper {

    Order toDomain(OrderEntity orderEntity);

    OrderEntity toEntity(Order order);

    @IterableMapping(elementTargetType = OrderProductEntity.class)
    List<OrderProductsResponse> toResponseList(List<OrderProduct> orderProductList);

}
