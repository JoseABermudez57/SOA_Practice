package com.example.orders_service.infrastructure.controllers;

import com.example.orders_service.application.usecases.UpdateOrderStatusUseCase;
import com.example.orders_service.application.dtos.requests.UpdateOrderStatusRequest;
import com.example.orders_service.application.dtos.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UpdateOrderStatusController {

    private final UpdateOrderStatusUseCase updateOrderStatusUseCases;

    public UpdateOrderStatusController(UpdateOrderStatusUseCase updateOrderStatusUseCases) {
        this.updateOrderStatusUseCases = updateOrderStatusUseCases;
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<BaseResponse> update(@PathVariable String uuid, @RequestBody UpdateOrderStatusRequest request) {
        return updateOrderStatusUseCases.excuse(uuid, request).apply();
    }
}
