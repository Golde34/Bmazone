/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Order;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duong
 */
public class OrderDAO extends BaseDAO{

   BaseDAO dbConn= new BaseDAO();

    public int insertOrder(Order obj) {
        int n = 0;
        String sql = "INSERT INTO [Order]" +
"           ([userID],[orderDate],[requiredDate],[shippedDate],[shipName],[shipAddress],[shipCity]\n" +
"           ,[shipPhone],[companyID],[shipMoney],[paymentMethod],[total],[status])"+
"     VALUES (?,GETDATE(),?,?,?,?,?,?,?,?,?,?,?,1)" ;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getUserID());
            pre.setDate(2, obj.getOrderDate());
            pre.setDate(3, obj.getRequiredDate());
            pre.setDate(4, obj.getShippedDate());
            pre.setString(5, obj.getShipName());
            pre.setString(6, obj.getShipAddress());
            pre.setString(7, obj.getShipCity());
            pre.setString(8, obj.getShipPhone());
            pre.setInt(9, obj.getCompanyID());
            pre.setDouble(10, obj.getShipMoney());
            pre.setString(11, obj.getPaymentMethod());
            pre.setDouble(12, obj.getTotal());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int changeStatus(String orderId) {
        int n = 0;
        String sql = "UPDATE [Order] SET status = 1 WHERE orderID = '?'";
        Statement state;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, orderId);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateOrder(Order obj) {
        int n = 0;
        String sql = "update [Order] set[orderDate]=? [requiredDate]=?[shippedDate]=?[shipName]=?[shipAddress]=?[shipCity]=?" +
"           [shipPhone]=?[companyID]=?[shipMoney]=?[paymentMethod]=? [total]=? [status]=1 where orderID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setDate(1, obj.getOrderDate());
            pre.setDate(2, obj.getRequiredDate());
            pre.setDate(3, obj.getShippedDate());
            pre.setString(4, obj.getShipName());
            pre.setString(5, obj.getShipAddress());
            pre.setString(6, obj.getShipCity());
            pre.setString(7, obj.getShipPhone());
            pre.setInt(8, obj.getCompanyID());
            pre.setDouble(9, obj.getShipMoney());
            pre.setString(10, obj.getPaymentMethod());
            pre.setDouble(11, obj.getTotal());
             pre.setInt(12, obj.getOrderID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int removeOrder(String orderId) {
        int n = 0;
        String sql = "Select * from [Order] as a join OrderDetail as b on a.orderID = b.orderID where a.orderID = '" + orderId + "'";
        rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                String s = rs.getString("orderID");
                return s == null ? 0 : Integer.parseInt(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "select * from [Order] where status = 1  order by orderID desc";
        rs = dbConn.getData(sql);
        try {
            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(rs.getInt("orderID"));
                o.setUserID(rs.getString("userID"));
                o.setOrderDate(rs.getDate("orderDate"));
                o.setRequiredDate(rs.getDate("requiredDate"));
                o.setShippedDate(rs.getDate("shippedDate"));
                o.setShipName(rs.getString("shipname"));
                o.setShipAddress(rs.getString("shipaddress"));
                o.setShipCity(rs.getString("shipcity"));
                o.setShipPhone(rs.getString("shipphone"));
                o.setCompanyID(rs.getInt("companyID"));
                o.setShipMoney(rs.getDouble("shipmoney"));
                o.setPaymentMethod(rs.getString("paymentmethod"));
                o.setTotal(rs.getDouble("total"));
                o.setStatus(rs.getInt("status"));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//    public List<Order> getOrderBySeller(int userID) {
//        List<Order> list = new ArrayList<>();
//        xSql = "select * from Product where seller = ? and status = 1";
//        try {
//            pre = conn.prepareStatement(xSql);
//            pre.setInt(1, userID);
//            rs = pre.executeQuery();
//            while (rs.next()) {
//                list.add(new Order(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getDate(5),
//                        rs.getInt(6),
//                        rs.getInt(7)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
}
