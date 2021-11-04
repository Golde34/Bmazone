/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author AD
 */
public class Transaction {
    private int transactionID;
    private String userID;
    private double money;
    private String history;
    private int state;
    private int status;

    public Transaction() {
    }

    public Transaction(int transactionID, String userID, double money, String history, int state, int status) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.money = money;
        this.history = history;
        this.state = state;
        this.status = status;
    }
    
    public Transaction(String userID, double money, String history, int state) {
        this.userID = userID;
        this.money = money;
        this.history = history;
        this.state = state;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
