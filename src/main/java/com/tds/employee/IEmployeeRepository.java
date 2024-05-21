package com.tds.employee;

import com.tds.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "select * from employee where employee_name like %:keyword%", nativeQuery = true)
    List<Employee> findEmployeeListByName(@Param("keyword") String employeeName);

}
