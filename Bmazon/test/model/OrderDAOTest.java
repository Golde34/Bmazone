/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Order;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
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
     * Test of insertOrder method, of class OrderDAO.
     */
    @Test
    public void testInsertOrder() {
        System.out.println("insertOrder");
        OrderDAO instance = new OrderDAO();
        assertEquals(1, instance.insertOrder(new Order("1", Date.valueOf("2001-04-03"), Date.valueOf("2001-04-09"), "Bmazone", "Kim thanh", "Hai Duong", "0983586778", 0, 0, 0, "COD")));
    }

    @Test
    public void testInsertOrderWithUserIdNull() {
        System.out.println("addUser");
        OrderDAO instance = new OrderDAO();
        assertEquals(0, instance.insertOrder(new Order(null, Date.valueOf("2001-04-03"), Date.valueOf("2001-04-09"), "Bmazone", "Kim thanh", "Hai Duong", "0983586778", 0, 0, 0, "COD")));
    }

    @Test
    public void testInsertOrderWithDateNull() {
        System.out.println("addUser");
        OrderDAO instance = new OrderDAO();
        assertEquals(0, instance.insertOrder(new Order("1", Date.valueOf(toString()), Date.valueOf("2001-04-09"), "Bmazone", "Kim thanh", "Hai Duong", "0983586778", 0, 0, 0, "COD")));
    }

    /**
     * Test of changeStatus method, of class OrderDAO.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("changeStatus");
        OrderDAO instance = new OrderDAO();
        assertEquals(1, instance.changeStatus("3"));
    }
    
    @Test
    public void testChangeStatusWithUsername() {
        System.out.println("changeStatus");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.changeStatus("G", 1));
    }

    @Test
    public void testChangeStatusWithUsernameNotExist() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.changeStatus("", 1));
        assertEquals(0, instance.changeStatus("A", 1));
    }

    @Test
    public void testChangeStatusWithUsernameNull() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.changeStatus(null, 1));

    }

    @Test
    public void testChangeStatusWithNegativeStatus() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.changeStatus("Golde", -1));
    }

    /**
     * Test of updateOrder method, of class OrderDAO.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("updateOrder");
        Order obj = null;
        OrderDAO instance = new OrderDAO();
        int expResult = 0;
        int result = instance.updateOrder(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrder method, of class OrderDAO.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        String orderId = "";
        OrderDAO instance = new OrderDAO();
        int expResult = 0;
        int result = instance.removeOrder(orderId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllOrder method, of class OrderDAO.
     */
    @Test
    public void testGetAllOrder() {
        System.out.println("getAllOrder");
        OrderDAO instance = new OrderDAO();
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.getAllOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
