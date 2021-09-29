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
public class AdminControllerTest {
    
    public AdminControllerTest() {
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
     * Test of processRequest method, of class AdminController.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.processRequest(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceAdminDashboard method, of class AdminController.
     */
    @Test
    public void testServiceAdminDashboard() {
        System.out.println("serviceAdminDashboard");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceAdminDashboard(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceUserManagement method, of class AdminController.
     */
    @Test
    public void testServiceUserManagement() {
        System.out.println("serviceUserManagement");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceUserManagement(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceEditDetail method, of class AdminController.
     */
    @Test
    public void testServiceEditDetail() {
        System.out.println("serviceEditDetail");
        String service = "";
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceEditDetail(service, request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceAddUser method, of class AdminController.
     */
    @Test
    public void testServiceAddUser() {
        System.out.println("serviceAddUser");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceAddUser(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceUpdateUser method, of class AdminController.
     */
    @Test
    public void testServiceUpdateUser() {
        System.out.println("serviceUpdateUser");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceUpdateUser(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceDeleteUser method, of class AdminController.
     */
    @Test
    public void testServiceDeleteUser() {
        System.out.println("serviceDeleteUser");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceDeleteUser(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceProductManagement method, of class AdminController.
     */
    @Test
    public void testServiceProductManagement() {
        System.out.println("serviceProductManagement");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceProductManagement(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceCompanyManagement method, of class AdminController.
     */
    @Test
    public void testServiceCompanyManagement() {
        System.out.println("serviceCompanyManagement");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceCompanyManagement(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serviceGalleryManagement method, of class AdminController.
     */
    @Test
    public void testServiceGalleryManagement() {
        System.out.println("serviceGalleryManagement");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.serviceGalleryManagement(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendDispatcher method, of class AdminController.
     */
    @Test
    public void testSendDispatcher() {
        System.out.println("sendDispatcher");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        String path = "";
        AdminController instance = new AdminController();
        instance.sendDispatcher(request, response, path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doGet method, of class AdminController.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class AdminController.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        AdminController instance = new AdminController();
        instance.doPost(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServletInfo method, of class AdminController.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        AdminController instance = new AdminController();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
