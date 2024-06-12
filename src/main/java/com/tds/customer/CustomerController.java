package com.tds.customer;

import com.tds.response.ResponseObject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/tds/customer")
@EnableScheduling
public class CustomerController {
    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Scheduled(cron = "0 15,35,55 * ? * *")
    @GetMapping("/get-all-customer")
    public ResponseObject<List<Customer>> getAllCustomer() {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", customerService.getAll());
    }

    @GetMapping("/get-by-id")
    public ResponseObject<Customer> getCustomerById(String customerId) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", customerService.getById(customerId));
    }

    @GetMapping("/get-by-name")
    public ResponseObject<List<Customer>> getCustomerByName(String customerName) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", customerService.getByName(customerName));
    }

    @PostMapping("/create-customer")
    public ResponseObject<Customer> createCustomer(@RequestBody @Valid Customer customer) {
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", customerService.save(customer));
    }

    @DeleteMapping("/delete-by-id")
    public ResponseObject<String> deleteCustomerById(String customerId) {
        customerService.delete(customerId);
        return new ResponseObject<>(true, String.valueOf(HttpStatus.OK.value()), "Success", customerId);
    }
}
