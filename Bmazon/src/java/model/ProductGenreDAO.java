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
public class ProductGenreDAO extends BaseDAO{

   

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

    public int addProductGenre(ProductGenre obj) {
        int n = 0;
        String sql = "INSERT INTO [Bmazon].[dbo].[ProductGenre]\n"
                + "           ([productID]\n"
                + "           ,[genreID]\n"
                + "           ,[status]) VALUES(?,?,1)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getProductID());
            pre.setInt(2, obj.getGenreID());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductGenreDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
}
