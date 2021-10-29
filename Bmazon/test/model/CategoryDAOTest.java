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
        ArrayList<Category> result = instance.getAllCategories();
        assertEquals(6, result.size());
    }

    /**
     * Test of getTrueCategories method, of class CategoryDAO.
     */
    @Test
    public void testGetTrueCategories() {
        System.out.println("getTrueCategories");
        CategoryDAO instance = new CategoryDAO();
        ArrayList<Category> result = instance.getTrueCategories();
        assertEquals(6, result.size());
    }

    /**
     * Test of insertCategory method, of class CategoryDAO.
     */
    @Test
    public void testInsertFalseCategory() {
        System.out.println("insertCategory");
        Category cate = new Category();
        cate.setCategoryName("test");
        cate.setStatus(-2);
        CategoryDAO instance = new CategoryDAO();
        assertEquals(0, instance.insertCategory(cate));
    }
    @Test
    public void testInsertTrueCategory() {
        System.out.println("insertCategory");
        Category cate = new Category();
        cate.setCategoryName("Keyboard");
        cate.setStatus(1);
        CategoryDAO instance = new CategoryDAO();
        assertEquals(1, instance.insertCategory(cate));
    }

    /**
     * Test of updateCategory method, of class CategoryDAO.
     */
    @Test
    public void testUpdateFalseCategory() {
        System.out.println("updateCategory");
        Category cate = new Category();
        cate.setCategoryID(0);
        cate.setCategoryName("test");
        cate.setStatus(1);
        CategoryDAO instance = new CategoryDAO();
        assertEquals(0, instance.updateCategory(cate));
    }
    
    @Test
    public void testUpdateTrueCategory() {
        System.out.println("updateCategory");
        Category cate = new Category();
        cate.setCategoryID(1);
        cate.setCategoryName("test");
        cate.setStatus(1);
        CategoryDAO instance = new CategoryDAO();
        assertEquals(1, instance.updateCategory(cate));
    }

    /**
     * Test of getCategoryByCateId method, of class CategoryDAO.
     */
    @Test
    public void testGetCategoryByTrueCateId() {
        System.out.println("getCategoryByCateId");
        String id = "1";
        CategoryDAO instance = new CategoryDAO();
        Category result = instance.getCategoryByCateId(id);
        assertNotNull(result);
    }
    
    @Test
    public void testGetCategoryByFalseCateId() {
        System.out.println("getCategoryByCateId");
        String id = "-1";
        CategoryDAO instance = new CategoryDAO();
        Category result = instance.getCategoryByCateId(id);
        assertNull(result);
    }

    /**
     * Test of getCategoryById method, of class CategoryDAO.
     */
    @Test
    public void testGetCategoryByFalseId() {
        System.out.println("getCategoryById");
        int fcaId = 0;
        CategoryDAO instance = new CategoryDAO();
        String expResult = null;
        String result = instance.getCategoryById(fcaId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCategoryByTrueId() {
        System.out.println("getCategoryById");
        int fcaId = 1;
        CategoryDAO instance = new CategoryDAO();
        String expResult = "test";
        String result = instance.getCategoryById(fcaId);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeStatus method, of class CategoryDAO.
     */
    @Test
    public void testChangeStatusFalseCategory() {
        System.out.println("changeStatus");
        int id = 0;
        int status = 1;
        CategoryDAO instance = new CategoryDAO();
        int expResult = 0;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }
    
    public void testChangeStatusTrueCategory() {
        System.out.println("changeStatus");
        int id = 1;
        int status = 1;
        CategoryDAO instance = new CategoryDAO();
        int expResult = 1;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCategory method, of class CategoryDAO.
     */
    @Test
    public void testRemoveTrueCategory() {
        System.out.println("removeCategory");
        int id = 7;
        CategoryDAO instance = new CategoryDAO();
        int expResult = 1;
        int result = instance.removeCategory(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveFalseCategory() {
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
        String categoryName = "Laptop";
        CategoryDAO instance = new CategoryDAO();
        boolean expResult = true;
        boolean result = instance.checkExistCategoryName(categoryName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNotExistCategoryName() {
        System.out.println("checkExistCategoryName");
        String categoryName = "";
        CategoryDAO instance = new CategoryDAO();
        boolean expResult = false;
        boolean result = instance.checkExistCategoryName(categoryName);
        assertEquals(expResult, result);
    }
    
}
