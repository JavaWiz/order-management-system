package com.example.service;

import com.example.entity.Order;
import com.example.exception.OrderNotFoundException;
import com.example.model.OrderRequest;
import com.example.model.OrderResponse;
import com.example.model.ProductRequest;
import com.example.model.ProductResponse;
import com.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductService productService;

    public OrderResponse createOrder(OrderRequest orderRequest){
        Order order = orderRepository.save(Order.builder()
                .customerName(orderRequest.getCustomerName())
                .orderTotal(orderRequest.getOrderTotal())
                .shippingAddress(orderRequest.getShippingAddress())
                .orderDate(LocalDateTime.now())
                .build());

        ProductResponse productResponse = productService.saveProducts(ProductRequest.builder().
                products(orderRequest.getProducts())
                .orderId(order.getOrderId()).build());
        return OrderResponse.builder().response("Order created with order id="+order.getOrderId()).build();
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Could not find a product with order id :"+orderId));
    }
}
