/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductGenreDAO extends BaseDAO {

    public String getGenreIdByProductId(int productId) {
        String xSql= "select * from ProductGenre where productID=" + productId;
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                String gid = rs.getString("GenreID");
                return gid;
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(ProductCategoryDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ProductGenre getProductGenreByProduct(String pid){
        ProductGenre pg = new ProductGenre();
        String xSql ="SELECT * FROM ProductGenre where productID=?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                pg.setProductID(rs.getInt("productID"));
                pg.setGenreID(rs.getInt("GenreID"));
                pg.setStatus(rs.getInt("status"));
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pg;
    }

    public ArrayList<ProductGenre> getAllProductGenre() {
        ArrayList<ProductGenre> list = new ArrayList<>();
        String sql = "SELECT * FROM ProductGenre where status=1";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                ProductGenre pc = new ProductGenre();
                pc.setProductID(rs.getInt("productID"));
                pc.setGenreID(rs.getInt("GenreID"));
                pc.setStatus(rs.getInt("status"));
                list.add(pc);
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public int updateProductGenre(ProductGenre obj) {
        int n = 0;
        String sql = "UPDATE ProductGenre SET genreID = ? WHERE productID =?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getGenreID());
            pre.setInt(2, obj.getProductID());
            n = pre.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int addProductGenre(int productID, int genreID) {
        int n = 0;
        String sql = "INSERT INTO ProductGenre\n"
                + "           (productID\n"
                + "           ,genreID\n"
                + "           ,status) VALUES(?,?,1)";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, productID);
            pre.setInt(2, genreID);
            n = pre.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }
}
