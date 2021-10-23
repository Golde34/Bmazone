/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.WareHouse;
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
public class WareHouseDAOTest {
    
    public WareHouseDAOTest() {
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
     * Test of getPageNumber method, of class WareHouseDAO.
     */
    @Test
    public void testGetPageNumber() {
        System.out.println("getPageNumber");
        String search = "";
        WareHouseDAO instance = new WareHouseDAO();
        int expResult = 0;
        int result = instance.getPageNumber(search);
        assertNotSame(expResult, result);
    }

    /**
     * Test of getAllPagingWareHouse method, of class WareHouseDAO.
     */
    @Test
    public void testGetAllPagingWareHouse() {
        System.out.println("getAllPagingWareHouse");
        int index = 1;
        int numOfRow = 5;
        String search = "";
        WareHouseDAO instance = new WareHouseDAO();
        List<WareHouse> result = instance.getAllPagingWareHouse(index, numOfRow, search);
        assertNotNull(result);
    }

    /**
     * Test of changeStatus method, of class WareHouseDAO.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("testChangeStatusWithWareHouseID");
        WareHouseDAO instance = new WareHouseDAO();
        assertEquals(1, instance.changeStatus(1, 1));
    }

    /**
     * Test of addWareHouse method, of class WareHouseDAO.
     */
    @Test
    public void testAddWareHouse() {
        System.out.println("addWareHouse");
        WareHouse wh = new WareHouse();
        wh.setWareHouseAddress("Test add");
        wh.setStatus(0);
        WareHouseDAO instance = new WareHouseDAO();
        assertEquals(1, instance.addWareHouse(wh));
    }

    /**
     * Test of editWareHouse method, of class WareHouseDAO.
     */
    @Test
    public void testEditWareHouse() {
        System.out.println("editWareHouse");
        WareHouse wh = new WareHouse();
        wh.setWareHouseID(1);
        wh.setWareHouseAddress("Test Case in id 1");
        wh.setStatus(0);
        WareHouseDAO instance = new WareHouseDAO();
        assertEquals(1, instance.editWareHouse(wh));
    }

    /**
     * Test of checkExistWareHouse method, of class WareHouseDAO.
     */
    @Test
    public void testCheckExistWareHouse() {
        System.out.println("checkExistwareHouseAddress");
        String companyName = "Test add";
        WareHouseDAO instance = new WareHouseDAO();
        boolean result = instance.checkExistWareHouse(companyName);
        assertEquals(true, result);
    }

    /**
     * Test of getWareHouseById method, of class WareHouseDAO.
     */
    @Test
    public void testGetWareHouseById() {
        System.out.println("getWareHouseById");
        int id = 1;
        WareHouseDAO instance = new WareHouseDAO();
        WareHouse result = instance.getWareHouseById(id);
        assertNotNull(result.getWareHouseAddress());
    }

    /**
     * Test of getAllWareHouse method, of class WareHouseDAO.
     */
    @Test
    public void testGetAllWareHouse() {
        System.out.println("getAllWareHouse");
        WareHouseDAO instance = new WareHouseDAO();
        List<WareHouse> expResult = null;
        List<WareHouse> result = instance.getAllWareHouse();
        assertNotNull(result);
    }
    
}
