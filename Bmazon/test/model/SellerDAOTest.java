/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Seller;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AD
 */
public class SellerDAOTest {

    public SellerDAOTest() {
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
     * Test of addSeller method, of class SellerDAO.
     */
    @Test
    public void testAddSeller() {
        System.out.println("addSeller");
        Seller s = new Seller(2, "Chua nghi ra", "0927598368", "owner can sell everything", 1, "Khi nao nghi ra thi ban", 1);
        SellerDAO instance = new SellerDAO();
        int result = instance.addSeler(s);
        assertEquals(1, result);
    }
    
    /**
     * Test of editSeller method, of class SellerDAO.
     */
    @Test
    public void testEditSeller() {
        System.out.println("editSeller");
        Seller s = new Seller(2, 2, "ABC", "0927598368", "owner can sell everything", 1, "Khi nao nghi ra thi ban", 1, 1);
        SellerDAO instance = new SellerDAO();
        int result = instance.editSeller(s);
        assertEquals(1, result);
    }

    @Test
    public void testEditSellerNotExist() {
        System.out.println("editSeller");
        Seller s = new Seller(100, 9, "ABC", "0917283581", "Evidence", 1, "OKE", 1, 1);
        SellerDAO instance = new SellerDAO();
        int result = instance.editSeller(s);
        assertEquals(0, result);
    }

    /**
     * Test of checkExistPhone method, of class SellerDAO.
     */
    @Test
    public void testCheckExistPhone() {
        System.out.println("checkExistPhone");
        SellerDAO instance = new SellerDAO();
        boolean result = instance.checkExistPhone("0927598368");
        assertEquals(true, result);
    }

    @Test
    public void testCheckExistPhoneNotExist() {
        System.out.println("checkExistPhone");
        SellerDAO instance = new SellerDAO();
        boolean result = instance.checkExistPhone("0927598462");
        assertEquals(false, result);
    }

    /**
     * Test of checkExistUserID method, of class SellerDAO.
     */
    @Test
    public void testCheckExistUserID() {
        System.out.println("checkExistUserID");
        SellerDAO instance = new SellerDAO();
        boolean result = instance.checkExistUserID(6);
        assertEquals(true, result);
    }

    @Test
    public void testCheckExistUserIDNotExist() {
        System.out.println("checkExistUserID");
        SellerDAO instance = new SellerDAO();
        boolean result = instance.checkExistUserID(100);
        assertEquals(false, result);
    }

    /**
     * Test of checkExistSellerShopName method, of class SellerDAO.
     */
    @Test
    public void testCheckExistSellerShopName() {
        System.out.println("checkExistSellerShopName");
        SellerDAO instance = new SellerDAO();
        boolean result = instance.checkExistSellerShopName("Golde Shop Devenote");
        assertEquals(true, result);
    }

    @Test
    public void testCheckExistSellerShopNameNotExist() {
        System.out.println("checkExistSellerShopName");
        SellerDAO instance = new SellerDAO();
        boolean result = instance.checkExistSellerShopName("ahaetjaetja");
        assertEquals(false, result);
    }

    /**
     * Test of checkExistSellerId method, of class SellerDAO.
     */
    @Test
    public void testCheckExistSellerId() {
        System.out.println("checkExistSellerId");
        SellerDAO instance = new SellerDAO();
        boolean result = instance.checkExistSellerId(5);
        assertEquals(true, result);
    }

    @Test
    public void testCheckExistSellerIdNotExist() {
        System.out.println("checkExistSellerId");
        SellerDAO instance = new SellerDAO();
        boolean result = instance.checkExistSellerId(100);
        assertEquals(false, result);
    }

    /**
     * Test of getSellerID method, of class SellerDAO.
     */
    @Test
    public void testGetSellerID() {
        System.out.println("getSellerID");
        SellerDAO instance = new SellerDAO();
        Seller result = instance.getSellerID("5");
        assertNotEquals(null, result);
    }

    @Test
    public void testGetSellerIDNotExist() {
        System.out.println("getSellerID");
        SellerDAO instance = new SellerDAO();
        Seller result = instance.getSellerID("100");
        assertEquals(null, result);
    }

    /**
     * Test of getAllSeller method, of class SellerDAO.
     */
    @Test
    public void testGetAllSeller() {
        System.out.println("getAllSeller");
        SellerDAO instance = new SellerDAO();
        List<Seller> result = instance.getAllSeller();
        assertEquals(false, result.isEmpty());
    }

    @Test
    public void testGetAllSellerWrong() {
        System.out.println("getAllSeller");
        SellerDAO instance = new SellerDAO();
        List<Seller> result = instance.getAllSeller();
        assertNotEquals(100, result.size());
    }

    /**
     * Test of getSellerBySellerRequest method, of class SellerDAO.
     */
    @Test
    public void testGetSellerBySellerRequest() {
        System.out.println("getSellerBySellerRequest");
        SellerDAO instance = new SellerDAO();
        List<Seller> result = instance.getSellerBySellerRequest();
        assertEquals(0, result.size());
    }

    @Test
    public void testGetSellerBySellerRequestWrong() {
        System.out.println("getSellerBySellerRequest");
        SellerDAO instance = new SellerDAO();
        List<Seller> result = instance.getSellerBySellerRequest();
        assertNotEquals(100, result.size());
    }

    /**
     * Test of getSellerByUserID method, of class SellerDAO.
     */
    @Test
    public void testGetSellerByUserID() {
        System.out.println("getSellerByUserID");
        SellerDAO instance = new SellerDAO();
        Seller result = instance.getSellerByUserID(3);
        assertNotEquals(null, result);
    }

    @Test
    public void testGetSellerByUserIDNotExist() {
        System.out.println("getSellerByUserID");
        SellerDAO instance = new SellerDAO();
        Seller result = instance.getSellerByUserID(100);
        assertEquals(null, result);
    }

    /**
     * Test of getSellerByProductId method, of class SellerDAO.
     */
    @Test
    public void testGetSellerByProductId() {
        System.out.println("getSellerByProductId");
        SellerDAO instance = new SellerDAO();
        Seller result = instance.getSellerByProductId(1);
        assertNotEquals(null, result);
    }

    @Test
    public void testGetSellerByProductIdNotExist() {
        System.out.println("getSellerByProductId");
        SellerDAO instance = new SellerDAO();
        Seller result = instance.getSellerByProductId(1000);
        assertEquals(null, result);
    }

    /**
     * Test of denySellerRequest method, of class SellerDAO.
     */
    @Test
    public void testDenySellerRequest() {
        System.out.println("denySellerRequest");
        SellerDAO instance = new SellerDAO();
        int result = instance.denySellerRequest(3);
        assertEquals(1, result);
    }

    @Test
    public void testDenySellerRequestNotExist() {
        System.out.println("denySellerRequest");
        SellerDAO instance = new SellerDAO();
        int result = instance.denySellerRequest(100);
        assertEquals(0, result);
    }

    /**
     * Test of acceptSellerRequest method, of class SellerDAO.
     */
    @Test
    public void testAcceptSellerRequest() {
        System.out.println("acceptSellerRequest");
        SellerDAO instance = new SellerDAO();
        int result = instance.acceptSellerRequest(3);
        assertEquals(1, result);
    }

    @Test
    public void testAcceptSellerRequestNotExist() {
        System.out.println("acceptSellerRequest");
        SellerDAO instance = new SellerDAO();
        int result = instance.acceptSellerRequest(100);
        assertEquals(0, result);
    }

    /**
     * Test of searchSeller method, of class SellerDAO.
     */
    @Test
    public void testSearchSeller() {
        System.out.println("searchSeller");
        SellerDAO instance = new SellerDAO();
        List<Seller> result = instance.searchSeller("Golde");
        assertEquals(false, result.isEmpty());
    }
}
