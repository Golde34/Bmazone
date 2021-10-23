/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ProductGenre;
import java.util.ArrayList;
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
public class ProductGenreDAOTest {
    
    public ProductGenreDAOTest() {
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
     * Test of getGenreIdByProductId method, of class ProductGenreDAO.
     */
    @Test
    public void testGetGenreIdByProductId() {
        System.out.println("getGenreIdByProductId");
        int productId = 29;
        ProductGenreDAO instance = new ProductGenreDAO();
        String result = instance.getGenreIdByProductId(productId);
        assertEquals("5", result);
    }

    @Test
    public void testGetGenreIdByProductIdWrong() {
        System.out.println("getGenreIdByProductId");
        int productId = 29;
        ProductGenreDAO instance = new ProductGenreDAO();
        String result = instance.getGenreIdByProductId(productId);
        assertNotEquals("10", result);
    }

    @Test
    public void testGetGenreIdByProductIdNotExist() {
        System.out.println("getGenreIdByProductId");
        int productId = 150;
        ProductGenreDAO instance = new ProductGenreDAO();
        String result = instance.getGenreIdByProductId(productId);
        assertEquals(null, result);
    }

    /**
     * Test of getAllProductGenre method, of class ProductGenreDAO.
     */
    @Test
    public void testGetAllProductGenre() {
        System.out.println("getAllProductGenre");
        ProductGenreDAO instance = new ProductGenreDAO();
        ArrayList<ProductGenre> result = instance.getAllProductGenre();
        assertEquals(90, result.size());
    }

    @Test
    public void testGetAllProductGenreWrong() {
        System.out.println("getAllProductGenre");
        ProductGenreDAO instance = new ProductGenreDAO();
        ArrayList<ProductGenre> result = instance.getAllProductGenre();
        assertNotEquals(150, result.size());
    }
    /**
     * Test of updateProductGenre method, of class ProductGenreDAO.
     */
    @Test
    public void testUpdateProductGenre() {
        System.out.println("updateProductGenre");
        ProductGenre obj = new ProductGenre(90, 20, 1);
        ProductGenreDAO instance = new ProductGenreDAO();
        int expResult = 1;
        int result = instance.updateProductGenre(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateProductGenreWrong() {
        System.out.println("updateProductGenre");
        ProductGenre obj = new ProductGenre(90, 50, 1);
        ProductGenreDAO instance = new ProductGenreDAO();
        int expResult = 0;
        int result = instance.updateProductGenre(obj);
        assertEquals(expResult, result);
    }

}
