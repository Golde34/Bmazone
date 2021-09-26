/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
import entity.ProductCategory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductCategoryDAO extends BaseDAO{

  

    public ArrayList<ProductCategory> getAllProductCategory() {
        ArrayList<ProductCategory> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[ProductCategory] where status=1";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                ProductCategory pc = new ProductCategory();
                pc.setCategoryID(rs.getInt("categoryId"));
                pc.setProductID(rs.getInt("productID"));
                pc.setStatus(rs.getInt("status"));
                list.add(pc);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductCategoryDAO.class.getName()).log(Level.SEVERE, null, e);
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
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getProductID());
            pre.setInt(2, obj.getCategoryID());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductCategoryDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
}
