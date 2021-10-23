/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ShipCompany;
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
public class ShipCompanyDAOTest {
    
    public ShipCompanyDAOTest() {
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
     * Test of changeStatus method, of class ShipCompanyDAO.
     */
    @Test
    public void testChangeStatusWithShipCompanyID() {
        System.out.println("testChangeStatusWithShipCompanyID");
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(1, instance.changeStatus(1, 1));
    }

    @Test
    public void testChangeStatusWithIDNotExist() {
        System.out.println("testChangeStatusWithIDNotExist");
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(0, instance.changeStatus(-1, 1));
        assertEquals(0, instance.changeStatus(0, 1));
    }

    /**
     * Test of deleteShipCompany method, of class ShipCompanyDAO.
     */
    @Test
    public void testDeleteShipCompanyNotExist() {
        System.out.println("deleteShipCompany");
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(0, instance.deleteShipCompany("-1"));
    }
    
    
    /**
     * Test of checkExistCompanyName method, of class ShipCompanyDAO.
     */
    @Test
    public void testCheckExistCompanyName() {
        System.out.println("checkExistCompanyName");
        String companyName = "GHTK";
        ShipCompanyDAO instance = new ShipCompanyDAO();
        boolean result = instance.checkExistCompanyName(companyName);
        assertEquals(true, result);
    }
    
    @Test
    public void testCheckNonExistCompanyName() {
        System.out.println("checkExistCompanyName");
        String companyName = "Deptrai";
        ShipCompanyDAO instance = new ShipCompanyDAO();
        boolean result = instance.checkExistCompanyName(companyName);
        assertEquals(false, result);
    }

    /**
     * Test of addShipCompany method, of class ShipCompanyDAO.
     */
    @Test
    public void testAddShipCompany() {
        System.out.println("addShipCompany");
        ShipCompany p = new ShipCompany();
        p.setCompanyName("Gojek");
        p.setUnitCost(5000);
        p.setCommitDate(9);
        p.setCommitDate(12);
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(1, instance.addShipCompany(p));
    }
    @Test
    public void testAddShipCompanyNull() {
        System.out.println("addShipCompanyNull");
        ShipCompany p = new ShipCompany();
        p.setCompanyName(null);
        p.setUnitCost(5000);
        p.setCommitDate(9);
        p.setCommitDate(12);
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(0, instance.addShipCompany(p));
    }

    /**
     * Test of editShipCompany method, of class ShipCompanyDAO.
     */
    @Test
    public void testEditShipCompany() {
        System.out.println("editShipCompany");
        ShipCompany sp = null;
        ShipCompanyDAO instance = new ShipCompanyDAO();
        int expResult = 0;
        int result = instance.editShipCompany(sp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShipCompanyById method, of class ShipCompanyDAO.
     */
    @Test
    public void testGetShipCompanyById() {
        System.out.println("getShipCompanyById");
        int id = 0;
        ShipCompanyDAO instance = new ShipCompanyDAO();
        ShipCompany expResult = null;
        ShipCompany result = instance.getShipCompanyById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPageNumber method, of class ShipCompanyDAO.
     */
    @Test
    public void testGetPageNumber() {
        System.out.println("getPageNumber");
        String search = "";
        ShipCompanyDAO instance = new ShipCompanyDAO();
        int expResult = 0;
        int result = instance.getPageNumber(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ShipCompanyDAO.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ShipCompanyDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPagingShipCompany method, of class ShipCompanyDAO.
     */
    @Test
    public void testGetAllPagingShipCompany() {
        System.out.println("getAllPagingShipCompany");
        int index = 0;
        int numOfRow = 0;
        String search = "";
        ShipCompanyDAO instance = new ShipCompanyDAO();
        List<ShipCompany> expResult = null;
        List<ShipCompany> result = instance.getAllPagingShipCompany(index, numOfRow, search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllShipCompany method, of class ShipCompanyDAO.
     */
    @Test
    public void testGetAllShipCompany() {
        System.out.println("getAllShipCompany");
        ShipCompanyDAO instance = new ShipCompanyDAO();
        List<ShipCompany> expResult = null;
        List<ShipCompany> result = instance.getAllShipCompany();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
