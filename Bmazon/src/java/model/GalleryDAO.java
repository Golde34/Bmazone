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
public class GalleryDAO extends BaseDAO{

    public GalleryDAO(DBConnection dbCon) {
        super(dbCon);
    }

    public void deleteGallery(String ProTypeId) {
        String sql = "delete from Gallery where prodụctTypeID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, ProTypeId);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addGallery(Gallery g) {
        xSql = "INSERT INTO Gallery ([galleryID],[productID],[productTypeID],[link],[status])\n"
                + "     VALUES (?,?,?,?,?)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, g.getGalleryID());
            pre.setInt(2, g.getProductID());
            pre.setString(3, g.getProductTypeID());
            pre.setString(4, g.getLink());
            pre.setDouble(5, g.getStatus());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editGallery(Gallery g) {
        int n = 0;
        xSql = "update Gallery set productID = ? productTypeID = ? link =? status = ? where galleryID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, g.getProductID());
            pre.setString(2, g.getProductTypeID());
            pre.setString(3, g.getLink());
            pre.setDouble(4, g.getStatus());
            pre.setInt(5, g.getGalleryID());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }


    public List<Gallery> getAllGalleryOfProduct(int pid) {
        List<Gallery> list = new ArrayList<>();
        xSql = "select * from Gallery where productID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
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