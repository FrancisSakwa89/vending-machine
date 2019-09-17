package com.franco.models;

import java.sql.Date;

public class SaleProduct {
    String productName;
    int quantity;
    double price;
    double total;
    Date date;
    String CustomerName;

    public SaleProduct() {
    }

    public SaleProduct(String productName, int quantity, double price, double total, Date date, String customerName) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.date = date;
        CustomerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
}
