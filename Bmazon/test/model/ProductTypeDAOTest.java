/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ProductType;
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
 * @author AD
 */
public class ProductTypeDAOTest {

    public ProductTypeDAOTest() {
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
     * Test of getAllProductType method, of class ProductTypeDAO.
     */
    @Test
    public void testGetAllProductType() {
        System.out.println("getAllProductType");
        ProductTypeDAO instance = new ProductTypeDAO();
        List<ProductType> result = instance.getAllProductType();
        assertEquals(164, result.size());
    }

    @Test
    public void testGetAllProductTypeWrong() {
        System.out.println("getAllProductType");
        ProductTypeDAO instance = new ProductTypeDAO();
        List<ProductType> result = instance.getAllProductType();
        assertNotEquals(160, result.size());
    }

    /**
     * Test of addProductType method, of class ProductTypeDAO.
     */
    @Test
    public void testAddProductType() {
        System.out.println("addProductType");
        ProductType p = new ProductType("Pr100Ty1", 11, "64GB", "White", "21000000", 1, 20, 1);
        ProductTypeDAO instance = new ProductTypeDAO();
        assertEquals(1, instance.addProductType(p));
    }

    @Test
    public void testAddProductTypeNull() {
        System.out.println("addProductType");
        ProductType p = new ProductType(null, 9, "64GB", "Black", "20000000", 1, 20, 1);
        ProductTypeDAO instance = new ProductTypeDAO();
        assertEquals(0, instance.addProductType(p));
    }

    /**
     * Test of deleteProductType method, of class ProductTypeDAO.
     */
    @Test
    public void testDeleteProductType() {
        System.out.println("deleteProductType");
        ProductTypeDAO instance = new ProductTypeDAO();
        assertEquals(1, instance.deleteProductType("Pr100Ty1"));
    }

    @Test
    public void testDeleteProductTypeNotExist() {
        System.out.println("deleteProductType");
        ProductTypeDAO instance = new ProductTypeDAO();
        assertEquals(0, instance.deleteProductType("Pr150Ty1"));
    }

    /**
     * Test of editProduct method, of class ProductTypeDAO.
     */
    @Test
    public void testEditProduct() {
        System.out.println("editProduct");
        ProductType p = new ProductType("Pr10Ty1", 10, "64GB", "Black", "21300000", 1, 20, 1);
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.editProduct(p);
        assertEquals(1, result);
    }

    @Test
    public void testEditProductNull() {
        System.out.println("editProduct");
        ProductType p = new ProductType(null, 10, "64GB", "Black", "21500000", 1, 20, 1);
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.editProduct(p);
        assertEquals(0, result);
    }

    /**
     * Test of checkoutProductType method, of class ProductTypeDAO.
     */
    @Test
    public void testCheckoutProductType() {
        System.out.println("checkoutProductType");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.checkoutProductType("Pr14Ty1", 20);
        assertEquals(1, result);
    }

    @Test
    public void testCheckoutProductTypeNull() {
        System.out.println("checkoutProductType");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.checkoutProductType(null, 20);
        assertEquals(0, result);
    }

    /**
     * Test of getProductTypeByPTypeID method, of class ProductTypeDAO.
     */
    @Test
    public void testGetProductTypeByPTypeID() {
        System.out.println("getProductTypeByPTypeID");
        ProductTypeDAO instance = new ProductTypeDAO();
        ProductType result = instance.getProductTypeByPTypeID("Pr15Ty1");
        assertEquals(15, result.getProductID());
    }

    @Test
    public void testGetProductTypeByPTypeIDWrong() {
        System.out.println("getProductTypeByPTypeID");
        ProductTypeDAO instance = new ProductTypeDAO();
        ProductType result = instance.getProductTypeByPTypeID("Pr15Ty1");
        assertEquals(15, result.getProductID());
    }

    /**
     * Test of getProductIdByProductTypeId method, of class ProductTypeDAO.
     */
    @Test
    public void testGetProductIdByProductTypeId() {
        System.out.println("getProductIdByProductTypeId");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.getProductIdByProductTypeId("Pr16Ty1");
        assertEquals(16, result);
    }

//    @Test
    public void testGetProductIdByProductTypeIdWrong() {
        System.out.println("getProductIdByProductTypeId");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.getProductIdByProductTypeId("Pr16Ty1");
        assertNotEquals(18, result);
    }

    /**
     * Test of getProductByProductID method, of class ProductTypeDAO.
     */
    @Test
    public void testGetProductByProductID() {
        System.out.println("getProductByProductID");
        ProductTypeDAO instance = new ProductTypeDAO();
        List<ProductType> result = instance.getProductByProductID(18);
        assertEquals(4, result.size());
    }

    @Test
    public void testGetProductByProductIDWrong() {
        System.out.println("getProductByProductID");
        ProductTypeDAO instance = new ProductTypeDAO();
        List<ProductType> result = instance.getProductByProductID(18);
        assertNotEquals(6, result.size());
    }

    /**
     * Test of getProductTypeByColorAndSize method, of class ProductTypeDAO.
     */
    @Test
    public void testGetProductTypeByColorAndSize() {
        System.out.println("getProductTypeByColorAndSize");
        ProductTypeDAO instance = new ProductTypeDAO();
        ProductType result = instance.getProductTypeByColorAndSize("Phantom Black", "256GB", "20");
        assertEquals("Pr20Ty1", result.getProductTypeId());
    }

    @Test
    public void testGetProductTypeByColorAndSizeWrong() {
        System.out.println("getProductTypeByColorAndSize");
        ProductTypeDAO instance = new ProductTypeDAO();
        ProductType result = instance.getProductTypeByColorAndSize("Phantom Black", "256GB", "20");
        assertNotEquals("Pr20Ty2", result.getProductTypeId());
    }

    /**
     * Test of getProductByColor method, of class ProductTypeDAO.
     */
    @Test
    public void testGetProductByColor() {
        System.out.println("getProductByColor");
        ProductTypeDAO instance = new ProductTypeDAO();
        ArrayList<ProductType> result = instance.getProductByColor("Black");
        assertEquals(78, result.size());
    }

    @Test
    public void testGetProductByColorWrong() {
        System.out.println("getProductByColor");
        ProductTypeDAO instance = new ProductTypeDAO();
        ArrayList<ProductType> result = instance.getProductByColor("Black");
        assertNotEquals(80, result.size());
    }

    /**
     * Test of getAllSizeOfProduct method, of class ProductTypeDAO.
     */
    @Test
    public void testGetAllSizeOfProduct() {
        System.out.println("getAllSizeOfProduct");
        ProductTypeDAO instance = new ProductTypeDAO();
        ArrayList<String> result = instance.getAllSizeOfProduct(20);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllSizeOfProductWrong() {
        System.out.println("getAllSizeOfProduct");
        ProductTypeDAO instance = new ProductTypeDAO();
        ArrayList<String> result = instance.getAllSizeOfProduct(20);
        assertNotEquals(3, result.size());
    }

    /**
     * Test of getAllColorOfProduct method, of class ProductTypeDAO.
     */
    @Test
    public void testGetAllColorOfProduct() {
        System.out.println("getAllColorOfProduct");
        ProductTypeDAO instance = new ProductTypeDAO();
        ArrayList<String> result = instance.getAllColorOfProduct(20);
        assertEquals(3, result.size());
    }

    @Test
    public void testGetAllColorOfProductWrong() {
        System.out.println("getAllColorOfProduct");
        ProductTypeDAO instance = new ProductTypeDAO();
        ArrayList<String> result = instance.getAllColorOfProduct(20);
        assertNotEquals(2, result.size());
    }

    /**
     * Test of changeStatus method, of class ProductTypeDAO.
     */
    @Test
    public void testChangeStatusOff() {
        System.out.println("changeStatus");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.changeStatus("Pr43Ty1", 0);
        assertEquals(1, result);
    }

    @Test
    public void testChangeStatusOn() {
        System.out.println("changeStatus");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.changeStatus("Pr43Ty1", 1);
        assertEquals(1, result);
    }

    /**
     * Test of checkExistColor method, of class ProductTypeDAO.
     */
    @Test
    public void testCheckExistColor() {
        System.out.println("checkExistColor");
        String color = "Black";
        ProductTypeDAO instance = new ProductTypeDAO();
        boolean result = instance.checkExistColor(color);
        assertEquals(true, result);
    }

    @Test
    public void testCheckNonExistColor() {
        System.out.println("checkExistColor");
        String color = "Bronze";
        ProductTypeDAO instance = new ProductTypeDAO();
        boolean result = instance.checkExistColor(color);
        assertEquals(false, result);
    }

    /**
     * Test of checkExistSizeAndColor method, of class ProductTypeDAO.
     */
    @Test
    public void testCheckExistSizeAndColor() {
        System.out.println("checkExistSizeAndColor");
        String size = "256GB";
        String color = "Blue";
        int productId = 30;
        ProductTypeDAO instance = new ProductTypeDAO();
        boolean result = instance.checkExistSizeAndColor(size, color, productId);
        assertEquals(true, result);
    }

    @Test
    public void testCheckNonExistSizeAndColor() {
        System.out.println("checkExistSizeAndColor");
        String size = "128GB";
        String color = "Blue";
        int productId = 30;
        ProductTypeDAO instance = new ProductTypeDAO();
        boolean result = instance.checkExistSizeAndColor(size, color, productId);
        assertEquals(false, result);
    }

    /**
     * Test of getPageNumber method, of class ProductTypeDAO.
     */
    @Test
    public void testGetPageNumber() {
        System.out.println("getPageNumber");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.getPageNumber("Black", "13");
        assertEquals(2, result);
    }

    @Test
    public void testGetPageNumberWrong() {
        System.out.println("getPageNumber");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.getPageNumber("Black", "13");
        assertNotEquals(1, result);
    }

    @Test
    public void testGetPageNumberNotExist() {
        System.out.println("getPageNumber");
        ProductTypeDAO instance = new ProductTypeDAO();
        int result = instance.getPageNumber("Black", "100");
        assertEquals(0, result);
    }

    /**
     * Test of getAllPagingProductType method, of class ProductTypeDAO.
     */
    @Test
    public void testGetAllPagingProductType() {
        System.out.println("getAllPagingProductType");
        ProductTypeDAO instance = new ProductTypeDAO();
        List<ProductType> result = instance.getAllPagingProductType(1, 10, "Black", "13");
        assertEquals(2, result.size());
    }
    
        @Test
    public void testGetAllPagingProductTypeWrong() {
        System.out.println("getAllPagingProductType");
        ProductTypeDAO instance = new ProductTypeDAO();
        List<ProductType> result = instance.getAllPagingProductType(1, 10, "Black", "13");
        assertNotEquals(100, result.size());
    }
    
    /**
     * Test of searchProduct method, of class ProductTypeDAO.
     */
    @Test
    public void testSearchProduct() {
        System.out.println("searchProduct");
        ProductTypeDAO instance = new ProductTypeDAO();
        List<ProductType> result = instance.searchProduct("laptop");
        assertEquals(0, result.size());
    }
    
    /**
     * Test of getProductPrice method, of class ProductTypeDAO.
     */
    @Test
    public void testGetProductPrice() {
        System.out.println("getProductPrice");
        ProductTypeDAO instance = new ProductTypeDAO();
        String result = instance.getProductPrice(0);
        assertEquals(null, result);
    }
}
