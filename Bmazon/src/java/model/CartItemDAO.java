/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.CartItem;
import entity.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bacon
 */
public class CartItemDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public int addProduct(CartItem obj, int userid) {
        int n = 0;
        String sql = "INSERT INTO cart(cartID,productID,name,size,color,image,price,quantity,totalCost,userid)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?);";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getCartID());
            pre.setInt(2, obj.getProductID());
            pre.setString(3, obj.getName());
            pre.setString(4, obj.getSize());
            pre.setString(5, obj.getColor());
            pre.setString(6, obj.getImage());
            pre.setDouble(7, obj.getPrice());
            pre.setInt(8, obj.getQuantity());
            pre.setDouble(9, obj.getTotalCost());
            pre.setInt(10, userid);

            n = pre.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
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
     public ArrayList<CartItem> getCartByID(int userid) {
        String sql = "select * from cart WHERE userid="+userid;
        ArrayList<CartItem> list = new ArrayList<>();
        
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
               list.add(new CartItem(rs.getInt(1),
                       rs.getInt(2),
                       rs.getString(3), 
                       rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                       rs.getDouble(7),
                       rs.getInt(8),
                       rs.getDouble(9)));
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
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
     
       public int UpdateProduct(CartItem obj, int userid) {
        int n = 0;
        String sql = "Update cart set cartID= ?,productID = ? ,name = ? ,size = ? ,color = ? ,image = ? ,price = ?,quantity= ? ,totalCost= ? where userid=?\n";
               ;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getCartID());
            pre.setInt(2, obj.getProductID());
            pre.setString(3, obj.getName());
            pre.setString(4, obj.getSize());
            pre.setString(5, obj.getColor());
            pre.setString(6, obj.getImage());
            pre.setDouble(7, obj.getPrice());
            pre.setInt(8, obj.getQuantity());
            pre.setDouble(9, obj.getTotalCost());
            pre.setInt(10, userid);

            n = pre.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
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
        public int removeCart(int id, int cartid) {
        int n = 0;
        String sql = "delete from cart where userid = ? and cartID = ?";

        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
             pre.setInt(2, cartid);
            n = pre.executeUpdate();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

}
