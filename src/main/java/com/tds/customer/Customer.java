package com.tds.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customerId;

    @NotNull(message = "Customer name can not null")
    private String customerName;

    private String customerAddress;

    @Size(min = 10, max = 12, message = "Phone only has 10 to 12 numbers")
    private String customerPhone;

    private String customerEmail;

    private float customerPoint;

    private boolean customerBackListFlag;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String customerAddress, String customerPhone, String customerEmail, float customerPoint, boolean customerBackListFlag) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerPoint = customerPoint;
        this.customerBackListFlag = customerBackListFlag;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public float getCustomerPoint() {
        return customerPoint;
    }

    public void setCustomerPoint(float customerPoint) {
        this.customerPoint = customerPoint;
    }

    public boolean isCustomerBackListFlag() {
        return customerBackListFlag;
    }

    public void setCustomerBackListFlag(boolean customerBackListFlag) {
        this.customerBackListFlag = customerBackListFlag;
    }
}
