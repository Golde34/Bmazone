/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product ";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getTrueProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product  where status=1 order by releaseDate";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductSale() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 8 * FROM Product";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductNew() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 8 * FROM Product order by releaseDate";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductApple() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 8 * FROM Product where description like '%apple%'";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductGear() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT price * FROM Product where description like '%apple%'";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProducSuggest() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 16 * FROM Product order by releaseDate";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductByName(String name) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] where productName like '%" + name + "%' OR description like '%" + name + "%'";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public Product getProductByID(int id) {
        Product pro = new Product();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] where productID=" + id;

        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> getProductByCategory(int categoryID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] as a join ProductCategory as b on a.productID=b.productID\n"
                + "WHERE a.status=1 and b.categoryId=" + categoryID;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductByGenre(int genreID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] as a join ProductGenre as b on a.productID=b.productID WHERE a.status=1 and b.genreID=" + genreID;

        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getRelatedProductByProductID(int id) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product a join ProductCategory b on a.productID=b.productID where b.categoryId=(SELECT categoryId FROM ProductCategory WHERE productID=" + id + ")";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public int addProduct(Product obj) {
        int n = 0;
        String sql = "INSERT INTO [Bmazon].[dbo].[Product]([productName],[description],[rating],[releaseDate],[seller],[status])"
                + "VALUES(?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getProductName());
            pre.setString(2, obj.getDescription());
            pre.setInt(3, obj.getRating());
            pre.setDate(4, obj.getReleaseDate());
            pre.setInt(5, obj.getSeller());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
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
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getProductName());
            pre.setString(2, obj.getDescription());
            pre.setInt(3, obj.getRating());
            pre.setDate(4, obj.getReleaseDate());
            pre.setInt(5, obj.getSeller());
            pre.setInt(6, obj.getStatus());
            pre.setInt(7, obj.getProductID());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Product set status = " + (status == 1 ? 1 : 0) + " where gId = '" + id + "'";
        try {
            pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteProduct(int id) {
        int n = 0;
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product]\n"
                + "AS a join ProductCategory as b on a.productID=b.productID"
                + " join ProductGenre as c on a.productID=c.productID"
                + " join Gallery as d on a.productID=d.productID ";
        rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                changeStatus(rs.getInt("productID"), 0);
            } else {
                String sqlDelete = "DELETE FROM [Bmazon].[dbo].[Product] WHERE productID='" + id + "'";
                Statement state = conn.createStatement();
                n = state.executeUpdate(sqlDelete);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }


  


    
    public ArrayList<Product> getProductSuggest() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 16 * FROM Product order by releaseDate";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;

    }
}
