/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Order;
import java.sql.ResultSet;
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
public class OrderDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public int getPageNumber(String search) {
        int num = 0;
        String Sql = "SELECT COUNT(*) FROM [Bmazon].[dbo].[Order]";
        ResultSet rs = dbConn.getData(Sql);
        try {
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }

    public List<Order> getAllPagingOrder(int index, int numOfRow, String search) {
        List<Order> list = new ArrayList<>();
        String sql = "declare @PageNo INT = ? \n"
                + "declare @PageSize INT= ? \n"
                + "SELECT * from(\n"
                + "SELECT *,\n"
                + "ROW_NUMBER() over (order by orderID) as RowNum\n"
                + "  FROM [Bmazon].[dbo].[Order])T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.setInt(2, numOfRow);
//            pre.setString(3, search);
//            pre.setString(4, search);
//            pre.setString(5, search);
            rs = pre.executeQuery();
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
                o.setState(rs.getInt("state"));
                o.setStatus(rs.getInt("status"));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        Order o= new Order("1", "thinh", "thinh", "thinh","thinh", 0, 10000, 1,"COD", 0);
        OrderDAO odao= new OrderDAO();
        odao.insertOrder(o);
    }

    public int insertOrder(Order obj) {
        int n = 0;
        String sql = "INSERT INTO [Order]"
                + "           ([userID],[orderDate],[requiredDate],[shippedDate],[shipName],[shipAddress],[shipCity]\n"
                + "           ,[shipPhone],[companyID],[shipMoney],[paymentMethod],[total],[state],[status])"
                + "     VALUES (?,GETDATE(),GETDATE(),GETDATE(),?,?,?,?,?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getUserID());
            pre.setString(2, obj.getShipName());
            pre.setString(3, obj.getShipAddress());
            pre.setString(4, obj.getShipCity());
            pre.setString(5, obj.getShipPhone());
            pre.setInt(6, obj.getCompanyID());
            pre.setDouble(7, obj.getShipMoney());
            pre.setString(8, obj.getPaymentMethod());
            pre.setDouble(9, obj.getTotal());
            pre.setInt(10, obj.getState());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int changeStatus(int orderId, int status) {
        int n = 0;
        String sql = "UPDATE [Order] SET status = ? WHERE orderID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, orderId);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateOrder(Order obj) {
        int n = 0;
        String sql = "update [Order] set[orderDate]=? ,[requiredDate]=?,[shippedDate]=?,[shipName]=?,[shipAddress]=?,[shipCity]=?,"
                + "           [shipPhone]=?,[companyID]=?,[shipMoney]=?,[paymentMethod]=? ,[total]=? ,[state]=?,[status]=1 where orderID=?";
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
            pre.setInt(12, obj.getState());
            pre.setInt(13, obj.getOrderID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

//    public int removeOrder(String orderId) {
//        int n = 0;
//        String sql = "Select * from [Order] as a join OrderDetail as b on a.orderID = b.orderID where a.orderID = '" + orderId + "'";
//        rs = dbConn.getData(sql);
//        try {
//            if (rs.next()) {
//                String s = rs.getString("orderID");
//                return s == null ? 0 : Integer.parseInt(s);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }
    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "select * from [Order] where status = 1  order by orderID desc";
        ResultSet rs = dbConn.getData(sql);
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
                o.setState(rs.getInt("state"));
                o.setStatus(rs.getInt("status"));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Order> getOrderByUser(int userID) {
        List<Order> list = new ArrayList<>();
        String sql = "select * from [Order] where userID = " + userID + "and status = 1";
        ResultSet rs = dbConn.getData(sql);
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
                o.setState(rs.getInt("state"));
                o.setStatus(rs.getInt("status"));
                list.add(o);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public Order getLatestOrder(String userID) {
        String sql = "SELECT TOP 1 * FROM [Order] WHERE userID = '" + userID + "' ORDER BY OrderID desc";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                Order order = new Order(rs.getInt("orderID"), rs.getString("userID"),
                        rs.getDate("orderDate"), rs.getDate("requiredDate"),
                        rs.getDate("shippedDate"), rs.getString("shipName"),
                        rs.getString("shipAddress"), rs.getString("shipCity"),
                        rs.getString("shipPhone"),  rs.getDouble("shipMoney"), 
                        rs.getDouble("total"), rs.getInt("companyID"),
                        rs.getString("paymentMethod"), 
                        rs.getInt("state"), rs.getInt("status")
                );
                return order;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
