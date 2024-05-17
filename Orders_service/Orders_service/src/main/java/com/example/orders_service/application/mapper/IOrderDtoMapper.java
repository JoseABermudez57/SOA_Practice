package com.example.orders_service.application.mapper;

import com.example.orders_service.domain.models.Order;
import com.example.orders_service.domain.models.OrderProduct;
import com.example.orders_service.application.dtos.requests.CreateOrderRequest;
import com.example.orders_service.application.dtos.response.OrderProductsResponse;
import com.example.orders_service.application.dtos.response.OrderResponse;
import com.example.orders_service.domain.models.enums.Status;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = IOrderProductDtoMapper.class)
public interface IOrderDtoMapper {
    @Mapping(target = "date", expression = "java(new java.util.Date())")
    @Mapping(target = "status", expression = "java(com.example.orders_service.domain.models.enums.Status.PENDING)")
    Order toDomain(CreateOrderRequest orderEntity);

    @Mapping(source = "products", target = "products", qualifiedByName = "mapToOrderProductResponse")
    OrderResponse toResponse(Order order);

    @IterableMapping(qualifiedByName = "mapToOrderProductResponse")
    List<OrderProductsResponse> toResponseList(List<OrderProduct> orderProductList);
    @Named("mapToOrderProductResponse")
    OrderProductsResponse mapToOrderProductResponse(OrderProduct orderProduct);

    default Status map(String status) {
        return Status.valueOf(status);
    }
}