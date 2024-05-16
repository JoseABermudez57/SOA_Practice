package com.example.orders_service.application.usecases;

import com.example.orders_service.application.mapper.IOrderDtoMapper;
import com.example.orders_service.application.mapper.IOrderProductDtoMapper;
import com.example.orders_service.domain.models.Order;
import com.example.orders_service.domain.models.OrderProduct;
import com.example.orders_service.domain.models.dto.requests.CreateOrderRequest;
import com.example.orders_service.domain.models.dto.response.BaseResponse;
import com.example.orders_service.domain.models.dto.response.OrderResponse;
import com.example.orders_service.domain.port.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrderUseCase {
    private final IOrderRepository orderRepository;

    private final IOrderDtoMapper orderDtoMapper;

    private final IOrderProductDtoMapper orderProductDtoMapper;

    public CreateOrderUseCase(IOrderProductDtoMapper orderProductDtoMapper, IOrderDtoMapper orderDtoMapper, IOrderRepository orderRepository) {
        this.orderProductDtoMapper = orderProductDtoMapper;
        this.orderDtoMapper = orderDtoMapper;
        this.orderRepository = orderRepository;
    }

    public BaseResponse excuse(CreateOrderRequest request) {
        Order order = orderDtoMapper.toDomain(request);
        order=orderRepository.save(order);
        OrderResponse orderResponse = orderDtoMapper.toResponse(order);

        return BaseResponse.builder()
                .data(orderResponse)
                .message("order created")
                .success(true)
                .httpStatus(org.springframework.http.HttpStatus.CREATED).build();
    }


    private Long getTotal(List<OrderProduct> products) {
        if (products.isEmpty()) {
            return 0L;
        }

        return products.stream()
                .mapToLong(product -> product.getPrice() * product.getQuantity())
                .sum();
    }
}
