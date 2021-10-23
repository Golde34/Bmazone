/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ProductCategory;
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
public class ProductCategoryDAOTest {
    
    public ProductCategoryDAOTest() {
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
     * Test of getCategoryIdByProductId method, of class ProductCategoryDAO.
     */
    @Test
    public void testGetCategoryIdByProductId() {
        System.out.println("getCategoryIdByProductId");
        int productId = 15;
        ProductCategoryDAO instance = new ProductCategoryDAO();
        String result = instance.getCategoryIdByProductId(productId);
        assertEquals("3", result);
    }

    @Test
    public void testGetCategoryIdByProductIdWrong() {
        System.out.println("getCategoryIdByProductId");
        int productId = 15;
        ProductCategoryDAO instance = new ProductCategoryDAO();
        String result = instance.getCategoryIdByProductId(productId);
        assertNotEquals("4", result);
    }

    /**
     * Test of updateProductCategory method, of class ProductCategoryDAO.
     */
    @Test
    public void testUpdateProductCategory() {
        System.out.println("updateProductCategory");
        ProductCategory obj = new ProductCategory(90, 6, 1);
        ProductCategoryDAO instance = new ProductCategoryDAO();
        int expResult = 1;
        int result = instance.updateProductCategory(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateProductCategoryWrong() {
        System.out.println("updateProductCategory");
        ProductCategory obj = new ProductCategory(90, 15, 1);
        ProductCategoryDAO instance = new ProductCategoryDAO();
        int expResult = 0;
        int result = instance.updateProductCategory(obj);
        assertEquals(expResult, result);
    }
    /**
     * Test of getAllProductCategory method, of class ProductCategoryDAO.
     */
    @Test
    public void testGetAllProductCategory() {
        System.out.println("getAllProductCategory");
        ProductCategoryDAO instance = new ProductCategoryDAO();
        ArrayList<ProductCategory> result = instance.getAllProductCategory();
        assertEquals(90, result.size());
    }

    @Test
    public void testGetAllProductCategoryWrong() {
        System.out.println("getAllProductCategory");
        ProductCategoryDAO instance = new ProductCategoryDAO();
        ArrayList<ProductCategory> result = instance.getAllProductCategory();
        assertNotEquals(1000, result.size());
    }

    /**
     * Test of getProductCateByProductID method, of class ProductCategoryDAO.
     */
    @Test
    public void testGetProductCateByProductID() {
        System.out.println("getProductCateByProductID");
        int pid = 80;
        ProductCategoryDAO instance = new ProductCategoryDAO();
        ProductCategory result = instance.getProductCateByProductID(pid);
        assertEquals(4, result.getCategoryID());
    }

    @Test
    public void testGetProductCateByProductIDWrong() {
        System.out.println("getProductCateByProductID");
        int pid = 80;
        ProductCategoryDAO instance = new ProductCategoryDAO();
        ProductCategory result = instance.getProductCateByProductID(pid);
        assertNotEquals(30, result.getCategoryID());
    }
        @Test
    public void testGetProductCateByProductIDNotExist() {
        System.out.println("getProductCateByProductID");
        int pid = 150;
        ProductCategoryDAO instance = new ProductCategoryDAO();
        ProductCategory result = instance.getProductCateByProductID(pid);
        assertEquals(0, result.getCategoryID());
    }
    
}
