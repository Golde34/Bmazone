/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.OrderDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class OrderDetailDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public static void main(String[] args) {
        OrderDetailDAO dao = new OrderDetailDAO();
        System.out.println(dao.sumSoldProductTypeByPtypeID("Pr25Ty1"));
    }

    public int insertOrderDetail(OrderDetail obj) {
        int n = 0;
        String sql = "Insert into OrderDetail(orderID, productTypeID, productName, price, quantity, status)"
                + " values (?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getOrderID());
            pre.setString(2, obj.getProductTypeId());
            pre.setString(3, obj.getProductName());
            pre.setDouble(4, obj.getPrice());
            pre.setInt(5, obj.getQuantity());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

//    public int removeOrderDetail(String orderId, String productTypeID) {
//        int n = 0;
//        String sql = "delete from OrderDetail where orderID = '?' and productTypeID = '?'";
//        try {
//            pre = conn.prepareStatement(sql);           
//            pre.setString(1, orderId);
//            pre.setString(2, productTypeID);
//            n = pre.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }
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

    public ArrayList<OrderDetail> getAllOrderDetail(int oid) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        String sql = "select * from `OrderDetail` where orderID = " + oid + " and status = 1  order by orderID desc";
        ResultSet rs = dbConn.getData(sql);
        try {
            while (rs.next()) {
                OrderDetail o = new OrderDetail();
                o.setOrderID(rs.getInt("orderID"));
                o.setProductTypeId(rs.getString("productTypeID"));
                o.setProductName(rs.getString("productName"));
                o.setPrice(rs.getDouble("price"));
                o.setQuantity(rs.getInt("quantity"));
                o.setStatus(rs.getInt("status"));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int sumSoldProductTypeByPtypeID(String ptID) {
        int result = 0;
        String sql = "SELECT sum(quantity) FROM `OrderDetail` where productTypeID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, ptID);
            rs = pre.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<OrderDetail> getOrderDetailByOrderId(int orderId) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        String xSql = "select * from `orderdetail` where orderID=?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, orderId);
            rs = pre.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail();
                od.setOrderID(rs.getInt("orderID"));
                od.setPrice(rs.getDouble("price"));
                od.setProductName(rs.getString("productName"));
                od.setProductTypeId(rs.getString("productTypeID"));
                od.setQuantity(rs.getInt("quantity"));
                od.setStatus(rs.getInt("status"));
                list.add(od);
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int sumSoldProductByProductID(String pid) {
        int result = 0;
        String sql = "select sum(od.quantity), p.productID from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID\n"
                + "where p.productID=?\n"
                + "group by p.productID";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, pid);
            rs = pre.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
