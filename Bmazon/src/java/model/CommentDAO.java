/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Comment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class CommentDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public int insertComment(Comment obj) {
        int n = 0;
        String sql = "insert into `Comment`(productID,userId,content,rating,status) values (?,?,?,?,1)";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getProductID());
            pre.setInt(2, obj.getUserID());
            pre.setString(3, obj.getContent());
            pre.setDouble(4, obj.getRating());
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }
    
    public int updateComment(Comment newCom) {
        int n = 0;
        String sql = "update Comment set content = ? ,rating = ? where productID = ? and userId = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, newCom.getContent());
            pre.setDouble(2, newCom.getRating());
            pre.setInt(3, newCom.getProductID());
            pre.setInt(4, newCom.getUserID());
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update `Comment` set status = ? where `commentID` = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status == 1 ? 1 : 0);
            pre.setInt(2, id);
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int getNumberOfComment(int pID) {
        int num = 0;
        String xSql = "SELECT COUNT(*) FROM `Comment` where productID = " + pID;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }

    public int getPageNumber(String search, int pid) {
        int num = 0;
        String xSql = "SELECT COUNT(*) FROM `Comment` where productID = " + pid + " and content like '%" + search + "%'";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }

    public List<Comment> getAllPagingComment(int index, int numOfRow, String search) {
        List<Comment> list = new ArrayList<>();
        String xSql = "declare @PageNo INT = ? \n"
                + "declare @PageSize INT= ? \n"
                + "SELECT * from(\n"
                + "SELECT *,\n"
                + "ROW_NUMBER() over (order by commentID) as RowNum\n"
                + "  FROM `Comment` where wareHouseAddress like '%" + search + "%')T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, index);
            pre.setInt(2, numOfRow);
//            pre.setString(3, search);
//            pre.setString(4, search);
//            pre.setString(5, search);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Comment(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6)));
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public Comment getCommentByUserIdAndProductId(int uid, int pid) {
        Comment x = new Comment();
        String sql = "select * from `Comment` where productID  = ? and userId = ? order by commentID desc";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                x.setCommentID(rs.getInt("commentID"));
                x.setProductID(rs.getInt("productID"));
                x.setUserID(rs.getInt("userId"));
                x.setContent(rs.getString("content"));
                x.setRating(rs.getInt("rating"));
                x.setStatus(rs.getInt("status"));
            }
        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return x;
    }
    
    public ArrayList<Comment> getCommentsByProductId(int pid) {
        ArrayList<Comment> comments = new ArrayList<>();
        String sql = "select * from `Comment` where productID  = ? order by commentID desc";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                Comment x = new Comment();
                x.setCommentID(rs.getInt("commentID"));
                x.setProductID(rs.getInt("productID"));
                x.setUserID(rs.getInt("userId"));
                x.setContent(rs.getString("content"));
                x.setRating(rs.getInt("rating"));
                x.setStatus(rs.getInt("status"));
                comments.add(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comments;
    }

    public ArrayList<Comment> getCommensByProductIdAndRating(int pid, int rating) {
        ArrayList<Comment> comments = new ArrayList<>();
        String sql = "select * from `Comment` where productID  = ? and rating = ? order by commentID desc";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pid);
            pre.setInt(2, rating);
            rs = pre.executeQuery();
            while (rs.next()) {
                Comment x = new Comment();
                x.setCommentID(rs.getInt("commentID"));
                x.setProductID(rs.getInt("productID"));
                x.setUserID(rs.getInt("userId"));
                x.setContent(rs.getString("content"));
                x.setRating(rs.getInt("rating"));
                x.setStatus(rs.getInt("status"));
                comments.add(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comments;
    }

    public ArrayList<Comment> getCommentsBySeller(int pid) {
        ArrayList<Comment> comments = new ArrayList<>();
        String sql = "select * from comment as c join product as p on c.productid= p.productid where sellerid=?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                Comment x = new Comment();
                x.setCommentID(rs.getInt("commentID"));
                x.setProductID(rs.getInt("productID"));
                x.setUserID(rs.getInt("userId"));
                x.setContent(rs.getString("content"));
                x.setRating(rs.getInt("rating"));
                x.setStatus(rs.getInt("status"));
                comments.add(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comments;
    }

    public static void main(String[] args) {
        CommentDAO c = new CommentDAO();
        System.out.println(c.getNumberOfCommentPaging("", 5));

    }

    public int getNumberOfCommentPaging(String search, int pID) {
        int num = 0;

        String xSql = "select count(*) from `comment` as c join product as p on c.productid= p.productid where sellerid=" + pID + " and `content` like '%" + search + "%' ";

        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }

    public ArrayList<Comment> getCommentsBySellerPaging(int index, int numOfRow, String search, int seller) {
        ArrayList<Comment> comments = new ArrayList<>();
        int start = (index - 1) * numOfRow;
        String sql = "select * from comment as c join product as p on c.productid= p.productid where sellerid=? and `content` like '%" + search + "%' limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, seller);
            pre.setInt(2, start);
            pre.setInt(3, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                Comment x = new Comment();
                x.setCommentID(rs.getInt("commentID"));
                x.setProductID(rs.getInt("productID"));
                x.setUserID(rs.getInt("userId"));
                x.setContent(rs.getString("content"));
                x.setRating(rs.getInt("rating"));
                x.setStatus(rs.getInt("status"));
                comments.add(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comments;
    }

    public ArrayList<Comment> getCommentsByUserId(int uid) {
        ArrayList<Comment> comments = new ArrayList<>();
        String sql = "select * from `Comment` where userId  = ? order by commentID desc LIMIT 4";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, uid);
            rs = pre.executeQuery();
            while (rs.next()) {
                Comment x = new Comment();
                x.setCommentID(rs.getInt("commentID"));
                x.setProductID(rs.getInt("productID"));
                x.setUserID(rs.getInt("userId"));
                x.setContent(rs.getString("content"));
                x.setRating(rs.getInt("rating"));
                x.setStatus(rs.getInt("status"));
                comments.add(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comments;
    }

    public ArrayList<Comment> getAllCommentsByUserId(int uid) {
        ArrayList<Comment> comments = new ArrayList<>();
        String sql = "select * from `Comment` where userId  = ? order by commentID desc";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, uid);
            rs = pre.executeQuery();
            while (rs.next()) {
                Comment x = new Comment();
                x.setCommentID(rs.getInt("commentID"));
                x.setProductID(rs.getInt("productID"));
                x.setUserID(rs.getInt("userId"));
                x.setContent(rs.getString("content"));
                x.setRating(rs.getInt("rating"));
                x.setStatus(rs.getInt("status"));
                comments.add(x);
            }

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comments;
    }

//    public int countAllCommentsByProductId(int pid){
//        int n = 1;
//        String sql = "select count(*) from Comment where productID = ?";
//        try{
//            pre = conn.prepareStatement(sql);
//            pre.setInt(1, pid);
//            ResultSet rs = pre.executeQuery();
//        }catch (Exception ex) {
//            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }
    public boolean checkExistComment(int pID, int uId) {
        boolean check = false;
        String sql = "select * from `Comment` where productID = ? and userId = ? order by commentID desc";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pID);
            pre.setInt(2, uId);
            rs = pre.executeQuery();
            while (rs.next()) {
                check = true;
            }

        } catch (Exception ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

}
