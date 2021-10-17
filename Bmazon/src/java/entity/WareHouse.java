/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class WareHouse implements Serializable {
    private static final long serialVersionUID = 1;
    private int wareHouseID;
    private String wareHouseAddress;
    private int status;

    public WareHouse() {
    }

    public WareHouse(int wareHouseID, String wareHouseAddress, int status) {
        this.wareHouseID = wareHouseID;
        this.wareHouseAddress = wareHouseAddress;
        this.status = status;
    }

    public WareHouse(int wareHouseID, String wareHouseAddress) {
        this.wareHouseID = wareHouseID;
        this.wareHouseAddress = wareHouseAddress;
    }

    public int getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(int wareHouseID) {
        this.wareHouseID = wareHouseID;
    }

    public String getWareHouseAddress() {
        return wareHouseAddress;
    }

    public void setWareHouseAddress(String wareHouseAddress) {
        this.wareHouseAddress = wareHouseAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
