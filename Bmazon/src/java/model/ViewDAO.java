/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Comment;
import entity.View;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bacon
 */
public class ViewDAO extends BaseDAO{
      BaseDAO dbConn = new BaseDAO();
      public static void main(String[] args) {
        ViewDAO v= new ViewDAO();
          System.out.println(v.getView(10, 5)) ;
    }

    public int insertClick(View obj) {
        int n = 0;
        String sql = "INSERT INTO productview(userId, productId, click)values(?,?,?)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getUserId());
            pre.setInt(2, obj.getProductId());
            pre.setInt(3, obj.getClick());        
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int changeClick(View obj) {
        int n = 0;
        String sql = "update productview set click = ? where userid = ? and productId=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(2, obj.getUserId());
            pre.setInt(3, obj.getProductId());
            pre.setInt(1, obj.getClick()+1); 
           
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public View getView(int pID,int userid) {      
        String xSql = "SELECT * FROM productview where productId = " + pID +" and userid = "+userid;
        ResultSet rs = dbConn.getData(xSql);
        View o =null;
        try {
            if (rs.next()) {  
                o=new View(
                rs.getInt("userId"),
                rs.getInt("productId"),
                rs.getInt("click"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

}
