/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ProductDetailControllerTest {
    
    public ProductDetailControllerTest() {
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
     * Test of sendDispatcher method, of class ProductDetailController.
     */
    @Test
    public void testSendDispatcher() {
        System.out.println("sendDispatcher");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        String path = "";
        ProductDetailController instance = new ProductDetailController();
        instance.sendDispatcher(request, response, path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processRequest method, of class ProductDetailController.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ProductDetailController instance = new ProductDetailController();
        instance.processRequest(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceProductDetail method, of class ProductDetailController.
     */
    @Test
    public void testServiceProductDetail() {
        System.out.println("serviceProductDetail");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ProductDetailController instance = new ProductDetailController();
        instance.serviceProductDetail(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doGet method, of class ProductDetailController.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ProductDetailController instance = new ProductDetailController();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class ProductDetailController.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ProductDetailController instance = new ProductDetailController();
        instance.doPost(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServletInfo method, of class ProductDetailController.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        ProductDetailController instance = new ProductDetailController();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
