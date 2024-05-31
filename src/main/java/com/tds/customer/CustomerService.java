package com.tds.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    public final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(String customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public List<Customer> getByName(String customerName) {
        return customerRepository.getCustomerListByCustomerName(customerName.toUpperCase());
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
