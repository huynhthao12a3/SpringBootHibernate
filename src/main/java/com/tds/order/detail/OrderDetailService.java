package com.tds.order.detail;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    public final IOrderDetailRepository orderDetailRepository;

    public OrderDetailService(IOrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail getById(Integer orderDetailId) {
        return orderDetailRepository.findById(orderDetailId).orElse(null);
    }


    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public void delete(Integer orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }
}
