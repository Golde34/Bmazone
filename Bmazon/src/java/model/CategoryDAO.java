package model;

import entity.Category;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAO extends BaseDAO{
   BaseDAO dbConn= new BaseDAO();
   

    public ArrayList<Category> getAllCategories() {
        String sql = "select * from Category WHERE status=1";
        ArrayList<Category> list = new ArrayList<>();
        Category x = null;
        int categoryID;
        String categoryName;
        int status;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                categoryID = rs.getInt("categoryID");
                categoryName = rs.getString("categoryName");
                status = rs.getInt("status");
                x = new Category(categoryID, categoryName, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                categoryID = rs.getInt("categoryID");
                categoryName = rs.getString("categoryName");
                status = rs.getInt("status");
                x = new Category(categoryID, categoryName, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertCategory(Category cate) {
        String sql = "Insert into Category(categoryName,status) values (?,?)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, cate.getCategoryName());
            pre.setInt(2, cate.getStatus());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCategory(Category cate) {
        String sql = "update Category set categoryName=?, status=? where categoryID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, cate.getCategoryName());
            pre.setInt(2, cate.getStatus());
            pre.setInt(3, cate.getCategoryID());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCategoryById(int fcaId) {
        String sql = "select categoryName from Category where categoryID=" + fcaId;
       
     
        String categoryName=null;
     
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                
                categoryName = rs.getString("categoryName");
                           
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoryName;
    }
    
    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Category set status = " + (status == 1 ? 1 : 0) + " where categoryID = '" + id + "'";
        try {
            pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public boolean checkExistCategoryName(String categoryName) {
        String sql = "SELECT * FROM Category WHERE categoryName = '" + categoryName + "'";
        rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
