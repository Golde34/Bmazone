/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class ProductType {
    private String productTypeId;
    private int productID;
    private String size;
    private String color;
    private double price;
    private int wareHouseID;
    private int quantity;
    private int status;

    public ProductType() {
    }

    public ProductType(String productTypeId, int productID, String size, String color, double price, int wareHouseID, int quantity, int status) {
        this.productTypeId = productTypeId;
        this.productID = productID;
        this.size = size;
        this.color = color;
        this.price = price;
        this.wareHouseID = wareHouseID;
        this.quantity = quantity;
        this.status = status;
    }

    public ProductType(String productTypeId, int productID, String size, String color, double price, int wareHouseID, int quantity) {
        this.productTypeId = productTypeId;
        this.productID = productID;
        this.size = size;
        this.color = color;
        this.price = price;
        this.wareHouseID = wareHouseID;
        this.quantity = quantity;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(int wareHouseID) {
        this.wareHouseID = wareHouseID;
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