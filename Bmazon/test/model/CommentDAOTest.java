/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Comment;
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
 * @author DELL
 */
public class CommentDAOTest {
    
    public CommentDAOTest() {
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
     * Test of getPageNumber method, of class CommentDAO.
     */
    @Test
    public void testGetPageNumber() {
        System.out.println("getPageNumber");
        String search = "";
        CommentDAO instance = new CommentDAO();
        int expResult = 0;
        int pid = 1;
        int result = instance.getPageNumber(search,pid);
        assertNotSame(expResult, result);
    }
    
    @Test
    public void testGetPageNumberIdNotExist() {
        System.out.println("getPageNumber");
        String search = "";
        CommentDAO instance = new CommentDAO();
        int expResult = 0;
        int pid = -5;
        int result = instance.getPageNumber(search,pid);
        assertSame(expResult, result);
    }

    /**
     * Test of getAllPagingComment method, of class CommentDAO.
     */
    @Test
    public void testGetAllPagingComment() {
        System.out.println("getAllPagingComment");
        int index = 1;
        int numOfRow = 5;
        String search = "";
        CommentDAO instance = new CommentDAO();
        List<Comment> result = instance.getAllPagingComment(index, numOfRow, search);
        assertNotNull(result);
    }

    /**
     * Test of changeStatus method, of class CommentDAO.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("testChangeStatusWithCommentID");
        CommentDAO instance = new CommentDAO();
        int cid = 1;
        int expected = 1;
        assertEquals(expected, instance.changeStatus(cid, 1));
    }

    @Test
    public void testChangeStatusNotExistComment() {
        System.out.println("testChangeStatusWithCommentID");
        CommentDAO instance = new CommentDAO();
        int cid = -99;
        int expected = 0;
        assertEquals(expected, instance.changeStatus(cid, 1));
    }
    
    /**
     * Test of insertComment method, of class CommentDAO.
     */
    @Test
    public void testInsertComment() {
        System.out.println("addComment");
        Comment c = new Comment();
        c.setProductID(1);
        c.setUserID(1);
        c.setContent("Test add");
        c.setRating(4.3);
        c.setStatus(1);
        CommentDAO instance = new CommentDAO();
        int expected = 1;
        assertEquals(expected, instance.insertComment(c));
    }

    @Test
    public void testInsertCommentNullValue() {
        System.out.println("addComment");
        Comment c = new Comment();
//        c.setProductID(1);
//        c.setUserID(1);
//        c.setContent(null);
//        c.setRating(4.3);
//        c.setStatus(1);
        CommentDAO instance = new CommentDAO();
        int expected = 0;
        assertEquals(expected, instance.insertComment(c));
    }
    /**
     * Test of getCommentsByProductId method, of class CommentDAO.
     */
    @Test
    public void testGetCommentsByProductId() {
        System.out.println("getComment");
        CommentDAO instance = new CommentDAO();
        int pid = 1;
        List<Comment> result = instance.getCommentsByProductId(pid);
        assertNotNull(result);
    }
    
    @Test
    public void testGetCommentsByProductIdNotExist() {
        System.out.println("getComment");
        CommentDAO instance = new CommentDAO();
        int pid = -5;
        List<Comment> result = instance.getCommentsByProductId(pid);
        int expected = 0;
        assertEquals(expected, result.size());
    }

    /**
     * Test of checkExistComment method, of class CommentDAO.
     */
    @Test
    public void testCheckExistComment() {
        System.out.println("checkExistComment");
        CommentDAO instance = new CommentDAO();
        int cid = 1;
        int uid = 1;
        boolean result = instance.checkExistComment(cid, uid);
        assertEquals(true, result);
    }
    @Test
    public void testCheckExistCommentWithNotExistID() {
        System.out.println("checkExistComment");
        CommentDAO instance = new CommentDAO();
        int cid = -5;
        int uid = -1;
        boolean result = instance.checkExistComment(cid, uid);
        assertEquals(false, result);
    }
    
}
