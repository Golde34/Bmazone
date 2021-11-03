package model;

import entity.Category;
import entity.Genre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public ArrayList<Genre> getAllGenres() {
        String sql = "select * from Genre WHERE status=1";
        ArrayList<Genre> list = new ArrayList<>();
        Genre x = null;
        int genreID;
        String genreName;
        int categoryID;
        int status;
        try {
            conn = new DBConnection().getConnection();
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

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public ArrayList<Genre> getGenresByCategoryId(int categoryId) {
        String sql = "select * from Genre WHERE categoryID=" + categoryId;
        ArrayList<Genre> list = new ArrayList<>();
        Genre x = null;
        int genreID;
        String genreName;
        int categoryID;
        int status;
        try {
            conn = new DBConnection().getConnection();
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

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        String images;
        int status;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                images = rs.getString("images");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status, images);
                list.add(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public ArrayList<Genre> getHomeGenre() {
        String sql = "select * from Genre limit 0,16";
        ArrayList<Genre> list = new ArrayList<>();
        Genre x = null;
        int genreID;
        String genreName, images;
        int categoryID;
        int status;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                images = rs.getString("images");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status, images);
                list.add(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public int insertGenre(Genre gen) {
        int n = 0;
        String sql = "Insert into Genre(genreName,categoryID,status) values (?,?,?)";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, gen.getGenreName());
            pre.setInt(2, gen.getCategoryID());
            pre.setInt(3, gen.getStatus());
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int updateGenre(Genre gen) {
        int n = 0;
        String sql = "update Genre set genreName=?, categoryID=?, status=? where genreID=?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, gen.getGenreName());
            pre.setInt(2, gen.getCategoryID());
            pre.setInt(3, gen.getStatus());
            pre.setInt(4, gen.getGenreID());
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int getCategoryIdByGenreId(String id) {
        int cid = -1;
        String Sql = "SELECT categoryID FROM Genre where genreID =?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(Sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                cid = rs.getInt("categoryID");
            }

        } catch (Exception e) {

        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cid;
    }

    public Genre getGenreById(int gId) {
        String sql = "select * from Genre where genreID=" + gId;
        Genre x = null;
        int genreID;
        String genreName;
        int categoryID;
        int status;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                genreID = rs.getInt("genreID");
                genreName = rs.getString("genreName");
                categoryID = rs.getInt("categoryID");
                status = rs.getInt("status");
                x = new Genre(genreID, genreName, categoryID, status);
            }

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return x;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Genre set status = ? where genreID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, id);
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int changeStatusByCateID(int cid, int status) {
        int n = 0;
        String sql = "update Genre set status = ? where categoryID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, cid);
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int removeGenre(int id) {
        int n = 0;
        String sql = "delete from Genre where genreID =?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public boolean checkExistGenreName(String genreName) {
        String sql = "SELECT * FROM Genre WHERE genreName = '" + genreName + "'";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public ArrayList<Genre> getAllPagingGenre(int index, int numOfRow, String search) {
        int start = (index - 1) * numOfRow;
        ArrayList<Genre> list = new ArrayList<>();
        String xSql = "select * from genre where genreName like '%" + search + "%' limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre(rs.getInt("genreID"), rs.getString("genreName"), rs.getInt("categoryID"), rs.getInt("status"), rs.getString("images"));
                list.add(genre);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) Genre where genreName like '%" + search + "%'";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }
}
