/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
import java.sql.Date;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bacon
 */
public class ProductDAOTest {

    public ProductDAOTest() {
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
     * Test of getPageNumber method, of class ProductDAO.
     */
    @Test
    public void testGetPageNotNull() {
        System.out.println("getPageNumber Where search= ");
        ProductDAO instance = new ProductDAO();
       
        assertEquals(7, instance.getPageNumber("iphone"));

    }

    @Test
    public void testGetPageNull() {
        System.out.println("getPageNumber Where search=i");
        ProductDAO instance = new ProductDAO();
        assertEquals(0, instance.getPageNumber("aaaaaaaaaaaaaaaa"));
       

    }

    /**
     * Test of getPageNumberBySeller method, of class ProductDAO.
     */
    @Test
    public void testGetPageNumberBySellerNotNull() {
        System.out.println("getPageNumberBySeller");
        ProductDAO instance = new ProductDAO();
        assertEquals(12, instance.getPageNumberBySeller("", 1));

    }

    @Test
    public void testGetPageNumberBySellerNull() {
        System.out.println("getPageNumberBySeller");
        ProductDAO instance = new ProductDAO();
        assertEquals(0, instance.getPageNumberBySeller("", 0));
    }

    /**
     * Test of getAllPagingProduct method, of class ProductDAO.
     */
    @Test
    public void testGetAllPagingProductNotNull() {
        System.out.println("getAllPagingProduct");

        ProductDAO instance = new ProductDAO();

        assertNotNull(instance.getAllPagingProduct(1, 20, ""));

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetAllPagingProductNull() {
        System.out.println("getAllPagingProduct");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getAllPagingProduct(0, 20, ""));

    }

    /**
     * Test of getAllPagingProductBySeller method, of class ProductDAO.
     */
    @Test
    public void testGetAllPagingProductBySeller() {
        System.out.println("getAllPagingProductBySeller");

        ProductDAO instance = new ProductDAO();

        assertNotNull(instance.getAllPagingProductBySeller(1, 20, "", "1"));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllPagingProductBySellerNull() {
        System.out.println("getAllPagingProductBySeller");

        ProductDAO instance = new ProductDAO();

        assertEquals(0, instance.getAllPagingProductBySeller(1, 20, "", "0").size());
        assertEquals(0, instance.getAllPagingProductBySeller(0, 20, "", "1").size());

    }

    /**
     * Test of getAllProduct method, of class ProductDAO.
     */
    @Test
    public void testGetAllProduct() {
        System.out.println("getAllProduct");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getAllProduct());
    }

    /**
     * Test of getTrueProduct method, of class ProductDAO.
     */
    @Test
    public void testGetTrueProduct() {
        System.out.println("getTrueProduct");
        int index = 1;
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getTrueProduct(index));
    }

    @Test
    public void testGetTrueProductNull() {
        System.out.println("getTrueProduct");
        int index = 0;
        ProductDAO instance = new ProductDAO();
        assertEquals(0, instance.getTrueProduct(index).size());
    }

