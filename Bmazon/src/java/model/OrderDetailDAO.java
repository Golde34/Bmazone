/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Customer;
import entity.Order;
import entity.OrderDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        for (Customer item : dao.getAllFamiliarCustomer(4)) {

            System.out.println(item.getOrder());
        }
    }

    public int insertOrderDetail(OrderDetail obj) {
        int n = 0;
        String sql = "Insert into OrderDetail(orderID, productTypeID, productName, price, quantity, status)"
                + " values (?,?,?,?,?,1)";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getOrderID());
            pre.setString(2, obj.getProductTypeId());
            pre.setString(3, obj.getProductName());
            pre.setDouble(4, obj.getPrice());
            pre.setInt(5, obj.getQuantity());
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
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

//    public int removeOrderDetail(String orderId, String productTypeID) {
//        int n = 0;
//        String sql = "delete from OrderDetail where orderID = '?' and productTypeID = '?'";
//        try {
//            pre = conn.prepareStatement(sql);           
//            pre.setString(1, orderId);
//            pre.setString(2, productTypeID);
//            n = pre.executeUpdate();
//        } catch (Exception ex) {
//            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return n;
//    }
    public int updateOrderDetailQuantity(OrderDetail obj) {
        int n = 0;
        String sql = "update OrderDetail set quantity=? where orderID=? and productTypeID=?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getQuantity());
            pre.setInt(2, obj.getOrderID());
            pre.setString(3, obj.getProductTypeId());
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);

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

    public ArrayList<OrderDetail> getAllOrderDetail(int oid) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        String sql = "select * from `OrderDetail` where orderID = " + oid + " and status = 1  order by orderID desc";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
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

    public int sumSoldProductTypeByPtypeID(String ptID) {
        int result = 0;
        String sql = "SELECT sum(od.quantity)\n"
                + "from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "where od.productTypeID = ? and o.state = 3";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, ptID);
            rs = pre.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public ArrayList<OrderDetail> getOrderDetailByOrderId(int orderId) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        String xSql = "select * from `orderdetail` where orderID=?";
        try {
            conn = new DBConnection().getConnection();
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

        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public int sumSoldProductByProductID(String pid) {
        int result = 0;
        String sql = "select sum(od.quantity), p.productID from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "where p.productID=? and o.state = 3\n";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, pid);
            rs = pre.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<OrderDetail> getOrderDetailBySellerIdAndOrderId(int sellerID, int oid) {
        List<OrderDetail> list = new ArrayList<>();
        String sql = "select od.orderID, od.productTypeID, od.ProductName, od.price,od.quantity,od.`status` from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "   where p.sellerID=? and od.orderID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sellerID);
            pre.setInt(2, oid);
            rs = pre.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail();
                od.setOrderID(rs.getInt("orderID"));
                od.setProductTypeId(rs.getString("productTypeID"));
                od.setProductName(rs.getString("productName"));
                od.setPrice(rs.getDouble("price"));
                od.setQuantity(rs.getInt("quantity"));
                od.setStatus(rs.getInt("status"));
                list.add(od);
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

    public double totalBenefitBySellerID(int sellerID) {
        double result = 0;
        String sql = "select sum(od.price*od.quantity) from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "where p.sellerID=? and o.state = 3";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setDouble(1, sellerID);
            rs = pre.executeQuery();
            if (rs.next()) {
                result = rs.getDouble(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public List<Customer> most5SpentCustomer() {
        List<Customer> list = new ArrayList<>();
        String sql = "select o.userID,sum(od.price*od.quantity) as Spent from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "   where o.state =3 order by Spent desc limit 0,5";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setUserID(rs.getInt(1));
                customer.setSpent(rs.getDouble(2));
                list.add(customer);
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
    public List<Customer> getAllFamiliarCustomer(int sellerID) {
        List<Customer> list = new ArrayList<>();
        String sql = "select o.userID, count(distinct o.orderID), sum(o.total)\n" +
                "from `order` o inner join orderdetail od on o.orderID = od.orderID inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID \n" +
                "where p.sellerID = ? group by userID";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sellerID);
            rs = pre.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setUserID(rs.getInt(1));
                customer.setOrder(rs.getInt(2));
                customer.setSpent(rs.getDouble(3));
                list.add(customer);
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

    public List<Order> most5BigOrder() {

        List<Order> list = new ArrayList<>();
        String sql = "select o.orderID,sum(od.price*od.quantity) as Spent from OrderDetail od inner join ProductType pt on od.productTypeID=pt.productTypeId inner join Product p on pt.productID=p.productID inner join `Order` o on od.orderID = o.orderID\n"
                + "   where o.state =3 group by o.orderID order by Spent desc limit 0,5";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt(1));
                order.setTotal(rs.getDouble(2));
                list.add(order);
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
}
