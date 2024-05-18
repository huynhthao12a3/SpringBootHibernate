package com.tds.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, String>
{
    @Query(value = "select * from product where product_name like %:keyword%", nativeQuery = true)
    List<Product> findProductListByName(@Param("keyword") String productName);



}
