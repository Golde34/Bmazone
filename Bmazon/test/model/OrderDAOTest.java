/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editoo.
 */
package model;

import entity.Order;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class OrderDAOTest {
    
    public OrderDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPageNumber method, of class OrderDAO.
     */
    @Test
    public void testGetPageNumber() {
        System.out.println("getPageNumber");
        String search = "";
        OrderDAO instance = new OrderDAO();
        int expResult = 0;
        int result = instance.getPageNumber(search);
        assertNotSame(expResult, result);
    }

    /**
     * Test of getAllPagingOrder method, of class OrderDAO.
     */
    @Test
    public void testGetAllPagingOrder() {
        System.out.println("getAllPagingOrder");
        int index = 1;
        int numOfRow = 5;
        String search = "";
        OrderDAO instance = new OrderDAO();
        List<Order> result = instance.getAllPagingOrder(index, numOfRow, search);
        assertNotNull(result);
    }

    @Test
    public void testGetAllPagingOrderNull() {
        System.out.println("getAllPagingOrder");
        int index = -5;
        int numOfRow = -5;
        String search = "";
        OrderDAO instance = new OrderDAO();
        List<Order> result = instance.getAllPagingOrder(index, numOfRow, search);
        assertEquals(0, result.size());
    }
    
    /**
     * Test of insertOrder method, of class OrderDAO.
     */
    @Test
    public void testInsertOrder() {
        System.out.println("insertOrder");
        Order o = new Order();
        o.setUserID("1");
        o.setOrderDate(Date.valueOf("2021-10-10"));
        o.setRequiredDate(Date.valueOf("2021-10-10"));
        o.setShippedDate(Date.valueOf("2021-10-10"));
        o.setShipAddress("Tester insert");
        o.setTotal(500000);
        o.setStatus(1);
        OrderDAO instance = new OrderDAO();
        assertEquals(1, instance.insertOrder(o));
    }
    
    @Test
    public void testInsertOrderNull() {
        System.out.println("insertOrder");
        Order o = new Order();
        OrderDAO instance = new OrderDAO();
        assertEquals(0, instance.insertOrder(o));
    }

    /**
     * Test of changeStatus method, of class OrderDAO.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("testChangeStatusWithOrderID");
        OrderDAO instance = new OrderDAO();
        int cid = 1;
        int expected = 1;
        assertEquals(expected, instance.changeStatus(cid, 0));
    }
    
    @Test
    public void testChangeStatusIdNotExist() {
        System.out.println("testChangeStatusWithOrderID");
        OrderDAO instance = new OrderDAO();
        int cid = -99;
        int expected = 0;
        assertEquals(expected, instance.changeStatus(cid, 0));
    }

    /**
     * Test of updateOrder method, of class OrderDAO.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("editOrder");
        Order o = new Order();
        o.setOrderID(1);
        o.setUserID("2");
        o.setOrderDate(Date.valueOf("2021-10-10"));
        o.setRequiredDate(Date.valueOf("2021-10-10"));
        o.setShippedDate(Date.valueOf("2021-10-10"));
        o.setShipAddress("Tester update");
        o.setTotal(500000);
        o.setStatus(1);
        OrderDAO instance = new OrderDAO();
        assertEquals(1, instance.updateOrder(o));
    }

    @Test
    public void testUpdateOrderNull() {
        System.out.println("editOrder");
        Order o = new Order();
        OrderDAO instance = new OrderDAO();
        assertEquals(0, instance.updateOrder(o));
    }
    
    /**
     * Test of getAllOrder method, of class OrderDAO.
     */
    @Test
    public void testGetAllOrder() {
        System.out.println("getAllOrder");
        OrderDAO instance = new OrderDAO();
        List<Order> result = instance.getAllOrder();
        assertEquals(false, result.isEmpty());
    }

    /**
     * Test of getOrderBySeller method, of class OrderDAO.
     */
    @Test
    public void testGetOrderBySeller() {
        System.out.println("getOrderBySeller");
        int userID = 2;
        OrderDAO instance = new OrderDAO();
        List<Order> result = instance.getOrderByUser(userID);
        assertEquals(false, result.isEmpty());
    }
    
    @Test
    public void testGetOrderBySellerNotExist() {
        System.out.println("getOrderBySeller");
        int userID = -99;
        OrderDAO instance = new OrderDAO();
        List<Order> result = instance.getOrderByUser(userID);
        assertEquals(true, result.isEmpty());
    }
}