    /**
     * Test of getProductSale method, of class ProductDAO.
     */
    @Test
    public void testGetProductSale() {
        System.out.println("getProductSale");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getProductSale());
    }

    /**
     * Test of getProductNew method, of class ProductDAO.
     */
    @Test
    public void testGetProductNew() {
        System.out.println("getProductNew");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getProductNew());
    }

    /**
     * Test of getProductLatest method, of class ProductDAO.
     */
    @Test
    public void testGetProductLatest() {
        System.out.println("getProductLatest");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getProductLatest(1));
    }

    @Test
    public void testGetProductLastestNull() {
        System.out.println("getProductLatest");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getProductLatest(0));
    }

    /**
     * Test of getProductApple method, of class ProductDAO.
     */
    @Test
    public void testGetProductApple() {
        System.out.println("getProductApple");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getProductApple());
    }

    /**
     * Test of getProductGear method, of class ProductDAO.
     */
    @Test
    public void testGetProductGear() {
        System.out.println("getProductGear");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getProductGear());

    }
     @Test
    public void testgetNewProductSeller() {
        System.out.println("getProductGear");
        ProductDAO instance = new ProductDAO();
        assertEquals(6,instance.getNewProductSeller("1").size());

    }
      @Test
    public void testgetNewProductSellerNull() {
        System.out.println("getProductGear");
        ProductDAO instance = new ProductDAO();
        assertEquals(0,instance.getNewProductSeller("0").size());

    }
    @Test
    public void testgetProductGear() {
        System.out.println("getProductGear");
        ProductDAO instance = new ProductDAO();
        assertEquals(8,instance.getProductGear().size());

    }
    @Test
    public void testGetTrueProductPaging() {
        System.out.println("getTrueProductPaging");
        ProductDAO instance = new ProductDAO();
        assertEquals(20,instance.getTrueProductPaging(1, 20).size());
        // TODO review the generated test code and remove the default call to fail.

    }
     @Test
    public void testGetTrueProductPagingNull() {
        System.out.println("getTrueProductPaging");
        ProductDAO instance = new ProductDAO();
        assertEquals(0,instance.getTrueProductPaging(-10, 0).size());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductBySellerPaging method, of class ProductDAO.
     */
    @Test
    public void testGetProductBySellerPaging() {
        System.out.println("getProductBySellerPaging");
        ProductDAO instance = new ProductDAO();
        assertNotNull(instance.getProductBySellerPaging(1, "1"));
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetProductBySellerPagingNotNull() {
        System.out.println("getProductBySellerPaging");
        ProductDAO instance = new ProductDAO();
        assertEquals(0,instance.getProductBySellerPaging(10, "0").size());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductBySeller method, of class ProductDAO.
     */
    @Test
    public void testGetProductBySeller() {
        System.out.println("getProductBySeller");
        String seller = "1";
        ProductDAO instance = new ProductDAO();
        int expResult = 12;
        ArrayList<Product> result = instance.getProductBySeller(seller);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetProductBySellerNull() {
        System.out.println("getProductBySeller");
        String seller = "0";
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        ArrayList<Product> result = instance.getProductBySeller(seller);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of searchProduct method, of class ProductDAO.
     */
    /**
     * Test of getProductSuggest method, of class ProductDAO.
     */
    @Test
    public void testGetProductSuggest() {
        System.out.println("getProductSuggest");
        ProductDAO instance = new ProductDAO();
        int expResult = 16;
        ArrayList<Product> result = instance.getProductSuggest();
        assertEquals(expResult, result.size());

    }

    /**
     * Test of main method, of class ProductDAO.
     */
    /**
     * Test of totalProductSeller method, of class ProductDAO.
     */
    @Test
    public void testTotalProductSeller() {
        System.out.println("totalProductSeller");
        String sid = "1";
        ProductDAO instance = new ProductDAO();
        int expResult = 12;
        int result = instance.totalProductSeller(sid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testTotalProductSellerNull() {
        System.out.println("totalProductSeller");
        String sid = "0";
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        int result = instance.totalProductSeller(sid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of totalRelatedProduct method, of class ProductDAO.
     */
    @Test
    public void testTotalRelatedProduct() {
        System.out.println("totalRelatedProduct");
        int id = 1;
        ProductDAO instance = new ProductDAO();
        int expResult = 12;
        int result = instance.totalRelatedProduct(id);
        assertEquals(expResult, result);

    }

    @Test
    public void testTotalRelatedProductNull() {
        System.out.println("totalRelatedProduct");
        int id = 0;
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        int result = instance.totalRelatedProduct(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of totalProduct method, of class ProductDAO.
     */
    @Test
    public void testTotalProduct() {
        System.out.println("totalProduct");
        ProductDAO instance = new ProductDAO();
        int expResult = 90;
        int result = instance.totalProduct();
        assertEquals(expResult, result);

    }

    /**
     * Test of totalSearchProduct method, of class ProductDAO.
     */
    @Test
    public void testTotalSearchProduct() {
        System.out.println("totalSearchProduct");
        String text = "";
        ProductDAO instance = new ProductDAO();
        int expResult = 90;
        int result = instance.totalSearchProduct(text);
        assertEquals(expResult, result);

    }
     @Test
    public void testTotalSearchProductNull() {
        System.out.println("totalSearchProduct");
        String text = "aaaaaaaaaaaaaaaaaaa";
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        int result = instance.totalSearchProduct(text);
        assertEquals(expResult, result);

    }

    /**
     * Test of getProductByName method, of class ProductDAO.
     */
    @Test
    public void testGetProductByName() {
        System.out.println("getProductByName");
        int index = 1;
        String name = "";
        ProductDAO instance = new ProductDAO();
        int expResult = 20;
        ArrayList<Product> result = instance.getProductByName(index, name);
        assertEquals(expResult, result.size());
        ArrayList<Product> result2 = instance.getProductByName(1, "apple");
        assertEquals(7, result2.size());

    }
     @Test
    public void testGetProductByNameNull() {
        System.out.println("getProductByName");
        int index = 1;
        String name = "";
        ProductDAO instance = new ProductDAO();    
        ArrayList<Product> result2 = instance.getProductByName(0, "apple");
        assertEquals(0, result2.size());

    }

    /**
     * Test of getProductByFilter method, of class ProductDAO.
     */
    @Test
    public void testgetProductByFilter() {
        System.out.println("getProductByFilter");
       
        ProductDAO instance = new ProductDAO();
        int expResult = 8;
        ArrayList<Product> result = instance.getProductByFilter(1, "", "And( pc.categoryId=1 )");
        assertEquals(expResult, result.size());
      

    }
     @Test
    public void testgetProductByFilterNUll() {
        System.out.println("getProductByFilter");
       
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        ArrayList<Product> result = instance.getProductByFilter(1, "", "And( pc.categoryId=0 )");
        assertEquals(expResult, result.size());
      

    }
    /**
     * Test of getProductByID method, of class ProductDAO.
     */
    @Test
    public void testGetProductByID() {
        System.out.println("getProductByID");
        int id = 1;
        ProductDAO instance = new ProductDAO();
        Product expResult = new Product(1, "Laptop Gaming MSI Katana GF66 11UC 676VN", "Up to 40% more performance than the previous generation. More powerful than ever with an 8-core processor, dual-core turbo clock up to 4.6GHz helps maximize performance in handling games, business software and multitasking.", 9, Date.valueOf("2021-09-12"), 1, 1);
        Product result = instance.getProductByID(id);
        System.out.println(result.getReleaseDate());
        System.out.println(expResult.getReleaseDate());
        assertEquals(true, result.getDescription().equals(expResult.getDescription()));

    }
    @Test
    public void testGetProductByIDFalse() {
        System.out.println("getProductByID");
        int id = 1;
        ProductDAO instance = new ProductDAO();
        Product expResult = new Product(1, "Laptop Gaming MSI Katana GF66 11UC 676VN", "Up to 40% more pe8-core6GHz helps maximize performance in handling games, business software and multitasking.", 9, Date.valueOf("2021-09-12"), 1, 1);
        Product result = instance.getProductByID(id);
        System.out.println(result.getReleaseDate());
        System.out.println(expResult.getReleaseDate());
        assertEquals(false, result.getDescription().equals(expResult.getDescription()));

    }

    /**
     * Test of getProductByCategory method, of class ProductDAO.
     */
    @Test
    public void testGetProductByCategory() {
        System.out.println("getProductByCategory");
        int categoryID = 1;
        ProductDAO instance = new ProductDAO();
        int expResult = 8;
        ArrayList<Product> result = instance.getProductByCategory(categoryID);
        assertEquals(expResult, result.size());

    }

    @Test
    public void testGetProductByCategoryNull() {
        System.out.println("getProductByCategory");
        int categoryID = 0;
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        ArrayList<Product> result = instance.getProductByCategory(categoryID);
        assertEquals(expResult, result.size());

    }

    /**
     * Test of getProductByGenre method, of class ProductDAO.
     */
    @Test
    public void testGetProductByGenre() {
        System.out.println("getProductByGenre");
        int genreID = 1;
        ProductDAO instance = new ProductDAO();
        int expResult = 8;
        ArrayList<Product> result = instance.getProductByGenre(genreID);
        assertEquals(expResult, result.size());

    }

    @Test
    public void testGetProductByGenreNull() {
        System.out.println("getProductByGenre");
        int genreID = 0;
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        ArrayList<Product> result = instance.getProductByGenre(genreID);
        assertEquals(expResult, result.size());

    }

    /**
     * Test of getRelatedProductByProductID method, of class ProductDAO.
     */
    @Test
    public void testGetRelatedProductByProductID() {
        System.out.println("getRelatedProductByProductID");
        int id = 1;
        ProductDAO instance = new ProductDAO();
        int expResult = 12;
        ArrayList<Product> result = instance.getRelatedProductByProductID(id);
        assertEquals(expResult, result.size());

    }

    @Test
    public void testGetRelatedProductByProductIDNull() {
        System.out.println("getRelatedProductByProductID");
        int id = 0;
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        ArrayList<Product> result = instance.getRelatedProductByProductID(id);
        assertEquals(expResult, result.size());

    }

    /**
     * Test of getRelatedProductByProductIDPaging method, of class ProductDAO.
     */
    @Test
    public void testGetRelatedProductByProductIDPaging() {
        System.out.println("getRelatedProductByProductIDPaging");
        int index = 1;
        int id = 1;
        ProductDAO instance = new ProductDAO();
        int expResult = 10;
        ArrayList<Product> result = instance.getRelatedProductByProductIDPaging(index, id);
        assertEquals(expResult, result.size());

    }

    @Test
    public void testGetRelatedProductByProductIDPagingNull() {
        System.out.println("getRelatedProductByProductIDPaging");
        int index = 1;
        int id = 0;
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        ArrayList<Product> result = instance.getRelatedProductByProductIDPaging(index, id);
        assertEquals(expResult, result.size());
        assertEquals(0, instance.getRelatedProductByProductIDPaging(0, 1).size());

    }

    /**
     * Test of addProduct method, of class ProductDAO.
     */
    /**
     * Test of updateProduct method, of class ProductDAO.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        Product obj = new Product(1, "Laptop Gaming MSI Katana GF66 11UC 676VN", "Up to 40% more performance than the previous generation. More powerful than ever with an 8-core processor, dual-core turbo clock up to 4.6GHz helps maximize performance in handling games, business software and multitasking.", 9, Date.valueOf("2021-09-12"), 1, 1);
        ProductDAO instance = new ProductDAO();
        int expResult = 1;
        int result = instance.updateProduct(obj);
        assertEquals(expResult, result);
        
    }


    @Test
    public void testChangeStatus() {
        System.out.println("changeStatus");
        int id = 1;
        int status = 1;
        ProductDAO instance = new ProductDAO();
        int expResult = 1;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
      
    }

}
