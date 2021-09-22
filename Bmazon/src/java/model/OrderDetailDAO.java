/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.OrderDetail;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class OrderDetailDAO extends BaseDAO{

    

    public int insertOrderDetail(OrderDetail obj) {
        int n = 0;
        String sql = "Insert into OrderDetail(orderID, productTypeID,.productName, price,quantity, status)"
                + " values (?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getOrderID());
            pre.setString(2, obj.getProductTypeId());
            pre.setString(3, obj.getProductName());
            pre.setDouble(4, obj.getPrice());
            pre.setInt(5, obj.getQuantity());
            pre.setInt(6, obj.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int removeOrderDetail(String orderId, String productTypeID) {
        int n = 0;
        String sqlDelete = "delete from OrderDetail where orderID = '" + orderId + "' and productTypeID = '" + productTypeID + "'";
        Statement stm;
        try {
            stm = conn.createStatement();
            n = stm.executeUpdate(sqlDelete);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateOrderDetailQuantity(OrderDetail obj) {
        int n = 0;
        String sql = "update OrderDetail set quantity=? where orderID=? and productTypeID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getQuantity());
            pre.setInt(2, obj.getOrderID());
            pre.setString(3, obj.getProductTypeId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return n;
    }
}
