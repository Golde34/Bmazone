/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.OrderDetail;
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
public class OrderDetailDAOTest {
    
    public OrderDetailDAOTest() {
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
     * Test of insertOrderDetail method, of class OrderDetailDAO.
     */
    @Test
    public void testInsertOrderDetail() {
        System.out.println("insertOrder");
        OrderDetail od = new OrderDetail();
        od.setOrderID(1);
        od.setProductTypeId("Tester");
        od.setProductName("Test add");
        od.setPrice(5000);
        od.setQuantity(5);
        OrderDetailDAO instance = new OrderDetailDAO();
        assertEquals(1, instance.insertOrderDetail(od));
    }

    /**
     * Test of updateOrderDetailQuantity method, of class OrderDetailDAO.
     */
    @Test
    public void testUpdateOrderDetailQuantity() {
        System.out.println("getAllPagingOrderDetail");
        OrderDetail od = new OrderDetail();
        od.setOrderID(1);
        od.setProductTypeId("Tester");
        od.setProductName("Test update quantity to 10");
        od.setPrice(5000);
        od.setQuantity(10);
        OrderDetailDAO instance = new OrderDetailDAO();
        assertEquals(1, instance.insertOrderDetail(od));
    }

    /**
     * Test of getAllOrder method, of class OrderDetailDAO.
     */
    @Test
    public void testGetAllOrder() {
        System.out.println("getOrderDetail");
        OrderDetailDAO instance = new OrderDetailDAO();
        List<OrderDetail> result = instance.getAllOrderDetail(1);
        assertNotSame(0,result.size());
    }
    
}
