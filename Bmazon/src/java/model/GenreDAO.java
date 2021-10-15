package model;

import entity.Genre;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreDAO extends BaseDAO{
BaseDAO dbConn= new BaseDAO();
   
    public static void main(String[] args) {
        GenreDAO dao = new GenreDAO();
        System.out.println(dao.getGenresByCategoryId(2));
    }
    public ArrayList<Genre> getAllGenres() {
        String sql = "select * from Genre WHERE status=1";
        ArrayList<Genre> list = new ArrayList<>();
        Genre x = null;
        int genreID;
        String genreName;
        int categoryID;
        int status;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Genre> getGenresByCategoryId(int categoryId){
        String sql = "select * from Genre WHERE categoryID="+categoryId;
        ArrayList<Genre> list = new ArrayList<>();
        Genre x = null;
        int genreID;
        String genreName;
        int categoryID;
        int status;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Genre> getTrueGenres() {
        String sql = "select * from Genre";
        ArrayList<Genre> list = new ArrayList<>();
        Genre x = null;
        int genreID;
        String genreName;
        int categoryID;
        int status;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public ArrayList<Genre> getHomeGenre() {
        String sql = "select top 16* from Genre";
        ArrayList<Genre> list = new ArrayList<>();
        Genre x = null;
        int genreID;
        String genreName,images;
        int categoryID;
        int status;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                images=rs.getString("images");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status, images);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertGenre(Genre gen) {
        String sql = "Insert into Genre(genreName,categoryID,status) values (?,?,?)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, gen.getGenreName());
            pre.setInt(2, gen.getCategoryID());
            pre.setString(3, gen.getImages());
            pre.setInt(4, gen.getStatus());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateGenre(Genre gen) {
        String sql = "update Genre set genreName=?, categoryID=?, status=? where genreID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, gen.getGenreName());
            pre.setInt(2, gen.getCategoryID());
            pre.setInt(3, gen.getStatus());
            pre.setInt(4, gen.getGenreID());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Genre getGenreById(int gId) {
        String sql = "select * from Genre where genreID=" + gId;
        Genre x = null;
        int genreID;
        String genreName;
        int categoryID;
        int status;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    
    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Genre set status = " + (status == 1 ? 1 : 0) + " where genreID = '" + id + "'";
        try {
            pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int removeGenre(int id) {
        int n = 0;
        String sql = "delete from Genre where genreID = '" + id + "'";
        try {
                Statement state = conn.createStatement();
                n = state.executeUpdate(sql);          
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public boolean checkExistGenreName(String genreName) {
        String sql = "SELECT * FROM Genre WHERE genreName = '" + genreName + "'";
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
