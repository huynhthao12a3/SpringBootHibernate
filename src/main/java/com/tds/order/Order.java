package com.tds.order;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private Date createDate
            ;
    private String customerId;

    private String employeeId;

    private float totalOrderPrice;

    public Order() {
    }

    public Order(int orderId, Date createDate, String customerId, String employeeId, float totalOrderPrice) {
        this.orderId = orderId;
        this.createDate = createDate;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.totalOrderPrice = totalOrderPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public float getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(float totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }
}
