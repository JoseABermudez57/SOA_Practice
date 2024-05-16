package com.example.orders_service.application.usecases;

import com.example.orders_service.application.mapper.IOrderDtoMapper;
import com.example.orders_service.domain.models.Order;
import com.example.orders_service.domain.models.dto.response.BaseResponse;
import com.example.orders_service.domain.models.dto.response.OrderResponse;
import com.example.orders_service.domain.port.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrderUseCase {

    private final IOrderRepository orderRepository;

    private final IOrderDtoMapper orderDtoMapper;

    public GetOrderUseCase(IOrderRepository orderRepository, IOrderDtoMapper orderDtoMapper) {
        this.orderRepository = orderRepository;
        this.orderDtoMapper = orderDtoMapper;
    }

    public BaseResponse excuse() {
        List<Order> orders = orderRepository.getOrders();
        List<OrderResponse> responses = orders.stream().map(orderDtoMapper::toResponse).toList();
        if (orders.isEmpty()) {
            return BaseResponse.builder()
                    .data(responses)
                    .message("no orders found")
                    .success(true)
                    .httpStatus(HttpStatus.FOUND).build();
        }else{
            return BaseResponse.builder()
                    .data(responses)
                    .message("find all orders")
                    .success(true)
                    .httpStatus(HttpStatus.FOUND).build();
        }
    }
}
