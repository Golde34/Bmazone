/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Genre;
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
public class GenreDAOTest {
    
    public GenreDAOTest() {
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
     * Test of getAllGenres method, of class GenreDAO.
     */
    @Test
    public void testGetAllGenres() {
        System.out.println("getAllGenres");
        GenreDAO instance = new GenreDAO();
        ArrayList<Genre> expResult = null;
        ArrayList<Genre> result = instance.getAllGenres();
        assertEquals(20, result.size());
    }

    /**
     * Test of getGenresByCategoryId method, of class GenreDAO.
     */
    @Test
    public void testGetGenresByFalseCategoryId() {
        System.out.println("getGenresByCategoryId");
        int categoryId = 0;
        GenreDAO instance = new GenreDAO();
        ArrayList<Genre> expResult = new ArrayList<>();
        ArrayList<Genre> result = instance.getGenresByCategoryId(categoryId);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetGenresByTrueCategoryId() {
        System.out.println("getGenresByCategoryId");
        int categoryId = 1;
        GenreDAO instance = new GenreDAO();
        ArrayList<Genre> expResult = null;
        ArrayList<Genre> result = instance.getGenresByCategoryId(categoryId);
        assertEquals(1, result.size());
    }

    /**
     * Test of getTrueGenres method, of class GenreDAO.
     */
    @Test
    public void testGetTrueGenres() {
        System.out.println("getTrueGenres");
        GenreDAO instance = new GenreDAO();
        ArrayList<Genre> expResult = null;
        ArrayList<Genre> result = instance.getTrueGenres();
        assertEquals(20, result.size());
    }

    /**
     * Test of getHomeGenre method, of class GenreDAO.
     */
    @Test
    public void testGetHomeGenre() {
        System.out.println("getHomeGenre");
        GenreDAO instance = new GenreDAO();
        ArrayList<Genre> expResult = null;
        ArrayList<Genre> result = instance.getHomeGenre();
        assertEquals(16, result.size());
    }

    /**
     * Test of insertGenre method, of class GenreDAO.
     */
    @Test
    public void testInsertFalseGenre() {
        System.out.println("insertGenre");
        Genre gen = new Genre();
        gen.setCategoryID(-1);
        gen.setGenreName("test");
        gen.setStatus(1);
        GenreDAO instance = new GenreDAO();
        assertEquals(0, instance.insertGenre(gen));
    }
    
    @Test
    public void testInsertTrueGenre() {
        System.out.println("insertGenre");
        Genre gen = new Genre();
        gen.setCategoryID(1);
        gen.setGenreName("test");
        gen.setStatus(1);
        GenreDAO instance = new GenreDAO();
        assertEquals(1, instance.insertGenre(gen));
    }

    /**
     * Test of updateGenre method, of class GenreDAO.
     */
    @Test
    public void testUpdateFalseGenre() {
        System.out.println("updateGenre");
        Genre gen = new Genre();
        gen.setGenreID(1);
        gen.setCategoryID(-1);
        gen.setGenreName("test");
        gen.setStatus(1);
        GenreDAO instance = new GenreDAO();
        assertEquals(0, instance.updateGenre(gen));
    }
    
    public void testUpdateTrueGenre() {
        System.out.println("updateGenre");
        Genre gen = new Genre();
        gen.setGenreID(1);
        gen.setCategoryID(1);
        gen.setGenreName("test");
        gen.setStatus(1);
        GenreDAO instance = new GenreDAO();
        assertEquals(1, instance.updateGenre(gen));
    }

    /**
     * Test of getGenreById method, of class GenreDAO.
     */
    @Test
    public void testGetGenreByFalseId() {
        System.out.println("getGenreById");
        int gId = 0;
        GenreDAO instance = new GenreDAO();
        Genre expResult = null;
        Genre result = instance.getGenreById(gId);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetGenreByTrueId() {
        System.out.println("getGenreById");
        int gId = 1;
        GenreDAO instance = new GenreDAO();
        Genre result = instance.getGenreById(gId);
        assertNotNull(result);
    }

    /**
     * Test of changeStatus method, of class GenreDAO.
     */
    @Test
    public void testChangeStatusFalseGenre() {
        System.out.println("changeStatus");
        int id = 0;
        int status = 0;
        GenreDAO instance = new GenreDAO();
        int expResult = 0;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testChangeStatusTrueGenre() {
        System.out.println("changeStatus");
        int id = 1;
        int status = 0;
        GenreDAO instance = new GenreDAO();
        int expResult = 1;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeGenre method, of class GenreDAO.
     */
    @Test
    public void testRemoveFalseGenre() {
        System.out.println("removeGenre");
        int id = 0;
        GenreDAO instance = new GenreDAO();
        int expResult = 0;
        int result = instance.removeGenre(id);
        assertEquals(expResult, result);
    }
    @Test
    public void testRemoveTrueGenre() {
        System.out.println("removeGenre");
        int id = 1;
        GenreDAO instance = new GenreDAO();
        int expResult = 1;
        int result = instance.removeGenre(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkExistGenreName method, of class GenreDAO.
     */
    @Test
    public void testCheckExistGenreName() {
        System.out.println("checkExistGenreName");
        String genreName = "IOS";
        GenreDAO instance = new GenreDAO();
        boolean expResult = true;
        boolean result = instance.checkExistGenreName(genreName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNotExistGenreName() {
        System.out.println("checkExistGenreName");
        String genreName = "hihi";
        GenreDAO instance = new GenreDAO();
        boolean expResult = false;
        boolean result = instance.checkExistGenreName(genreName);
        assertEquals(expResult, result);
    }
    
}
