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
public class Category implements Serializable {

    private static final long serialVersionUID = 1;
    private int categoryID;
    private String categoryName;
    private int status;

    public Category() {
    }

    public Category(String categoryName, int status) {
        this.categoryName = categoryName;
        this.status = status;
    }

    public Category(int categoryID, String categoryName, int status) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.status = status;
    }

    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
