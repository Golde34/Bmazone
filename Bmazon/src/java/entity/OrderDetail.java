/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author bacon
 */
public class OrderDetail implements Serializable {
    private int orderID;
    private String productTypeId;
    private String productName;
    private double price;
    private int quantity;
    private int status;

    public OrderDetail() {
    }

    public OrderDetail(int orderID, String productTypeId, String productName, double price, int quantity, int status) {
        this.orderID = orderID;
        this.productTypeId = productTypeId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public OrderDetail(int orderID, String productTypeId, String productName, double price, int quantity) {
        this.orderID = orderID;
        this.productTypeId = productTypeId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

   
    
 

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
