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
public class ShipCompany {
    private int companyID;
    private String companyName;
    private double unitCost;
    private int commitDate;
    private int status;

    public ShipCompany() {
    }

    public ShipCompany(int companyID, String companyName, double unitCost, int commitDate, int status) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.unitCost = unitCost;
        this.commitDate = commitDate;
        this.status = status;
    }

    public ShipCompany(int companyID, String companyName, double unitCost, int commitDate) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.unitCost = unitCost;
        this.commitDate = commitDate;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public int getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(int commitDate) {
        this.commitDate = commitDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
