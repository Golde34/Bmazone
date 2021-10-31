package model;

import entity.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public static void main(String[] args) {
       CategoryDAO cd= new CategoryDAO();
        System.out.println(cd.getAllCategories());
    }
    public ArrayList<Category> getAllCategories() {
        String sql = "select * from Category WHERE status=1";
        ArrayList<Category> list = new ArrayList<>();
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
                Category x = new Category(categoryID, categoryName, status);
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
                Category x = new Category(categoryID, categoryName, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int insertCategory(Category cate) {
        int n = 0;
        String sql = "Insert into Category(categoryName,status) values (?,?)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, cate.getCategoryName());
            pre.setInt(2, cate.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCategory(Category cate) {
        int n = 0;
        String sql = "update Category set categoryName=?, status=? where categoryID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, cate.getCategoryName());
            pre.setInt(2, cate.getStatus());
            pre.setInt(3, cate.getCategoryID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Category getCategoryByCateId(String id) {
        String xSql = "select * from Category where categoryID= ?";
        Category cat = new Category();
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                cat.setCategoryID(rs.getInt("categoryID"));
                cat.setCategoryName(rs.getString("categoryName"));
                cat.setStatus(rs.getInt("status"));
                return cat;
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
        public Category getCategoryByGenreId(int id) {
        String xSql = "select * from Category c join Genre g on c.categoryID = g.categoryID where genreID =" + id;
        Category cat = new Category();
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                cat.setCategoryID(rs.getInt("categoryID"));
                cat.setCategoryName(rs.getString("categoryName"));
                cat.setStatus(rs.getInt("status"));
            }
        } catch (SQLException ex) {
        }
        return cat;
    }

    public String getCategoryById(int fcaId) {
        String sql = "select categoryName from Category where categoryID=" + fcaId;

        String categoryName = null;

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
        String sql = "update Category set status = ? where categoryID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int removeCategory(int id) {
        int n = 0;
        String sql = "delete from Category where categoryID = ?";

        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();
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
    
    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) FROM Category where categoryName like '%" + search + "%'";
        ResultSet rs = dbConn.getData(xSql);
        try {
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    
    public ArrayList<Category> getAllPagingCategory(int index, int numOfRow, String search) {
        int start=(index-1)*numOfRow;
        ArrayList<Category> list = new ArrayList<>();
        String xSql = "SELECT * FROM category where categoryName like '%"+search+"%' LIMIT ?,?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("categoryID"), rs.getString("categoryName"), rs.getInt("status"));
                list.add(category);
            }
            rs.close();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
