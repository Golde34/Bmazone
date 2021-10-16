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
public class ProductCategory implements Serializable {
    private int productID;
    private int categoryID;
    private int status;

    public ProductCategory() {
    }

    public ProductCategory(int productID, int categoryID, int status) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.status = status;
    }

    public ProductCategory(int productID, int categoryID) {
        this.productID = productID;
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    } 
}
