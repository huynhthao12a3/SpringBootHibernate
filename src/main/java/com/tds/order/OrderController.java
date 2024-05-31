package com.tds.order;

import com.tds.response.ResponseObject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tds/order")
public class OrderController {
    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get-all-order")
    public ResponseObject<List<Order>> getAllOrder() {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", orderService.getAll());
    }

    @GetMapping("/get-by-id")
    public ResponseObject<Order> getOrderById(Integer orderId) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", orderService.getById(orderId));
    }


    @PostMapping("/create-order")
    public ResponseObject<Order> createOrder(@RequestBody @Valid Order order) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", orderService.save(order));
    }

    @DeleteMapping("/delete-by-id")
    public ResponseObject<Integer> deleteOrderById(Integer orderId) {
        orderService.delete(orderId);
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", orderId);
    }
}
