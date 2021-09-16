/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Gallery;
import entity.ProductType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOGallery {
    

    DBConnection dbConn;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String xSql = null;

    public DAOGallery(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }

    public void deleteGallery(String ProTypeId) {
        String sql = "delete from Gallery where prodụctTypeID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ProTypeId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addGallery(Gallery g) {
        xSql = "INSERT INTO Gallery ([galleryID],[productID],[productTypeID],[link],[status])\n"
                + "     VALUES (?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setInt(1, g.getGalleryID());
            ps.setInt(2, g.getProductID());
            ps.setString(3, g.getProductTypeID());
            ps.setString(4, g.getLink());
            ps.setDouble(5, g.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editGallery(Gallery g) {
        int n = 0;
        xSql = "update Gallery set productID = ? productTypeID = ? link =? status = ? where galleryID = ?";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setInt(1, g.getProductID());
            ps.setString(2, g.getProductTypeID());
            ps.setString(3, g.getLink());
            ps.setDouble(4, g.getStatus());
            ps.setInt(5, g.getGalleryID());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }


    public List<Gallery> getAllGalleryOfProduct(int pid) {
        List<Gallery> list = new ArrayList<>();
        xSql = "select * from Gallery where productID = ?";
        try {
            ps = conn.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

//    public List<Gallery> getGalleryBySizeAndColor(ProductType p) {
//        List<Gallery> list = new ArrayList<>();
//        xSql = "select from ";
//        try {
//            ps = conn.prepareStatement(xSql);
//            ps.setString(1, p.getProductTypeId());
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Gallery(
//                        rs.getInt(1),
//                        rs.getInt(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getInt(5)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }


}
