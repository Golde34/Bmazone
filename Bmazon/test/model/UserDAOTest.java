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
     * Test of addUser method, of class UserDAO.
     */
    /**
     * Test of addUser method, of class UserDAO.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        UserDAO dao = new UserDAO();
        assertEquals(1, dao.addUser(new User("H", "123456", "asf@gmail.com", "0988907272", 1, 100, "Nguyen Viet", "Public name", "GIa Loc", "image.jpg", "lol.jpg", "SE", 1, "okok", "fb", "ins", "fe", "yt", 1, 1, 1)));
    }

    @Test
    public void testAddUserWithNegativeID() {
        System.out.println("addUser");
        UserDAO dao = new UserDAO();
        assertEquals(1, dao.addUser(new User("-1", "H", "123456", "asf@gmail.com", "0988907272", 1, 100, "Nguyen Viet", "Public name", "GIa Loc", "image.jpg", "lol.jpg", "SE", 1, Date.valueOf("2001-04-03"), "okok", "fb", "ins", "fe", "yt", 1, 1, 1)));
    }

    @Test
    public void testAddUserWithUsernameNull() {
        System.out.println("addUser");
        UserDAO dao = new UserDAO();
        assertEquals(0, dao.addUser(new User(null, "123456", "askdf@gmail.com", "0988907272", 1, 100, "Nguyen Viet", "Public name", "GIa Loc", "image.jpg", "lol.jpg", "SE", 1, "okok", "fb", "ins", "fe", "yt", 1, 1, 1)));
    }

    @Test
    public void testAddUserWithPasswordNull() {
        System.out.println("addUser");
        UserDAO dao = new UserDAO();
        assertEquals(0, dao.addUser(new User("K", null, "asf@gmail.com", "0988907272", 1, 100, "Nguyen Viet", "Public name", "GIa Loc", "image.jpg", "lol.jpg", "SE", 1, "okok", "fb", "ins", "fe", "yt", 1, 1, 1)));
    }

    /**
     * Test of changePassword method, of class UserDAO.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.changePassword("G", "1000:5b39302c202d33302c202d32312c2035362c20322c2037342c20352c2038322c203132352c202d32322c2034302c2032312c202d32332c202d362c203130392c2034345d:f451937c010302b161bbdfe6e00a4227cddd945181807b3d"));
    }

    @Test
    public void testChangePasswordWithUsernameNotExist() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.changePassword("", ""));
        assertEquals(0, instance.changePassword("A", "123456"));
    }

    @Test
    public void testChangePasswordWithUsernameNull() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.changePassword(null, "123456"));

    }

    @Test
    public void testChangePasswordWithPasswordNull() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.changePassword("G", null));
    }

    /**
     * Test of changeStatus method, of class UserDAO.
     */
    @Test
    public void testChangeStatusWithUsername() {
        System.out.println("changeStatus");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.changeStatus("G", 1));
    }

    @Test
    public void testChangeStatusWithUsernameNotExist() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.changeStatus("", 1));
        assertEquals(0, instance.changeStatus("A", 1));
    }

    @Test
    public void testChangeStatusWithUsernameNull() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.changeStatus(null, 1));

    }

    @Test
    public void testChangeStatusWithNegativeStatus() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.changeStatus("Golde", -1));
    }

    /**
     * Test of changeStatus method, of class UserDAO.
     */
    @Test
    public void testChangeStatusWithID() {
        System.out.println("changeStatus");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.changeStatus(102, 1));
    }

    @Test
    public void testChangeStatusWithIDNotExist() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.changeStatus(-1, 1));
        assertEquals(0, instance.changeStatus(0, 1));
    }

    @Test
    public void testChangeStatusIntWithNegativeStatus() {
        System.out.println("changePassword");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.changeStatus(102, -1));
    }

    /**
     * Test of checkExistUserName method, of class UserDAO.
     */
    @Test
    public void testCheckExistUserName() {
        System.out.println("checkExistUserName");
        UserDAO instance = new UserDAO();
        assertEquals(true, instance.checkExistUserName("G"));
    }

    @Test
    public void testCheckExistUserNameNull() {
        System.out.println("checkExistUserName");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistUserName(null));
    }

    @Test
    public void testCheckExistUserNameNotExist() {
        System.out.println("checkExistUserName");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistUserName(""));
    }

    /**
     * Test of checkExistPhone method, of class UserDAO.
     */
    @Test
    public void testCheckExistPhone() {
        System.out.println("checkExistPhone");
        UserDAO instance = new UserDAO();
        assertEquals(true, instance.checkExistPhone("0983586778"));
    }

    @Test
    public void testCheckExistPhoneNull() {
        System.out.println("checkExistPhone");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistPhone(null));
    }

    @Test
    public void testCheckExistPhoneNotExist() {
        System.out.println("checkExistPhone");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistPhone(""));
    }

    /**
     * Test of checkExistMail method, of class UserDAO.
     */
    @Test
    public void testCheckExistMail() {
        System.out.println("checkExistMail");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistMail("1@gmail.com"));
        assertEquals(true, instance.checkExistMail("viet@gmail.com"));
    }

    @Test
    public void testCheckExistMailNull() {
        System.out.println("checkExistMail");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistMail(null));
    }

    @Test
    public void testCheckExistMailNotNull() {
        System.out.println("checkExistMail");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistMail(""));
    }

    /**
     * Test of checkExistUserNameAndMail method, of class UserDAO.
     */
    @Test
    public void testCheckExistUserNameAndMail() {
        System.out.println("checkExistUserNameAndMail");
        UserDAO instance = new UserDAO();
        assertEquals(true, instance.checkExistUserNameAndMail("G", "asf@gmail.com"));
    }

    @Test
    public void testCheckExistUserNameNullAndMail() {
        System.out.println("checkExistUserNameAndMail");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistUserNameAndMail(null, "asf@gmail.com"));
    }

    @Test
    public void testCheckExistUserNameAndMailNull() {
        System.out.println("checkExistUserNameAndMail");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistUserNameAndMail("G", null));
    }

    @Test
    public void testCheckExistUserNameAndMailNotExist() {
        System.out.println("checkExistUserNameAndMail");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.checkExistUserNameAndMail("", ""));
    }

    /**
     * Test of getPageNumber method, of class UserDAO.
     */
    @Test
    public void testGetPageNumber() {
        System.out.println("getPageNumber");
        UserDAO instance = new UserDAO();
        int result = instance.getPageNumber("Nguyen Thu");
        assertEquals(1, result);
    }

    @Test
    public void testGetPageNumberNull() {
        System.out.println("getPageNumber");
        UserDAO instance = new UserDAO();
        int result = instance.getPageNumber(null);
        assertEquals(0, result);
    }

    /**
     * Test of getAllPagingUser method, of class UserDAO.
     */
    @Test
    public void testGetAllPagingUser() {
        System.out.println("getAllPagingUser");
        UserDAO instance = new UserDAO();
        assertEquals(5, instance.getAllPagingUser(1, 5, "").size());
        assertEquals(1, instance.getAllPagingUser(1, 5, "Nguyen Thu").size());
    }

    @Test
    public void testGetAllPagingUserNull() {
        System.out.println("getAllPagingUser");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.getAllPagingUser(1, 5, null).size());
    }

    /**
     * Test of getUserByUsername method, of class UserDAO.
     */
    @Test
    public void testGetUserByUsername() {
        System.out.println("getUserByUsername");
        UserDAO instance = new UserDAO();
        assertNotNull(instance.getUserByUsername("Thao"));
    }

    @Test
    public void testGetUserByUsernameNull() {
        System.out.println("getUserByUsername");
        UserDAO instance = new UserDAO();
        assertNull(instance.getUserByUsername(null));
    }

    /**
     * Test of getUserById method, of class UserDAO.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        UserDAO instance = new UserDAO();
        assertNotNull(instance.getUserById("1"));
    }

    @Test
    public void testGetUserByIdNull() {
        System.out.println("getUserById");
        UserDAO instance = new UserDAO();
        assertNull(instance.getUserById(""));
    }

    /**
     * Test of getUserBySellerId method, of class UserDAO.
     */
    @Test
    public void testGetUserBySellerId() {
        System.out.println("getUserBySellerId");
        SellerDAO selDAO = new SellerDAO();
        Seller s = selDAO.getSellerByUserID(1);
        UserDAO instance = new UserDAO();
        User result = instance.getUserBySellerId(s);
        assertNotNull(result);
    }

    /**
     * Test of getAllUser method, of class UserDAO.
     */
    @Test
    public void testGetAllUser() {
        System.out.println("getAllUser");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.getAllUser().isEmpty());
    }

    /**
     * Test of getSearchUser method, of class UserDAO.
     */
    @Test
    public void testGetSearchUser() {
        System.out.println("getSearchUser");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.getSearchUser(102, "G", 1).size());
    }

    @Test
    public void testGetSearchUserStatusNegative() {
        System.out.println("getSearchUser");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.getSearchUser(102, "G", -1).size());
    }

    @Test
    public void testGetSearchUserWithUserIDEquals0() {
        System.out.println("getSearchUser");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.getSearchUser(0, "Thao", 1).size());
    }

    @Test
    public void testGetSearchUserNotExist() {
        System.out.println("getSearchUser");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.getSearchUser(0, null, 1).size());
    }

    /**
     * Test of getAllAuthorizationUser method, of class UserDAO.
     */
    @Test
    public void testGetAllAuthorizationUser() {
        System.out.println("getAllAuthorizationUser");
        UserDAO instance = new UserDAO();
        assertEquals(false, instance.getAllAuthorizationUser().isEmpty());
    }

    /**
     * Test of getAllPagingUserHashMap method, of class UserDAO.
     */
    @Test
    public void testGetAllPagingUserHashMap() {
        System.out.println("getAllPagingUserHashMap");
        UserDAO instance = new UserDAO();
        assertEquals(5, instance.getAllPagingUserHashMap(1, 5, "").size());
    }

    /**
     * Test of updatePassword method, of class UserDAO.
     */
    @Test
    public void testUpdatePassword() {
        System.out.println("updatePassword");
        UserDAO instance = new UserDAO();
        assertEquals(1, instance.updatePassword("G", "asf@gmail.com", "123456"));
    }

    @Test
    public void testUpdatePasswordWithUsernameNotExist() {
        System.out.println("updatePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.updatePassword("Gasdasd", "asf@gmail.com", "123456"));
    }

    @Test
    public void testUpdatePasswordWithEmailNotExist() {
        System.out.println("updatePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.updatePassword("G", "asfasdasd@gmail.com.vn", "123456"));
    }

    @Test
    public void testUpdatePasswordWithEmailNull() {
        System.out.println("updatePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.updatePassword("G", null, "123456"));
    }

    @Test
    public void testUpdatePasswordWithUsernameNull() {
        System.out.println("updatePassword");
        UserDAO instance = new UserDAO();
        assertEquals(0, instance.updatePassword(null, "asf@gmail.com", "123456"));
    }

    /**
     * Test of updateInfoUserByAdmin method, of class UserDAO.
     */
    @Test
    public void testUpdateInfoUserByAdmin() {
        System.out.println("updateInfoUserByAdmin");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        int result = instance.updateInfoUserByAdmin(obj);
        assertEquals(1, result);
    }

    /**
     * Test of depositWalletUser method, of class UserDAO.
     */
    @Test
    public void testDepositWalletUser() {
        System.out.println("depositWalletUser");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        assertEquals(1, instance.depositWalletUser(obj, 1000));
    }

    /**
     * Test of withdrawalWalletUser method, of class UserDAO.
     */
    @Test
    public void testWithdrawalWalletUser() {
        System.out.println("withdrawalWalletUser");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        assertEquals(1, instance.withdrawalWalletUser(obj, 500));
    }

    /**
     * Test of updatePublicInfo method, of class UserDAO.
     */
    @Test
    public void testUpdatePublicInfo() {
        System.out.println("updatePublicInfo");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        obj.setFacebook("okokokokokokok");
        assertEquals(1, instance.updatePublicInfo(obj));

    }

    /**
     * Test of updatePrivateInfo method, of class UserDAO.
     */
    @Test
    public void testUpdatePrivateInfo() {
        System.out.println("updatePrivateInfo");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        obj.setFullname("Dong Viet Dep Trai");
        assertEquals(1, instance.updatePrivateInfo(obj));
    }

    @Test
    public void testUpdatePrivateInfoNullPassword() {
        System.out.println("updatePrivateInfo");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        obj.setPassword(null);
        assertEquals(0, instance.updatePrivateInfo(obj));
    }

    /**
     * Test of updateActivityPoint method, of class UserDAO.
     */
    @Test
    public void testUpdateActivityPoint() {
        System.out.println("updateActivityPoint");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        assertEquals(1, instance.updateActivityPoint(obj, 1200));
    }

    /**
     * Test of uploadprofileImage method, of class UserDAO.
     */
    @Test
    public void testUploadprofileImage() {
        System.out.println("uploadprofileImage");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        assertEquals(1, instance.uploadprofileImage(obj, "link profile image"));
    }

    /**
     * Test of uploadBackgroundImage method, of class UserDAO.
     */
    @Test
    public void testUploadBackgroundImage() {
        System.out.println("uploadBackgroundImage");
        UserDAO instance = new UserDAO();
        User obj = instance.getUserById("102");
        assertEquals(1, instance.uploadBackgroundImage(obj, "link background image"));
    }

    /**
     * Test of getUserLogin method, of class UserDAO.
     */
    @Test
    public void testGetUserlLogin() {
        System.out.println("getUserLogin");
        UserDAO instance = new UserDAO();
        assertNotNull(instance.getUserLogin("G", "123456"));
    }

    @Test
    public void testGetUserLoginWithUsernameNull() {
        System.out.println("getUserLogin");
        UserDAO instance = new UserDAO();
        assertNull(instance.getUserLogin(null, "123456"));
    }
    
    @Test
    public void testGetUserLoginWithPasswordNull() {
        System.out.println("getUserLogin");
        UserDAO instance = new UserDAO();
        assertNull(instance.getUserLogin("asf@gmail.com", null));
    }

    /**
     * Test of getEmailLogin method, of class UserDAO.
     */
    @Test
    public void testGetEmailLogin() {
        System.out.println("getEmailLogin");
        UserDAO instance = new UserDAO();
        assertNotNull(instance.getEmailLogin("asf@gmail.com", "123456"));
    }

    @Test
    public void testGetEmailLoginWithEmailNull() {
        System.out.println("getEmailLogin");
        UserDAO instance = new UserDAO();
        assertNull(instance.getEmailLogin(null, "123456"));
    }
    
    @Test
    public void testGetEmailLoginWithPasswordNull() {
        System.out.println("getEmailLogin");
        UserDAO instance = new UserDAO();
        assertNull(instance.getEmailLogin("asf@gmail.com", null));
    }

}
