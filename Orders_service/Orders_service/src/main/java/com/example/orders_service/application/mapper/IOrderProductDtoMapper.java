package com.example.orders_service.application.mapper;

import com.example.orders_service.domain.models.OrderProduct;
import com.example.orders_service.application.dtos.requests.CreateOrderProductRequest;
import com.example.orders_service.application.dtos.response.OrderProductsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IOrderProductDtoMapper {

    OrderProduct toDomain(CreateOrderProductRequest orderEntity);
    OrderProductsResponse toResponse(OrderProduct order);

}
