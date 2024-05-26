package com.tds.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

// gói jakarta dùng version 3.x
// gói javax dùng version 2.x

import java.sql.Date;

@Entity
@Table(name = "product") // auto map if the ClassName = TableName
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    String productId;

    @Size(min = 10, message = "Product name must be at least 10 characters")
    @Column(name = "product_name")
    String productName;

    @Column(name = "remark")
    String remark;

    @Min(value = 1000, message = "Input price must be greater than or equal to 1000")
    @Column(name = "input_price")
    float inputPrice;

    @Min(value = 1000)
    @Column(name = "output_price")
    float outputPrice;

    @Column(name = "input_date")
    Date inputDate;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "expired_date")
    Date expiredDate;

    @Column(name = "image")
    byte[] image;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public float getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(float inputPrice) {
        this.inputPrice = inputPrice;
    }

    public float getOutputPrice() {
        return outputPrice;
    }

    public void setOutputPrice(float outputPrice) {
        this.outputPrice = outputPrice;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

