package com.example.orders_service.application.usecases;

import com.example.orders_service.application.mapper.IOrderDtoMapper;
import com.example.orders_service.domain.models.Order;
import com.example.orders_service.domain.models.dto.requests.UpdateOrderStatusRequest;
import com.example.orders_service.domain.models.dto.response.BaseResponse;
import com.example.orders_service.domain.models.dto.response.OrderResponse;
import com.example.orders_service.domain.port.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UpdateOderStatusUseCase {

    private final IOrderRepository orderRepository;

    private final IOrderDtoMapper orderDtoMapper;

    public UpdateOderStatusUseCase(IOrderDtoMapper orderDtoMapper, IOrderRepository orderRepository) {
        this.orderDtoMapper = orderDtoMapper;
        this.orderRepository = orderRepository;
    }

    public BaseResponse excuse(String uuid, UpdateOrderStatusRequest request) {
        Order order = orderRepository.updateOrderStatus(uuid, request.getStatus());
        OrderResponse response = orderDtoMapper.toResponse(order);

        return BaseResponse.builder()
                .data(response)
                .message("order status updated")
                .success(true)
                .httpStatus(HttpStatus.OK).build();
    }
}
