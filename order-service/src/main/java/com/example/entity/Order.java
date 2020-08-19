package com.example.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_t")
public class Order {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long orderId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    @Column(name="shipping_address")
    private String shippingAddress;

    @Column(name="order_total")
    private BigDecimal orderTotal;
}
