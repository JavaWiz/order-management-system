package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    private Long productId;
    @Column(name="product_code")
    private String productCode;
    @Column(name="product_name")
    private String productName;
    private Integer quantity;
    private Long orderId;
}
