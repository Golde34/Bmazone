/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Role;
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
public class RoleDAOTest {
    
    public RoleDAOTest() {
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
     * Test of getPageNumber method, of class RoleDAO.
     */
    @Test
    public void testGetPageNumber() {
        System.out.println("getPageNumber");
        String search = "";
        RoleDAO instance = new RoleDAO();
        int expResult = 0;
        int result = instance.getPageNumber(search);
        assertNotSame(expResult, result);
    }

    /**
     * Test of getAllPagingRole method, of class RoleDAO.
     */
    @Test
    public void testGetAllPagingRole() {
        System.out.println("getAllPagingRole");
        int index = 1;
        int numOfRow = 5;
        String search = "";
        RoleDAO instance = new RoleDAO();
        List<Role> result = instance.getAllPagingRole(index, numOfRow, search);
        assertNotNull(result);
    }

    /**
     * Test of addRole method, of class RoleDAO.
     */
    @Test
    public void testAddRole() {
        System.out.println("addRole");
        Role r = new Role();
        r.setRoleID(99);
        r.setRoleName("Test add");
        r.setAdminPermission(0);
        r.setSellerPermission(0);
        r.setCustomerPermission(1);
        r.setStatus(1);
        RoleDAO instance = new RoleDAO();
        assertEquals(1, instance.addRole(r));
    }

    /**
     * Test of changeStatus method, of class RoleDAO.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("testChangeStatusWithRoleID");
        RoleDAO instance = new RoleDAO();
        assertEquals(1, instance.changeStatus(99, 0));
    }

    /**
     * Test of editRole method, of class RoleDAO.
     */
    @Test
    public void testEditRole() {
        System.out.println("editRole");
        Role r = new Role();
        r.setRoleID(99);
        r.setRoleName("Test Case in id 99");
        r.setAdminPermission(0);
        r.setSellerPermission(0);
        r.setCustomerPermission(0);
        r.setStatus(1);
        RoleDAO instance = new RoleDAO();
        assertEquals(1, instance.editRole(r));
    }

    /**
     * Test of checkExistRoleName method, of class RoleDAO.
     */
    @Test
    public void testCheckExistRoleName() {
        System.out.println("checkExistRoleName");
        String companyName = "Administrator";
        RoleDAO instance = new RoleDAO();
        boolean result = instance.checkExistRoleName(companyName);
        assertEquals(true, result);
    }

    /**
     * Test of checkExistRoleId method, of class RoleDAO.
     */
    @Test
    public void testCheckExistRoleId() {
        System.out.println("checkExistRoleId");
        int id = 99;
        RoleDAO instance = new RoleDAO();
        boolean result = instance.checkExistRoleId(id);
        assertEquals(true, result);
    }

    /**
     * Test of getRoleId method, of class RoleDAO.
     */
    @Test
    public void testGetRoleId() {
        System.out.println("getRoleById");
        int id = 99;
        RoleDAO instance = new RoleDAO();
        Role expResult = null;
        Role result = instance.getRoleId(id);
        assertNotNull(result.getRoleName());
    }

    /**
     * Test of getAllRole method, of class RoleDAO.
     */
    @Test
    public void testGetAllRole() {
        System.out.println("getAllRole");
        RoleDAO instance = new RoleDAO();
        List<Role> result = instance.getAllRole();
        assertNotNull(result);
    }

    /**
     * Test of searchRole method, of class RoleDAO.
     */
    @Test
    public void testSearchRole() {
        System.out.println("searchRole");
        String text = "admin";
        RoleDAO instance = new RoleDAO();
        List<Role> result = instance.searchRole(text);
        assertNotNull(result);
    }
}
