/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class DAOProductType {

    DBConnection dbConn;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String xSql = null;

    public DAOProductType(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }

    public void deleteProductType(String ProTypeId) {
        String sql = "delete from ProductType where prodụctTypeID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ProTypeId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addProductType(ProductType p) {
        xSql = "INSERT INTO ProductType ([productTypeId],[productID],[size],[color],[price],[wareHouseID],[quantity],[status])\n"
                + "     VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setString(1, p.getProductTypeId());
            ps.setInt(2, p.getProductID());
            ps.setString(3, p.getSize());
            ps.setString(4, p.getColor());
            ps.setDouble(5, p.getPrice());
            ps.setInt(6, p.getWareHouseID());
            ps.setInt(7, p.getQuantity());
            ps.setInt(8, p.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editProduct(ProductType p) {
        int n = 0;
        xSql = "update product set productID = ? size = ? color = ? price =? wareHouseID = ? quantity = ? status = ? where productTypeId = ?";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setInt(1, p.getProductID());
            ps.setString(2, p.getSize());
            ps.setString(3, p.getColor());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getWareHouseID());
            ps.setInt(6, p.getQuantity());
            ps.setInt(7, p.getStatus());
            ps.setString(8, p.getProductTypeId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public int checkoutProductType(int ProTypeId, int quantity) {
        int n = 0;
        xSql = "update product set quantity =? where productTypeId = ?";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setInt(1, quantity);
            ps.setInt(2, ProTypeId);
            n = ps.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public List<ProductType> getAllProductType() {
        List<ProductType> list = new ArrayList<>();
        xSql = "select * from ProductType where status = 1";
        try {
            ps = conn.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ProductType getProductTypeByPTypeID(int ProTypeId) {
        ProductType ptype = new ProductType();
        xSql = "select * from ProductType where ProTypeId = ?";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setInt(1, ProTypeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                ptype = new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return ptype;
    }

    public List<ProductType> getProductByProductID(String pid) {
        List<ProductType> list = new ArrayList<>();
        xSql = "select * from ProductType where pid = ?";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<ProductType> getProductByColor(String color) {
        ArrayList<ProductType> list = new ArrayList<>();
        xSql = "SELECT * FROM ProductType WHERE color like ?";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setString(1, "%" + color + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
//
//    public int getMaxQuantity(int pid) {
//        xSql = "select quantity from product where id = ?";
//        try {
//            ps = conn.prepareStatement(xSql);
//            ps.setInt(1, pid);
//            ps.executeUpdate();
//            if (rs.next()) {
//                return rs.getInt("quantity");
//            }
//        } catch (Exception e) {
//        }
//        return 0;
//    }

//
//    public boolean checkDupProTypeId(int pid) {
//        xSql = "SELECT * FROM product WHERE id = ?";
//        try {
//            ps = conn.prepareStatement(xSql);
//            ps.setInt(1, pid);
//            ps.executeUpdate();
//            if (rs.next()) {
//                return true;
//            }
//        } catch (Exception e) {
//        }
//        return false;
//    }


}
