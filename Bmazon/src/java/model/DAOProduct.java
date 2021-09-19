/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOProduct {

    DBConnection dbConn;
    Connection conn;

    public DAOProduct(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 10 * FROM Product where status=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("seller"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getTrueProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 10 * FROM Product";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("seller"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductBySeller(int seller) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] where seller=" + seller;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("seller"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductByName(String name) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] where productName like '%" + name + "%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("seller"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public Product getProductByID(int id) {
        Product pro = null;
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] where productID=" + id;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("seller"));
                pro.setStatus(rs.getInt("status"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> getProductByCategory(int categoryID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] as a join ProductCategory as b on a.productID=b.productID\n"
                + "WHERE a.status=1 and b.categoryId=" + categoryID;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("seller"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductByGenre(int genreID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] as a join ProductGenre as b on a.productID=b.productID"
                + "WHERE a.status=1 and b.genreID=" + genreID;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("seller"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public int addProduct(Product obj) {
        int n = 0;
        String sql = "INSERT INTO [Bmazon].[dbo].[Product]([productName],[description],[rating],[releaseDate],[seller],[status])"
                + "VALUES(?,?,?,?,?,1)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getProductName());
            ps.setString(2, obj.getDescription());
            ps.setInt(3, obj.getRating());
            ps.setDate(4, obj.getReleaseDate());
            ps.setInt(5, obj.getSeller());
            n = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int updateProduct(Product obj) {
        int n = 0;
        String sql = "UPDATE [Bmazon].[dbo].[Product]\n"
                + "   SET [productName] = ?"
                + "      ,[description] = ?"
                + "      ,[rating] = ?"
                + "      ,[releaseDate] = ?"
                + "      ,[seller] = ?"
                + "      ,[status] = ?"
                + " WHERE productID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getProductName());
            ps.setString(2, obj.getDescription());
            ps.setInt(3, obj.getRating());
            ps.setDate(4, obj.getReleaseDate());
            ps.setInt(5, obj.getSeller());
            ps.setInt(6, obj.getStatus());
            ps.setInt(7, obj.getProductID());
            n = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Product set status = " + (status == 1 ? 1 : 0) + " where gId = '" + id + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteProduct(int id) {
        int n = 0;
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product]\n"
                + "AS a join ProductCategory as b on a.productID=b.productID"
                + " join ProductGenre as c on a.productID=c.productID"
                + " join Gallery as d on a.productID=d.productID ";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                changeStatus(rs.getInt("productID"), 0);
            } else {
                String sqlDelete = "DELETE FROM [Bmazon].[dbo].[Product] WHERE productID='" + id + "'";
                Statement state = conn.createStatement();
                n = state.executeUpdate(sqlDelete);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
