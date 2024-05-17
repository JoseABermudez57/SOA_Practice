package com.example.orders_service.infrastructure.controllers;

import com.example.orders_service.application.usecases.CreateOrderUseCase;
import com.example.orders_service.application.dtos.requests.CreateOrderRequest;
import com.example.orders_service.application.dtos.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CreateOrdersController {

    private final CreateOrderUseCase createOrdersUseCases;

    public CreateOrdersController(CreateOrderUseCase createOrdersUseCases) {
        this.createOrdersUseCases = createOrdersUseCases;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateOrderRequest request) {
        return createOrdersUseCases.excuse(request).apply();
    }

}
