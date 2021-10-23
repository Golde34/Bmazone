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
        ShipCompany sp = new ShipCompany();
        sp.setCompanyName("Gojek");
        sp.setUnitCost(5000);
        sp.setCommitDate(9);
        sp.setStatus(1);
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(1, instance.addShipCompany(sp));
    }
    
    @Test
    public void testAddShipCompanyNull() {
        System.out.println("addShipCompanyNull");
        ShipCompany sp = new ShipCompany();
        sp.setCompanyName(null);
        sp.setUnitCost(5000);
        sp.setCommitDate(9);
        sp.setStatus(1);
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(0, instance.addShipCompany(sp));
    }

//    /**
//     * Test of editShipCompany method, of class ShipCompanyDAO.
//     */
    @Test
    public void testEditShipCompany() {
        System.out.println("editShipCompany");
        ShipCompany sp = new ShipCompany();
        sp.setCompanyID(1);
        sp.setCompanyName("Test Case in id 1");
        sp.setUnitCost(5000);
        sp.setCommitDate(9);
        sp.setStatus(1);
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(1, instance.editShipCompany(sp));
    }
    
    @Test
    public void testEditShipCompanyNull() {
        System.out.println("editShipCompanyNull");
        ShipCompany sp = new ShipCompany();
        sp.setCompanyID(1);
        sp.setCompanyName(null);
        sp.setUnitCost(5000);
        sp.setCommitDate(9);
        sp.setStatus(1);
        ShipCompanyDAO instance = new ShipCompanyDAO();
        assertEquals(0, instance.editShipCompany(sp));
    }

    /**
     * Test of getShipCompanyById method, of class ShipCompanyDAO.
     */
    @Test
    public void testGetShipCompanyById() {
        System.out.println("getShipCompanyById");
        int id = 1;
        ShipCompanyDAO instance = new ShipCompanyDAO();
        ShipCompany expResult = null;
        ShipCompany result = instance.getShipCompanyById(id);
        assertNotNull(result.getCompanyName());
    }
    
    @Test
    public void testGetShipCompanyByCompanyIdNotExist() {
        System.out.println("getShipCompanyById");
        int id = -1;
        ShipCompanyDAO instance = new ShipCompanyDAO();
        ShipCompany expResult = null;
        ShipCompany result = instance.getShipCompanyById(id);
        assertNull(result.getCompanyName());
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
        assertNotSame(expResult, result);
    }

    @Test
    public void testGetPageNumberWithNonExistSearch() {
        System.out.println("getPageNumber");
        String search = "xc12vklxc3kl";
        ShipCompanyDAO instance = new ShipCompanyDAO();
        int expResult = 0;
        int result = instance.getPageNumber(search);
        assertSame(expResult, result);
    }

    /**
     * Test of getAllPagingShipCompany method, of class ShipCompanyDAO.
     */
    @Test
    public void testGetAllPagingShipCompany() {
        System.out.println("getAllPagingShipCompany");
        int index = 1;
        int numOfRow = 5;
        String search = "";
        ShipCompanyDAO instance = new ShipCompanyDAO();
        List<ShipCompany> result = instance.getAllPagingShipCompany(index, numOfRow, search);
        assertNotNull(result);
    }
    
    
    @Test
    public void testGetAllPagingShipCompanyWithNonExistSearch() {
        System.out.println("getAllPagingShipCompany");
        int index = 1;
        int numOfRow = 5;
        String search = "d23sfvdzcvs";
        ShipCompanyDAO instance = new ShipCompanyDAO();
        List<ShipCompany> result = instance.getAllPagingShipCompany(index, numOfRow, search);
        assertEquals(0,result.size());
    }

    /**
     * Test of getAllShipCompany method, of class ShipCompanyDAO.
     */
    @Test
    public void testGetAllShipCompany() {
        System.out.println("getAllShipCompany");
        ShipCompanyDAO instance = new ShipCompanyDAO();
        List<ShipCompany> result = instance.getAllShipCompany();
        assertNotNull(result);
    }
    
}
