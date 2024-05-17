package com.example.orders_service.infrastructure.entities;

import com.example.orders_service.domain.models.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderEntity {
    @Id
    @UuidGenerator
    private String uuid;

    @Column(nullable = false)
    private long total;

    @Column(nullable = false)
    private Date date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "order")
    private List<OrderProductEntity> products;
}
