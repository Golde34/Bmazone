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
    private String wareHouseCity;
    private int status;

    public WareHouse() {
    }

    public WareHouse(int wareHouseID, String wareHouseAddress, String wareHouseCity, int status) {
        this.wareHouseID = wareHouseID;
        this.wareHouseAddress = wareHouseAddress;
        this.wareHouseCity = wareHouseCity;
        this.status = status;
    }

    public WareHouse(int wareHouseID, String wareHouseAddress, String wareHouseCity) {
        this.wareHouseID = wareHouseID;
        this.wareHouseAddress = wareHouseAddress;
        this.wareHouseCity = wareHouseCity;
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

    public String getWareHouseCity() {
        return wareHouseCity;
    }

    public void setWareHouseCity(String wareHouseCity) {
        this.wareHouseCity = wareHouseCity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
