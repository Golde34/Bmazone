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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class CommentDAO extends BaseDAO {

    public int insertComment(Comment obj) {
        int n = 0;
        String sql = "insert into Comment(productID,userId,content,rating,status) values (?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getProductID());
            pre.setInt(2, obj.getUserID());
            pre.setString(3, obj.getContent());
            pre.setDouble(4, obj.getRating());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ArrayList<Comment> getCommentsByProductId(int pid) {
        ArrayList<Comment> comments = new ArrayList<>();
        String sql = "select * from Comment where productID  = ? order by commentID desc";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pid);
            ResultSet rs = pre.executeQuery();
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
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
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
//        }catch (SQLException ex) {
//            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }

    public boolean checkExistComment(int pid, int uid) {
        ArrayList<Comment> comments = new ArrayList<>();
        boolean check = false;
        String sql = "select * from Comment where productID  = ? and userId = ? order by commentID desc";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, pid);
            pre.setInt(2, uid);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

}
