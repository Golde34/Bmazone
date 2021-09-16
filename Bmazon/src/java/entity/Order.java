/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author bacon
 */
public class Order {
    private int orderID;
    private String userID;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipPhone;
    private String shipCompany;
    private double shipMoney;
    private double total;
    private int companyID;
    private String paymentMethod;
    private int status;
    
    public Order() {
    }

    public Order(int orderID, String userID, Date orderDate, Date requiredDate, Date shippedDate, String shipName, String shipAddress, String shipCity, String shipPhone, double shipMoney, int companyID, String paymentMethod, double total, int status) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipPhone = shipPhone;
        this.shipCompany = shipCompany;
        this.shipMoney = shipMoney;
        this.total = total;
    }
    
    public Order(int orderID, String userID, Date orderDate, Date requiredDate, Date shippedDate, String shipName, String shipAddress, String shipCity, String shipPhone, double shipMoney, int companyID, String paymentMethod, double total) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipPhone = shipPhone;
        this.shipMoney = shipMoney;
        this.companyID = companyID;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

   

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }
    public String getShipCompany() {
        return shipCompany;
    }

    public void setShipCompany(String shipCompany) {
        this.shipCompany = shipCompany;
    }

    public double getShipMoney() {
        return shipMoney;
    }

    public void setShipMoney(double shipMoney) {
        this.shipMoney = shipMoney;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
