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
public class Genre {
    private int genreID;
    private String genreName;
    private int categoryID;
    private int status;

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
    
}
