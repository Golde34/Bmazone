/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Gallery;
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
 * @author Admin
 */
public class GalleryDAOTest {
    
    public GalleryDAOTest() {
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
     * Test of deleteGallery method, of class GalleryDAO.
     */
    @Test
    public void testDeleteGalleryGivenWrongIdReturn0() {
        System.out.println("deleteGallery");
        GalleryDAO instance = new GalleryDAO();
        assertEquals(0, instance.deleteGallery(0));
        assertEquals(0, instance.deleteGallery(-100));
    }
    @Test
    public void testDeleteGalleryGivenTrueIdReturn1(){
        System.out.println("deleteGallery");
        GalleryDAO instance = new GalleryDAO();
        assertEquals(1, instance.deleteGallery(99));
    }

    /**
     * Test of addGallery method, of class GalleryDAO.
     */
    @Test
    public void testAddGalleryGivenGalleryNullReturn0() {
        System.out.println("addGallery");
        Gallery g = null;
        GalleryDAO instance = new GalleryDAO();
        assertEquals(0, instance.addGallery(g));
    }
    @Test
    public void testAddGalleryGivenEmptyReturn0() {
        System.out.println("addGallery");
        Gallery g = new Gallery();
        GalleryDAO instance = new GalleryDAO();
        assertEquals(0, instance.addGallery(g));
    }
    @Test
    public void testAddGalleryGivenTrueGalleryReturn1() {
        System.out.println("addGallery");
        Gallery g = new Gallery();
        g.setProductID(1);
        g.setLink("test");
        g.setProductTypeID("Pr1Ty1");
        g.setStatus(1);
        GalleryDAO instance = new GalleryDAO();
        assertEquals(1, instance.addGallery(g));
    }

    /**
     * Test of editGallery method, of class GalleryDAO.
     */
    @Test
    public void testEditGalleryGivenGalleryNullReturn0() {
        System.out.println("editGallery");
        Gallery g = null;
        GalleryDAO instance = new GalleryDAO();
        int result = instance.editGallery(g);
        assertEquals(0, result);
    }

    @Test
    public void testEditGalleryGivenEmptyGallery() {
        System.out.println("editGallery");
        Gallery g = new Gallery();
        GalleryDAO instance = new GalleryDAO();
        int result = instance.editGallery(g);
        assertEquals(0, result);
    }
    
    @Test
    public void testEditGalleryGivenTrueGalleryReturn1() {
        System.out.println("editGallery");
        Gallery g = new Gallery();
        g.setGalleryID(2);
        g.setProductID(1);
        g.setLink("test");
        g.setProductTypeID("Pr1Ty1");
        g.setStatus(1);
        GalleryDAO instance = new GalleryDAO();
        int result = instance.editGallery(g);
        assertEquals(1, result);
    }
    /**
     * Test of getPageNumber method, of class GalleryDAO.
     */
    @Test
    public void testGetPageNumberGivenSearchEqualBlank() {
        System.out.println("getPageNumber");
        String search = "";
        GalleryDAO instance = new GalleryDAO();
        int expResult = instance.getAllGallery().size();
        int result = instance.getPageNumber(search);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGalleryById method, of class GalleryDAO.
     */
    @Test
    public void testGetGalleryById() {
        System.out.println("getGalleryById");
        int id = 0;
        GalleryDAO instance = new GalleryDAO();
        Gallery expResult = null;
        Gallery result = instance.getGalleryById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeStatus method, of class GalleryDAO.
     */
    @Test
    public void testChangeStatusGivenWrongStatusReturn0() {
        System.out.println("changeStatus");
        int id = 0;
        int status = -1;
        GalleryDAO instance = new GalleryDAO();
        int expResult = 0;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeStatusGivenStatusEqual0Return1() {
        System.out.println("changeStatus");
        int id = 0;
        int status = 0;
        GalleryDAO instance = new GalleryDAO();
        int expResult = 0;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeStatusGivenStatusEqual1Return1() {
        System.out.println("changeStatus");
        int id = 0;
        int status = 1;
        GalleryDAO instance = new GalleryDAO();
        int expResult = 0;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllGallery method, of class GalleryDAO.
     */
    @Test
    public void testGetAllGallery() {
        System.out.println("getAllGallery");
        GalleryDAO instance = new GalleryDAO();
        List<Gallery> result = instance.getAllGallery();
        assertNotNull(result);
    }

    /**
     * Test of getAllPagingGallery method, of class GalleryDAO.
     */
    @Test
    public void testGetAllPagingGalleryGivenNegativeIndexReturnEmptyList() {
        System.out.println("getAllPagingGallery");
        int index = -4;
        int numOfRow = 0;
        String search = "";
        GalleryDAO instance = new GalleryDAO();
        List<Gallery> expResult = new ArrayList<>();
        List<Gallery> result = instance.getAllPagingGallery(index, numOfRow, search);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAllPagingGalleryGivenNegativeNumOfRowReturnEmptyList() {
        System.out.println("getAllPagingGallery");
        int index = 1;
        int numOfRow = -4;
        String search = "";
        GalleryDAO instance = new GalleryDAO();
        List<Gallery> expResult = new ArrayList<>();
        List<Gallery> result = instance.getAllPagingGallery(index, numOfRow, search);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllGalleryOfProduct method, of class GalleryDAO.
     */
    @Test
    public void testGetAllGalleryOfProductGivenNegativeProductIdReturnEmptyList() {
        System.out.println("getAllGalleryOfProduct");
        int pid = -3;
        GalleryDAO instance = new GalleryDAO();
        List<Gallery> expResult = new ArrayList<>();
        List<Gallery> result = instance.getAllGalleryOfProduct(pid);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAllGalleryOfProductGivenNotExistProductIdReturnEmptyList() {
        System.out.println("getAllGalleryOfProduct");
        int pid = 90000;
        GalleryDAO instance = new GalleryDAO();
        List<Gallery> expResult = new ArrayList<>();
        List<Gallery> result = instance.getAllGalleryOfProduct(pid);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAllGalleryOfProductGivenExistProductIdReturnList() {
        System.out.println("getAllGalleryOfProduct");
        int pid = 90;
        GalleryDAO instance = new GalleryDAO();
        List<Gallery> result = instance.getAllGalleryOfProduct(pid);
        assertEquals(1, result.size());
    }

    /**
     * Test of getSampleOfProduct method, of class GalleryDAO.
     */
    @Test
    public void testGetSampleOfProductGivenNegativeProductId() {
        System.out.println("getSampleOfProduct");
        int pid = -5;
        GalleryDAO instance = new GalleryDAO();
        String expResult = null;
        String result = instance.getSampleOfProduct(pid);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetSampleOfProductGivenTrueProductId() {
        System.out.println("getSampleOfProduct");
        int pid = 2;
        GalleryDAO instance = new GalleryDAO();
        String expResult = "Pr2Ty1Ga1.jpg";
        String result = instance.getSampleOfProduct(pid);
        assertEquals(expResult, result);
    }

    /**
     * Test of getImageByProductTypeID method, of class GalleryDAO.
     */
    @Test
    public void testGetImageGivenNotExistProductTypeID() {
        System.out.println("getImageByProductTypeID");
        String ps = "pro";
        GalleryDAO instance = new GalleryDAO();
        String expResult = null;
        String result = instance.getImageByProductTypeID(ps);
        assertEquals(expResult, result);
    }
    
    public void testGetImageGivenExistProductTypeID() {
        System.out.println("getImageByProductTypeID");
        String ps = "Pr1Ty1";
        GalleryDAO instance = new GalleryDAO();
        String expResult = "Pr1Ty1Ga1.jpg";
        String result = instance.getImageByProductTypeID(ps);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllImageByProductTypeID method, of class GalleryDAO.
     */
    @Test
    public void testGetAllImageByGivenFalseProductTypeID() {
        System.out.println("getAllImageByProductTypeID");
        String ptypeID = "prwqwq";
        GalleryDAO instance = new GalleryDAO();
        List<Gallery> expResult = new ArrayList<>();
        List<Gallery> result = instance.getAllImageByProductTypeID(ptypeID);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAllImageByGivenTrueProductTypeID() {
        System.out.println("getAllImageByProductTypeID");
        String ptypeID = "Pr2Ty1";
        GalleryDAO instance = new GalleryDAO();
        List<Gallery> result = instance.getAllImageByProductTypeID(ptypeID);
        assertEquals(3, result.size());
    }


}
