package com.tds.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "select * from customer where upper(customer_name) like %:keyword% ", nativeQuery = true)
    public List<Customer> getCustomerListByCustomerName(@Param("keyword") String keyword);
}
