package com.tds.order.detail;

import com.tds.response.ResponseObject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tds/order-detail")
public class OrderDetailController {
    public final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/get-all-order-detail")
    public ResponseObject<List<OrderDetail>> getAllOrderDetail() {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", orderDetailService.getAll());
    }

    @GetMapping("/get-by-id")
    public ResponseObject<OrderDetail> getOrderDetailById(Integer orderDetailId) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", orderDetailService.getById(orderDetailId));
    }


    @PostMapping("/create-order-detail")
    public ResponseObject<OrderDetail> createOrderDetail(@RequestBody @Valid OrderDetail orderDetail) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", orderDetailService.save(orderDetail));
    }

    @DeleteMapping("/delete-by-id")
    public ResponseObject<Integer> deleteOrderDetailById(Integer orderDetailId) {
        orderDetailService.delete(orderDetailId);
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", orderDetailId);
    }
}
