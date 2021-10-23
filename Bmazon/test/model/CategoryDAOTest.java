/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Category;
import java.util.ArrayList;
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
public class CategoryDAOTest {
    
    public CategoryDAOTest() {
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
     * Test of getAllCategories method, of class CategoryDAO.
     */
    @Test
    public void testGetAllCategories() {
        System.out.println("getAllCategories");
        CategoryDAO instance = new CategoryDAO();
        ArrayList<Category> expResult = null;
        ArrayList<Category> result = instance.getAllCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTrueCategories method, of class CategoryDAO.
     */
    @Test
    public void testGetTrueCategories() {
        System.out.println("getTrueCategories");
        CategoryDAO instance = new CategoryDAO();
        ArrayList<Category> expResult = null;
        ArrayList<Category> result = instance.getTrueCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertCategory method, of class CategoryDAO.
     */
    @Test
    public void testInsertCategory() {
        System.out.println("insertCategory");
        Category cate = null;
        CategoryDAO instance = new CategoryDAO();
        instance.insertCategory(cate);
    }

    /**
     * Test of updateCategory method, of class CategoryDAO.
     */
    @Test
    public void testUpdateCategory() {
        System.out.println("updateCategory");
        Category cate = null;
        CategoryDAO instance = new CategoryDAO();
        instance.updateCategory(cate);
    }

    /**
     * Test of getCategoryByCateId method, of class CategoryDAO.
     */
    @Test
    public void testGetCategoryByCateId() {
        System.out.println("getCategoryByCateId");
        String id = "";
        CategoryDAO instance = new CategoryDAO();
        Category expResult = null;
        Category result = instance.getCategoryByCateId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryById method, of class CategoryDAO.
     */
    @Test
    public void testGetCategoryById() {
        System.out.println("getCategoryById");
        int fcaId = 0;
        CategoryDAO instance = new CategoryDAO();
        String expResult = "";
        String result = instance.getCategoryById(fcaId);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeStatus method, of class CategoryDAO.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("changeStatus");
        int id = 0;
        int status = 0;
        CategoryDAO instance = new CategoryDAO();
        int expResult = 0;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCategory method, of class CategoryDAO.
     */
    @Test
    public void testRemoveCategory() {
        System.out.println("removeCategory");
        int id = 0;
        CategoryDAO instance = new CategoryDAO();
        int expResult = 0;
        int result = instance.removeCategory(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkExistCategoryName method, of class CategoryDAO.
     */
    @Test
    public void testCheckExistCategoryName() {
        System.out.println("checkExistCategoryName");
        String categoryName = "";
        CategoryDAO instance = new CategoryDAO();
        boolean expResult = false;
        boolean result = instance.checkExistCategoryName(categoryName);
        assertEquals(expResult, result);
    }
    
}
