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
    
    public int getPageNumber(String search, int pid) {
        int num = 0;
        String xSql= "SELECT COUNT(*) FROM [Bmazon].[dbo].[Comment] where productID = "+ pid +" and content like '%" + search + "%'";
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
    
    public List<Comment> getAllPagingComment(int index, int numOfRow, String search) {
        List<Comment> list = new ArrayList<>();
        String xSql= "declare @PageNo INT = ? \n"
                + "declare @PageSize INT= ? \n"
                + "SELECT * from(\n"
                + "SELECT *,\n"
                + "ROW_NUMBER() over (order by commentID) as RowNum\n"
                + "  FROM [Bmazon].[dbo].[Comment] where wareHouseAddress like '%" + search + "%')T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update [Comment] set status = ? where [commentID] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status == 1 ? 1 : 0);
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
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
            rs= pre.executeQuery();
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

    public boolean checkExistComment(int cid) {
        
        boolean check = false;
        String sql = "select * from Comment where commentID = ? order by commentID desc";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, cid);
            rs = pre.executeQuery();
            while (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

}
