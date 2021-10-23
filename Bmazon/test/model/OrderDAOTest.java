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

    /**
     * Test of changeStatus method, of class OrderDAO.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("testChangeStatusWithOrderID");
        OrderDAO instance = new OrderDAO();
        assertEquals(1, instance.changeStatus(1, 0));
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

    /**
     * Test of getAllOrder method, of class OrderDAO.
     */
    @Test
    public void testGetAllOrder() {
        System.out.println("getAllOrder");
        OrderDAO instance = new OrderDAO();
        List<Order> result = instance.getAllOrder();
        assertNotNull(result);
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
        assertNotNull(result);
    }
    
}
