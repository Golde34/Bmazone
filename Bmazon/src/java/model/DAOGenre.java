package model;

import entity.Genre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOGenre {

    DBConnection dbConn;
    Connection conn;

    public DAOGenre(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
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
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status);
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insertGenre(Genre gen) {
        String sql = "Insert into Genre(genreName,categoryID,status) values (?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, gen.getGenreName());
            ps.setInt(2, gen.getCategoryID());
            ps.setInt(3, gen.getStatus());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateGenre(Genre gen) {
        String sql = "update Genre set genreName=?, categoryID=?, status=? where genreID=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, gen.getGenreName());
            ps.setInt(2, gen.getCategoryID());
            ps.setInt(3, gen.getStatus());
            ps.setInt(4, gen.getGenreID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
    
    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Genre set status = " + (status == 1 ? 1 : 0) + " where genreID = '" + id + "'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public boolean checkExistGenreName(String genreName) {
        String sql = "SELECT * FROM Genre WHERE genreName = '" + genreName + "'";
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
