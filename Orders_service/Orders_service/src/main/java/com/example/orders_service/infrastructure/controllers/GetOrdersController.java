package com.example.orders_service.infrastructure.controllers;

import com.example.orders_service.application.usecases.GetOrdersUseCase;
import com.example.orders_service.application.dtos.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GetOrdersController {

    private final GetOrdersUseCase getOrdersUseCases;

    public GetOrdersController(GetOrdersUseCase getOrdersUseCases) {
        this.getOrdersUseCases = getOrdersUseCases;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> get() {
        return getOrdersUseCases.excuse().apply();
    }
}
