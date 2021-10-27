/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author bacon
 */
public class Order implements Serializable {

    private int orderID;
    private String userID;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipPhone;
    private double shipMoney;
    private double total;
    private int companyID;
    private String paymentMethod;
    private int state;
    private int status;

    private static final long serialVersionUID = 1;

    public Order() {
    }

    public Order(String userID, String shipName, String shipAddress, String shipCity, String shipPhone, double shipMoney, double total, int companyID, String paymentMethod, int state) {

        this.userID = userID;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipPhone = shipPhone;
        this.shipMoney = shipMoney;
        this.total = total;
        this.companyID = companyID;
        this.paymentMethod = paymentMethod;
        this.state = state;
    }

    public Order(int orderID, String userID, Date orderDate, Date requiredDate, Date shippedDate, String shipName, String shipAddress, String shipCity, String shipPhone, double shipMoney, double total, int companyID, String paymentMethod, int state,int status) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = new Date(orderDate.getTime());
        this.requiredDate = new Date(requiredDate.getTime());
        this.shippedDate = new Date(shippedDate.getTime());
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipPhone = shipPhone;
        this.shipMoney = shipMoney;
        this.total = total;
        this.companyID = companyID;
        this.paymentMethod = paymentMethod;
        this.state = state;
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
        return new Date(orderDate.getTime());
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = new Date(orderDate.getTime());
    }

    public Date getRequiredDate() {
        return new Date(requiredDate.getTime());
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = new Date(requiredDate.getTime());
    }

    public Date getShippedDate() {
        return new Date(shippedDate.getTime());
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = new Date(shippedDate.getTime());
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
}
