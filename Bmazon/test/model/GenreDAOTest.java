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
        assertEquals(expResult, result);
    }

    /**
     * Test of getGenresByCategoryId method, of class GenreDAO.
     */
    @Test
    public void testGetGenresByCategoryId() {
        System.out.println("getGenresByCategoryId");
        int categoryId = 0;
        GenreDAO instance = new GenreDAO();
        ArrayList<Genre> expResult = null;
        ArrayList<Genre> result = instance.getGenresByCategoryId(categoryId);
        assertEquals(expResult, result);
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
        assertEquals(expResult, result);
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
        assertEquals(expResult, result);
    }

    /**
     * Test of insertGenre method, of class GenreDAO.
     */
    @Test
    public void testInsertGenre() {
        System.out.println("insertGenre");
        Genre gen = null;
        GenreDAO instance = new GenreDAO();
        instance.insertGenre(gen);
    }

    /**
     * Test of updateGenre method, of class GenreDAO.
     */
    @Test
    public void testUpdateGenre() {
        System.out.println("updateGenre");
        Genre gen = null;
        GenreDAO instance = new GenreDAO();
        instance.updateGenre(gen);
    }

    /**
     * Test of getGenreById method, of class GenreDAO.
     */
    @Test
    public void testGetGenreById() {
        System.out.println("getGenreById");
        int gId = 0;
        GenreDAO instance = new GenreDAO();
        Genre expResult = null;
        Genre result = instance.getGenreById(gId);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeStatus method, of class GenreDAO.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("changeStatus");
        int id = 0;
        int status = 0;
        GenreDAO instance = new GenreDAO();
        int expResult = 0;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeGenre method, of class GenreDAO.
     */
    @Test
    public void testRemoveGenre() {
        System.out.println("removeGenre");
        int id = 0;
        GenreDAO instance = new GenreDAO();
        int expResult = 0;
        int result = instance.removeGenre(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkExistGenreName method, of class GenreDAO.
     */
    @Test
    public void testCheckExistGenreName() {
        System.out.println("checkExistGenreName");
        String genreName = "";
        GenreDAO instance = new GenreDAO();
        boolean expResult = false;
        boolean result = instance.checkExistGenreName(genreName);
        assertEquals(expResult, result);
    }
    
}
