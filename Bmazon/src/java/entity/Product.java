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
 * @author Admin
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1;
    private int productID;
    private String productName;
    private String description;
    private int rating;
    private Date releaseDate;
    private int seller;
    private int status;

    public Product() {
    }

    public Product(int productID, String productName, String description, int rating, Date releaseDate, int seller, int status) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.rating = rating;
        this.releaseDate = new Date(releaseDate.getTime());
        this.seller = seller;
        this.status = status;
    }
    
    public Product(int productID, String productName, String description, int rating, Date releaseDate, int seller) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.rating = rating;
        this.releaseDate = new Date(releaseDate.getTime());
        this.seller = seller;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getReleaseDate() {
        return new Date(releaseDate.getTime());
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = new Date(releaseDate.getTime());
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", description=" + description + ", rating=" + rating + ", releaseDate=" + releaseDate + ", seller=" + seller + ", status=" + status + '}';
    }
    
}