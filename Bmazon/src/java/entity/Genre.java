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
public class Genre implements Serializable {
    private static final long serialVersionUID = 1;
    private int genreID;
    private String genreName;
    private int categoryID;
    private int status;
    private String images;

    public Genre() {
    }

    public Genre(int genreID, String genreName, int categoryID, int status) {
        this.genreID = genreID;
        this.genreName = genreName;
        this.categoryID = categoryID;
        this.status = status;
    }
    public Genre(int genreID, String genreName, int categoryID) {
        this.genreID = genreID;
        this.genreName = genreName;
        this.categoryID = categoryID;
    }

    public Genre(int genreID, String genreName, int categoryID, int status, String images) {
        this.genreID = genreID;
        this.genreName = genreName;
        this.categoryID = categoryID;
        this.status = status;
        this.images = images;
    }
    
    public Genre(String genreName, int categoryID, int status) {
        this.genreName = genreName;
        this.categoryID = categoryID;
        this.status = status;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    
    
}
