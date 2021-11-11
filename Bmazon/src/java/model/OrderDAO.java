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
        String Sql = "SELECT COUNT(*) FROM `Order`";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(Sql);
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
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }

    public List<Order> getAllPagingOrder(int index, int numOfRow, String search) {
        int start = (index - 1) * numOfRow;
        List<Order> list = new ArrayList<>();
        String sql = "select * from `order` where state=0 and status=1 order by orderDate desc limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public List<Order> getPagingOrderWaitedBySeller(int index, int numOfRow, String search, int sellerID) {
        int start = (index - 1) * numOfRow;
        List<Order> list = new ArrayList<>();
        String sql = "select o.orderID,o.userID, o.orderDate,o.requiredDate,o.shippedDate,o.shipName,o.shipAddress,o.shipCity,o.shipPhone,o.companyID,o.shipMoney,o.paymentMethod,o.total,  o.state, o.`status`\n"
                + "from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "where p.sellerID = ? and o.`status` = 1 and o.state=0\n"
                + "group by od.orderID limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sellerID);
            pre.setInt(2, start);
            pre.setInt(3, numOfRow);
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

//    public int getPageNumberOrderBySeller(String search) {
//        int num = 0;
//        String sql = "select o.orderID,o.userID, o.orderDate,o.requiredDate,o.shippedDate,o.shipName,o.shipAddress,o.shipCity,o.shipPhone,o.companyID,o.shipMoney,o.paymentMethod,o.total,  o.state, o.`status`\n" +
//                        "from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n" +
//                        "where p.sellerID = ? and o.`status` = 1\n" +
//                        "group by od.orderID";
//        ResultSet rs = dbConn.getData(sql);
//        try {
//            if (rs.next()) {
//                num = rs.getInt(1);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return num;
//    }
    public List<Order> getAllPagingOrderBySeller(int index, int numOfRow, String search, int sellerID) {
        int start = (index - 1) * numOfRow;
        List<Order> list = new ArrayList<>();
        String sql = "select o.orderID,o.userID, o.orderDate,o.requiredDate,o.shippedDate,o.shipName,o.shipAddress,o.shipCity,o.shipPhone,o.companyID,o.shipMoney,o.paymentMethod,o.total,  o.state, o.`status`\n"
                + "from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "where p.sellerID = ? and o.`status` = 1\n"
                + "group by od.orderID limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sellerID);
            pre.setInt(2, start);
            pre.setInt(3, numOfRow);
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public int insertOrder(Order obj) {
        int n = 0;
        String sql = "INSERT INTO `Order`"
                + "           (`userID`,`orderDate`,`requiredDate`,`shippedDate`,`shipName`,`shipAddress`,`shipCity`\n"
                + "           ,`shipPhone`,`companyID`,`shipMoney`,`paymentMethod`,`total`,`state`,`status`)"
                + "     VALUES (?,now(),now(),now(),?,?,?,?,?,?,?,?,?,1)";
        try {
            conn = new DBConnection().getConnection();
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
            
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public int changeStatus(int orderId, int status) {
        int n = 0;
        String sql = "UPDATE `Order` SET status = ? WHERE orderID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, orderId);
            n = pre.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public int updateOrder(Order obj) {
        int n = 0;
        String sql = "update `Order` set`orderDate`=? ,`requiredDate`=?,`shippedDate`=?,`shipName`=?,`shipAddress`=?,`shipCity`=?,"
                + "           `shipPhone`=?,`companyID`=?,`shipMoney`=?,`paymentMethod`=? ,`total`=? ,`state`=?,`status`=1 where orderID=?";
        try {
            conn = new DBConnection().getConnection();
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
            
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<Order> getAllActiveOrder() {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "select * from `Order` where status = 1 and state=1";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public static void main(String[] args) {

        OrderDAO odao = new OrderDAO();
        List<Order> listOrder = odao.getAllOrder();
        for (Order order : listOrder) {
            System.out.println(order.getOrderID());
        }
    }

    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "select * from `Order` where status = 1 and state=0 order by orderID desc";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

//    public static void main(String[] args) {
//        OrderDAO odao = new OrderDAO();
//        List<Order> listOrder = odao.getAllPagingOrder(1, 5, "");
//        for (Order order : listOrder) {
//            System.out.println(order.getShipCity());
//        }
//    }
    public Order getOrderByOrderID(int orderid) {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "select * from `Order` where orderID = " + orderid;
        Order o = null;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                o = new Order();
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

            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return o;
    }

    public List<Order> getOrderByUser(int userID) {
        List<Order> list = new ArrayList<>();
        String sql = "select * from `Order` where userID = " + userID + " order by orderid desc ";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
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
            
            
        } catch (Exception e) {
        } finally {
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

    public Order getLatestOrder(String userID) {
        Order o = new Order();
        String sql = "SELECT * FROM `Order` WHERE userID = '" + userID + "' ORDER BY OrderID desc limit 0,1";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
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
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return o;
    }

    public int changeState(int id, int state) {
        int n = 0;
        String xSql = "UPDATE `bmazon`.`order` SET `state` = ? WHERE `orderID` = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, state);
            pre.setInt(2, id);
            n = pre.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<Order> getOrderByMonth(int month) {
        ArrayList<Order> list = new ArrayList<>();
        String xSql = "select * from `Order` where status = 1 and state=1 and month(orderdate) = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, month);
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public List<Order> getOrderBySellerID(int sellerID) {
        List<Order> list = new ArrayList<>();
        String sql = "select o.orderID,o.userID, o.orderDate,o.requiredDate,o.shippedDate,o.shipName,o.shipAddress,o.shipCity,o.shipPhone,o.companyID,o.shipMoney,o.paymentMethod,o.total,  o.state, o.`status`\n"
                + "from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "where p.sellerID = ? and o.`status` = 1\n"
                + "group by od.orderID";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sellerID);
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

//    public int changeState(int id, int state){
//        String xSql = ""
//    }
    public double getSumProfit() {
        double profit = 0;
        String xSql = "select sum(total-shipMoney) as profit from `Order` where status = 1 and state=1";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                profit = rs.getDouble("profit");
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return profit;
    }

    public double getProfitOfMonth(int month) {
        double profit = 0;
        String xSql = "select sum(total-shipMoney) as profit from `Order` where status = 1 and state=1 and month(orderdate) = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, month);
            rs = pre.executeQuery();
            if (rs.next()) {
                profit = rs.getDouble("profit");
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return profit;
    }

    public int countUserOnOrder() {
        int count = 0;
        String xSql = "select count(distinct userid) as NoUser from `order` where status=1 and state=1";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                count = rs.getInt("NoUser");
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public int countProductOnOrder() {
        int count = 0;
        String xSql = "select count(distinct productTypeID) as NoProduct from orderdetail,`order` where orderdetail.orderID=`order`.orderID and `order`.`status`=1 and state=1";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                count = rs.getInt("NoProduct");
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }
}
