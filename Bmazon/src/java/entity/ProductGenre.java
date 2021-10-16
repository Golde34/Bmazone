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
public class ProductGenre implements Serializable {
    private int productID;
    private int genreID;
    private int status;

    public ProductGenre() {
    }

    public ProductGenre(int productID, int genreID, int status) {
        this.productID = productID;
        this.genreID = genreID;
        this.status = status;
    }

    public ProductGenre(int productID, int genreID) {
        this.productID = productID;
        this.genreID = genreID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
