package model;

import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCategory {

    DBConnection dbConn;
    Connection conn;

    public DAOCategory(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }

    public ArrayList<Category> getAllCategories() {
        String sql = "select * from Category WHERE status=1";
        ArrayList<Category> list = new ArrayList<>();
        Category x = null;
        int categoryID;
        String categoryName;
        int status;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoryID = rs.getInt("categoryID");
                categoryName = rs.getString("categoryName");
                status = rs.getInt("status");
                x = new Category(categoryID, categoryName, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Category> getTrueCategories() {
        String sql = "select * from Category";
        ArrayList<Category> list = new ArrayList<>();
        Category x = null;
        int categoryID;
        String categoryName;
        int status;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoryID = rs.getInt("categoryID");
                categoryName = rs.getString("categoryName");
                status = rs.getInt("status");
                x = new Category(categoryID, categoryName, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertCategory(Category cate) {
        String sql = "Insert into Category(categoryName,status) values (?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cate.getCategoryName());
            ps.setInt(2, cate.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCategory(Category cate) {
        String sql = "update Category set categoryName=?, status=? where categoryID=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cate.getCategoryName());
            ps.setInt(2, cate.getStatus());
            ps.setInt(3, cate.getCategoryID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Category getCategoryById(int fcaId) {
        String sql = "select * from Category where categoryID=" + fcaId;
        Category x = null;
        int categoryID;
        String categoryName;
        int status;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoryID = rs.getInt("caId");
                categoryName = rs.getString("caName");
                status = rs.getInt("status");
                x = new Category(categoryID, categoryName, status);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    
    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Category set status = " + (status == 1 ? 1 : 0) + " where categoryID = '" + id + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int removeCategory(int id) {
        int n = 0;
        String sql = "delete from Category where categoryID = '" + id + "'";
        try {
                Statement state = conn.createStatement();
                n = state.executeUpdate(sql);          
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public boolean checkExistCategoryName(String categoryName) {
        String sql = "SELECT * FROM Category WHERE categoryName = '" + categoryName + "'";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
