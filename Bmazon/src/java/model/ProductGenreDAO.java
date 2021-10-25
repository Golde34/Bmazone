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
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                String gid = rs.getString("GenreID");
                return gid;
            }
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductCategoryDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public ProductGenre getProductGenreByProduct(String pid){
        ProductGenre pg = new ProductGenre();
        String xSql ="SELECT * FROM [Bmazon].[dbo].[ProductGenre] where productID=?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                pg.setProductID(rs.getInt("productID"));
                pg.setGenreID(rs.getInt("GenreID"));
                pg.setStatus(rs.getInt("status"));
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return pg;
    }

    public ArrayList<ProductGenre> getAllProductGenre() {
        ArrayList<ProductGenre> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[ProductGenre] where status=1";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                ProductGenre pc = new ProductGenre();
                pc.setProductID(rs.getInt("productID"));
                pc.setGenreID(rs.getInt("GenreID"));
                pc.setStatus(rs.getInt("status"));
                list.add(pc);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    public int updateProductGenre(ProductGenre obj) {
        int n = 0;
        String sql = "UPDATE [Bmazon].[dbo].[ProductGenre] SET [genreID] = ? WHERE [productID] =?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getGenreID());
            pre.setInt(2, obj.getProductID());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int addProductGenre(int productID, int genreID) {
        int n = 0;
        String sql = "INSERT INTO [Bmazon].[dbo].[ProductGenre]\n"
                + "           ([productID]\n"
                + "           ,[genreID]\n"
                + "           ,[status]) VALUES(?,?,1)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, productID);
            pre.setInt(2, genreID);
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
}
