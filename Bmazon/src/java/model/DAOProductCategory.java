/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ProductCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOProductCategory {

    DBConnection dbConn;
    Connection conn;

    public DAOProductCategory(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }

    public ArrayList<ProductCategory> getAllProductCategory() {
        ArrayList<ProductCategory> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[ProductCategory] where status=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductCategory pc = new ProductCategory();
                pc.setCategoryID(rs.getInt("categoryId"));
                pc.setProductID(rs.getInt("productID"));
                pc.setStatus(rs.getInt("status"));
                list.add(pc);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProductCategory.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public int addProductCategory(ProductCategory obj) {
        int n = 0;
        String sql = "INSERT INTO [Bmazon].[dbo].[ProductCategory]\n"
                + "           ([productID]\n"
                + "           ,[categoryId]\n"
                + "           ,[status]) VALUES(?,?,1)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getProductID());
            ps.setInt(2, obj.getCategoryID());
            n = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProductCategory.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
    
}
