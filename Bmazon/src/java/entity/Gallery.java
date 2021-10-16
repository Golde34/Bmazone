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
public class Gallery implements Serializable {
    private int galleryID;
    private int productID;
    private String productTypeID;
    private String link;
    private int status;

    public Gallery() {
    }

    public Gallery(int galleryID, int productID, String productTypeID, String link, int status) {
        this.galleryID = galleryID;
        this.productID = productID;
        this.productTypeID = productTypeID;
        this.link = link;
        this.status = status;
    }
    
    public Gallery(int galleryID, int productID, String productTypeID, String link) {
        this.galleryID = galleryID;
        this.productID = productID;
        this.productTypeID = productTypeID;
        this.link = link;
    }

    public int getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(int galleryID) {
        this.galleryID = galleryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(String productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
