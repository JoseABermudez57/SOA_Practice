package com.example.orders_service.infrastructure.mappers;

import com.example.orders_service.domain.models.OrderProduct;
import com.example.orders_service.infrastructure.entities.OrderProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IOrderProductEntitiesMapper {

    @Mapping(source = "order.uuid", target = "orderUuid")
    OrderProduct toDomain(OrderProductEntity orderProductEntity);
    OrderProductEntity toEntity(OrderProduct orderProduct);

}
