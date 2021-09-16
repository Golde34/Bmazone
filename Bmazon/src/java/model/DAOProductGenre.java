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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOProductGenre {

    DBConnection dbConn;
    Connection conn;

    public DAOProductGenre(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }

    public ArrayList<ProductGenre> getAllProductGenre() {
        ArrayList<ProductGenre> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[ProductGenre] where status=1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductGenre pc = new ProductGenre();
                pc.setProductID(rs.getInt("productID"));
                pc.setGenreID(rs.getInt("GenreID"));
                pc.setStatus(rs.getInt("status"));
                list.add(pc);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProductGenre.class.getName()).log(Level.SEVERE, null, e);
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
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getProductID());
            ps.setInt(2, obj.getGenreID());
            n = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(DAOProductGenre.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
}
