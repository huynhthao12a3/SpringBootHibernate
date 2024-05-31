package com.tds.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }


    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
