/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Role;
import entity.Seller;
import entity.User;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
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
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        UserDAO uDao = new UserDAO();
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
     * Test of addUserRegister method, of class UserDAO.
     */
    @Test
    public void testAddUserRegister() {
        System.out.println("addUserRegister");
        UserDAO dao = new UserDAO();
        assertEquals(0, dao.addUserRegister(new User(null, "123456", "askdf@gmail.com", "0988907272", 1, 100, "Nguyen Viet", "Public name", "GIa Loc", "image.jpg", "lol.jpg", "SE", 1, "okok", "fb", "ins", "fe", "yt", 1, 1, 1)));
        assertEquals(0, dao.addUserRegister(new User("Khanh", null, "asf@gmail.com", "0988907272", 1, 100, "Nguyen Viet", "Public name", "GIa Loc", "image.jpg", "lol.jpg", "SE", 1, "okok", "fb", "ins", "fe", "yt", 1, 1, 1)));
        
    }

    /**
     * Test of addUser method, of class UserDAO.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User obj = null;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.addUser(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class UserDAO.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String username = "";
        String newPass = "";
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.changePassword(username, newPass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeStatus method, of class UserDAO.
     */
    @Test
    public void testChangeStatus_String_int() {
        System.out.println("changeStatus");
        String username = "";
        int status = 0;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.changeStatus(username, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeStatus method, of class UserDAO.
     */
    @Test
    public void testChangeStatus_int_int() {
        System.out.println("changeStatus");
        int id = 0;
        int status = 0;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.changeStatus(id, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class UserDAO.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        int id = 0;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.removeUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkExistUserName method, of class UserDAO.
     */
    @Test
    public void testCheckExistUserName() {
        System.out.println("checkExistUserName");
        String username = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.checkExistUserName(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkExistPhone method, of class UserDAO.
     */
    @Test
    public void testCheckExistPhone() {
        System.out.println("checkExistPhone");
        String phone = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.checkExistPhone(phone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkExistMail method, of class UserDAO.
     */
    @Test
    public void testCheckExistMail() {
        System.out.println("checkExistMail");
        String mail = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.checkExistMail(mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkExistUserNameAndMail method, of class UserDAO.
     */
    @Test
    public void testCheckExistUserNameAndMail() {
        System.out.println("checkExistUserNameAndMail");
        String username = "";
        String mail = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.checkExistUserNameAndMail(username, mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPageNumber method, of class UserDAO.
     */
    @Test
    public void testGetPageNumber() {
        System.out.println("getPageNumber");
        String search = "";
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.getPageNumber(search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPagingUser method, of class UserDAO.
     */
    @Test
    public void testGetAllPagingUser() {
        System.out.println("getAllPagingUser");
        int index = 0;
        int numOfRow = 0;
        String search = "";
        UserDAO instance = new UserDAO();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getAllPagingUser(index, numOfRow, search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByUsername method, of class UserDAO.
     */
    @Test
    public void testGetUserByUsername() {
        System.out.println("getUserByUsername");
        String username = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class UserDAO.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        String id = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserBySellerId method, of class UserDAO.
     */
    @Test
    public void testGetUserBySellerId() {
        System.out.println("getUserBySellerId");
        Seller s = null;
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUserBySellerId(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class UserDAO.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        UserDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUser method, of class UserDAO.
     */
    @Test
    public void testGetAllUser() {
        System.out.println("getAllUser");
        UserDAO instance = new UserDAO();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getAllUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrueUser method, of class UserDAO.
     */
    @Test
    public void testGetTrueUser() {
        System.out.println("getTrueUser");
        UserDAO instance = new UserDAO();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getTrueUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSearchUser method, of class UserDAO.
     */
    @Test
    public void testGetSearchUser() {
        System.out.println("getSearchUser");
        int uId = 0;
        String uName = "";
        int status = 0;
        UserDAO instance = new UserDAO();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getSearchUser(uId, uName, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAuthorizationUser method, of class UserDAO.
     */
    @Test
    public void testGetAllAuthorizationUser() {
        System.out.println("getAllAuthorizationUser");
        UserDAO instance = new UserDAO();
        HashMap<User, Role> expResult = null;
        HashMap<User, Role> result = instance.getAllAuthorizationUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePassword method, of class UserDAO.
     */
    @Test
    public void testUpdatePassword() {
        System.out.println("updatePassword");
        String username = "";
        String mail = "";
        String password = "";
        UserDAO instance = new UserDAO();
        instance.updatePassword(username, mail, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateInfoUserByAdmin method, of class UserDAO.
     */
    @Test
    public void testUpdateInfoUserByAdmin() {
        System.out.println("updateInfoUserByAdmin");
        User obj = null;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.updateInfoUserByAdmin(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of depositWalletUser method, of class UserDAO.
     */
    @Test
    public void testDepositWalletUser() {
        System.out.println("depositWalletUser");
        User obj = null;
        double amount = 0.0;
        UserDAO instance = new UserDAO();
        instance.depositWalletUser(obj, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdrawalWalletUser method, of class UserDAO.
     */
    @Test
    public void testWithdrawalWalletUser() {
        System.out.println("withdrawalWalletUser");
        User obj = null;
        double amount = 0.0;
        UserDAO instance = new UserDAO();
        instance.withdrawalWalletUser(obj, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePublicInfo method, of class UserDAO.
     */
    @Test
    public void testUpdatePublicInfo() {
        System.out.println("updatePublicInfo");
        User obj = null;
        UserDAO instance = new UserDAO();
        instance.updatePublicInfo(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePrivateInfo method, of class UserDAO.
     */
    @Test
    public void testUpdatePrivateInfo() {
        System.out.println("updatePrivateInfo");
        User obj = null;
        UserDAO instance = new UserDAO();
        instance.updatePrivateInfo(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateActivityPoint method, of class UserDAO.
     */
    @Test
    public void testUpdateActivityPoint() {
        System.out.println("updateActivityPoint");
        User obj = null;
        int activityPoint = 0;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.updateActivityPoint(obj, activityPoint);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uploadprofileImage method, of class UserDAO.
     */
    @Test
    public void testUploadprofileImage() {
        System.out.println("uploadprofileImage");
        User obj = null;
        String uploadImg = "";
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.uploadprofileImage(obj, uploadImg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uploadBackgroundImage method, of class UserDAO.
     */
    @Test
    public void testUploadBackgroundImage() {
        System.out.println("uploadBackgroundImage");
        User obj = null;
        String uploadImg = "";
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.uploadBackgroundImage(obj, uploadImg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPagingUserHashMap method, of class UserDAO.
     */
    @Test
    public void testGetAllPagingUserHashMap() {
        System.out.println("getAllPagingUserHashMap");
        int index = 0;
        int numOfRow = 0;
        String search = "";
        UserDAO instance = new UserDAO();
        HashMap<User, Role> expResult = null;
        HashMap<User, Role> result = instance.getAllPagingUserHashMap(index, numOfRow, search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserLogin method, of class UserDAO.
     */
    @Test
    public void testGetUserLogin() {
        System.out.println("getUserLogin");
        String username = "";
        String password = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUserLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailLogin method, of class UserDAO.
     */
    @Test
    public void testGetEmailLogin() {
        System.out.println("getEmailLogin");
        String email = "";
        String password = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getEmailLogin(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}