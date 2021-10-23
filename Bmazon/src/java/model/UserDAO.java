/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Role;
import entity.Seller;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class UserDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();
    
    public int addUser(User obj) {
        int n = 0;
        String sql = "INSERT INTO [User](username, password, email, phoneNumber, sell, wallet, fullname, publicName, address,"
                + " profileImage, backgroundImage, occupation, gender, DOB, bio, Facebook, Instagram, Twitter, Youtube,"
                + " activityPoint, systemRole, status)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,GETDATE(),?,?,?,?,?,?,?,?)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getPassword());
            pre.setString(3, obj.getEmail());
            pre.setString(4, obj.getPhoneNumber());
            pre.setInt(5, obj.getSell());
            pre.setDouble(6, obj.getWallet());
            pre.setString(7, obj.getFullname());
            pre.setString(8, obj.getPublicName());
            pre.setString(9, obj.getAddress());
            pre.setString(10, obj.getProfileImage());
            pre.setString(11, obj.getBackgroundImage());
            pre.setString(12, obj.getOccupation());
            pre.setInt(13, obj.getGender());
            pre.setString(14, obj.getBio());
            pre.setString(15, obj.getFacebook());
            pre.setString(16, obj.getInstagram());
            pre.setString(17, obj.getTwitter());
            pre.setString(18, obj.getYoutube());
            pre.setInt(19, obj.getActivityPoint());
            pre.setInt(20, obj.getSystemRole());
            pre.setInt(21, obj.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int changePassword(String username, String newPass) {
        try {
            String sqlUpdate = "Update [User] set password = ? where username = ?";
            pre = conn.prepareStatement(sqlUpdate);
            pre.setString(1, newPass);
            pre.setString(2, username);
            int n = pre.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int changeStatus(String username, int status) {
        int n = 0;
        String sql = "UPDATE [User] SET status = ? WHERE username = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setString(2, username);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "UPDATE [User] SET status = ? WHERE userID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public boolean checkExistUserName(String username) {
        String sql = "SELECT * FROM [User] WHERE username = '" + username + "'";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkExistPhone(String phone) {
        String sql = "SELECT * FROM [User] WHERE phoneNumber = '" + phone + "'";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkExistMail(String mail) {
        String sql = "SELECT * FROM [User] WHERE email = '" + mail + "'";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkExistUserNameAndMail(String username, String mail) {
        String sql = "SELECT * FROM [User] WHERE username = '" + username + "' and email = '" + mail + "' and status = 1";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) FROM [Bmazon].[dbo].[User] where fullname like '%" + search + "%' or email like '%" + search + "%' or phoneNumber like '%" + search + "%' or address like '%" + search + "%'";
        ResultSet rs = dbConn.getData(xSql);
        try {
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }

    public ArrayList<User> getAllPagingUser(int index, int numOfRow, String search) {
        ArrayList<User> list = new ArrayList<>();
        String xSql = "declare @PageNo INT =" + index + "\n"
                + "declare @PageSize INT=" + numOfRow + "\n"
                + "SELECT * from(\n"
                + "SELECT *,\n"
                + "ROW_NUMBER() over (order by userID) as RowNum\n"
                + "  FROM [Bmazon].[dbo].[User] where fullname like '%" + search + "%' or email like '%" + search + "%' or phoneNumber like '%" + search + "%'\n"
                + "  or address like '%" + search + "%')T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        ResultSet rs = dbConn.getData(xSql);
        try {
            while (rs.next()) {
                User user = new User(rs.getString("userID"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getInt("sell"),
                        rs.getDouble("wallet"), rs.getString("fullname"),
                        rs.getString("publicName"), rs.getString("address"), rs.getString("profileImage"),
                        rs.getString("backgroundImage"), rs.getString("occupation"),
                        rs.getInt("gender"), rs.getDate("DOB"), rs.getString("bio"),
                        rs.getString("Facebook"), rs.getString("Instagram"),
                        rs.getString("Twitter"), rs.getString("Youtube"),
                        rs.getInt("activityPoint"), rs.getInt("systemRole"),
                        rs.getInt("status"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM [User] WHERE username = '" + username + "' and status=1";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                User user = new User(rs.getString("userID"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getInt("sell"),
                        rs.getDouble("wallet"), rs.getString("fullname"),
                        rs.getString("publicName"), rs.getString("address"), rs.getString("profileImage"),
                        rs.getString("backgroundImage"), rs.getString("occupation"),
                        rs.getInt("gender"), rs.getDate("DOB"), rs.getString("bio"),
                        rs.getString("Facebook"), rs.getString("Instagram"),
                        rs.getString("Twitter"), rs.getString("Youtube"),
                        rs.getInt("activityPoint"), rs.getInt("systemRole"),
                        rs.getInt("status"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUserById(String id) {
        String sql = "SELECT * FROM [User] WHERE userID = '" + id + "'";
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                User user = new User(rs.getString("userID"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getInt("sell"),
                        rs.getDouble("wallet"), rs.getString("fullname"),
                        rs.getString("publicName"), rs.getString("address"), rs.getString("profileImage"),
                        rs.getString("backgroundImage"), rs.getString("occupation"),
                        rs.getInt("gender"), rs.getDate("DOB"), rs.getString("bio"),
                        rs.getString("Facebook"), rs.getString("Instagram"),
                        rs.getString("Twitter"), rs.getString("Youtube"),
                        rs.getInt("activityPoint"), rs.getInt("systemRole"),
                        rs.getInt("status"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUserBySellerId(Seller s) {
        String sql = "select * from [User] WHERE userID = " + s.getUserID();
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                User user = new User(rs.getString("userID"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getInt("sell"),
                        rs.getDouble("wallet"), rs.getString("fullname"),
                        rs.getString("publicName"), rs.getString("address"), rs.getString("profileImage"),
                        rs.getString("backgroundImage"), rs.getString("occupation"),
                        rs.getInt("gender"), rs.getDate("DOB"), rs.getString("bio"),
                        rs.getString("Facebook"), rs.getString("Instagram"),
                        rs.getString("Twitter"), rs.getString("Youtube"),
                        rs.getInt("activityPoint"), rs.getInt("systemRole"),
                        rs.getInt("status"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT * FROM [User]";
        ResultSet rs = dbConn.getData(sql);
        try {
            while (rs.next()) {
                User user = new User(rs.getString("userID"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getInt("sell"),
                        rs.getDouble("wallet"), rs.getString("fullname"),
                        rs.getString("publicName"), rs.getString("address"), rs.getString("profileImage"),
                        rs.getString("backgroundImage"), rs.getString("occupation"),
                        rs.getInt("gender"), rs.getDate("DOB"), rs.getString("bio"),
                        rs.getString("Facebook"), rs.getString("Instagram"),
                        rs.getString("Twitter"), rs.getString("Youtube"),
                        rs.getInt("activityPoint"), rs.getInt("systemRole"),
                        rs.getInt("status"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<User> getSearchUser(int uId, String uName, int status) {
        ArrayList<User> list = new ArrayList<>();
        String s1 = " ";
        if (uId != 0) {
            s1 = " and userID = " + uId + " ";
        }

        String s2 = " ";
        if (status != -1) {
            s2 = " and status = " + status + " ";
        }

        String sql = "SELECT * FROM [User] WHERE status = 1 and username like '%" + uName + "%' " + s1 + " " + s2;
        ResultSet rs = dbConn.getData(sql);
        try {
            while (rs.next()) {
                User user = new User(rs.getString("userID"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getInt("sell"),
                        rs.getDouble("wallet"), rs.getString("fullname"),
                        rs.getString("publicName"), rs.getString("address"), rs.getString("profileImage"),
                        rs.getString("backgroundImage"), rs.getString("occupation"),
                        rs.getInt("gender"), rs.getDate("DOB"), rs.getString("bio"),
                        rs.getString("Facebook"), rs.getString("Instagram"),
                        rs.getString("Twitter"), rs.getString("Youtube"),
                        rs.getInt("activityPoint"), rs.getInt("systemRole"),
                        rs.getInt("status"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public HashMap<User, Role> getAllAuthorizationUser() {
        HashMap<User, Role> map = new HashMap<>();
        UserDAO uDao = new UserDAO();
        RoleDAO rDao = new RoleDAO();
        String sql = "SELECT u.userID, r.roleID FROM [User] u INNER JOIN [Role] r ON u.systemRole = r.roleID  where u.[status]=1";
        ResultSet rs = dbConn.getData(sql);
        try {
            while (rs.next()) {
                User u = uDao.getUserById(rs.getString("userID"));
                Role r = rDao.getRoleById(rs.getInt("roleID"));
                map.put(u, r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

    public HashMap<User, Role> getAllPagingUserHashMap(int index, int numOfRow, String search) {
        HashMap<User, Role> map = new HashMap<>();
        UserDAO uDao = new UserDAO();
        RoleDAO rDao = new RoleDAO();
        String xSql = "declare @PageNo INT =" + index + "\n"
                + "declare @PageSize INT=" + numOfRow + "\n"
                + "SELECT * from(\n"
                + "SELECT u.userID, r.roleID,\n"
                + "ROW_NUMBER() over (order by userID) as RowNum\n"
                + "  FROM [Bmazon].[dbo].[User] u INNER JOIN [Role] r ON u.systemRole = r.roleID where u.fullname like '%" + search + "%' or r.roleName like '%" + search + "%')T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        ResultSet rs = dbConn.getData(xSql);
        try {
            while (rs.next()) {
                User u = uDao.getUserById(rs.getString("userID"));
                Role r = rDao.getRoleById(rs.getInt("roleID"));
                map.put(u, r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public int updatePassword(String username, String mail, String password) {
        int n = 0;
        String sql = "UPDATE [User] SET password = ? WHERE username = ? and email = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, password);
            pre.setString(2, username);
            pre.setString(3, mail);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateInfoUserByAdmin(User obj) {
        int n = 0;
        String sql = "UPDATE [User] SET username=?, password=?, email=?, phoneNumber=?, sell=?, wallet=?, fullname=?, publicName=?, address=?,"
                + " profileImage=?, backgroundImage=?, occupation=?, gender=?, DOB=?, bio=?, Facebook=?, Instagram=?, Twitter=?, "
                + "Youtube=?, activityPoint=?, systemRole=?, status=?"
                + " where userID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getPassword());
            pre.setString(3, obj.getEmail());
            pre.setString(4, obj.getPhoneNumber());
            pre.setInt(5, obj.getSell());
            pre.setDouble(6, obj.getWallet());
            pre.setString(7, obj.getFullname());
            pre.setString(8, obj.getPublicName());
            pre.setString(9, obj.getAddress());
            pre.setString(10, obj.getProfileImage());
            pre.setString(11, obj.getBackgroundImage());
            pre.setString(12, obj.getOccupation());
            pre.setInt(13, obj.getGender());
            pre.setDate(14, obj.getDOB());
            pre.setString(15, obj.getBio());
            pre.setString(16, obj.getFacebook());
            pre.setString(17, obj.getInstagram());
            pre.setString(18, obj.getTwitter());
            pre.setString(19, obj.getYoutube());
            pre.setInt(20, obj.getActivityPoint());
            pre.setInt(21, obj.getSystemRole());
            pre.setInt(22, obj.getStatus());
            pre.setString(23, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int depositWalletUser(User obj, double amount) {
        int n = 0;
        String sql = "UPDATE [User] SET wallet=? where userID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setDouble(1, obj.getWallet() + amount);
            pre.setString(2, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int withdrawalWalletUser(User obj, double amount) {
        int n = 0;
        String sql = "UPDATE [User] SET wallet=? where userID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setDouble(1, obj.getWallet() - amount);
            pre.setString(2, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updatePublicInfo(User obj) {
        int n =0;
        String sql = "UPDATE [User] SET  username=?, [address]=?,"
                + " bio=?, Facebook=?, Instagram=?, Twitter=?, Youtube=? , [password]=?"
                + " where userID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getAddress());
            pre.setString(3, obj.getBio());
            pre.setString(4, obj.getFacebook());
            pre.setString(5, obj.getInstagram());
            pre.setString(6, obj.getTwitter());
            pre.setString(7, obj.getYoutube());
            pre.setString(8, obj.getPassword());
            pre.setString(9, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updatePrivateInfo(User obj) {
        int n = 0;
        String sql = "UPDATE [User] SET  fullname=?, email=?, phoneNumber=?, [password]=?"
                + " where userID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getFullname());
            pre.setString(2, obj.getEmail());
            pre.setString(3, obj.getPhoneNumber());
            pre.setString(4, obj.getPassword());
            pre.setString(5, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateActivityPoint(User obj, int activityPoint) {
        int n = 0;
        String sql = "UPDATE [User] SET activityPoint=? where userID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, activityPoint);
            pre.setString(2, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int uploadprofileImage(User obj, String uploadImg) {
        int n = 0;
        String sql = "UPDATE [User] SET profileImage = ? WHERE userID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, uploadImg);
            pre.setString(2, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int uploadBackgroundImage(User obj, String uploadImg) {
        int n = 0;
        String sql = "UPDATE [User] SET backgroundImage = ? WHERE userID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, uploadImg);
            pre.setString(2, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Didn't use. Click on the + sign on the left to edit the code.">
    public User getUserLogin(String username, String password) {
        String sql = "SELECT * FROM [User] WHERE username = ? and password = ? and status = 1";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("userID"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getInt("sell"),
                        rs.getDouble("wallet"), rs.getString("fullname"),
                        rs.getString("publicName"), rs.getString("address"), rs.getString("profileImage"),
                        rs.getString("backgroundImage"), rs.getString("occupation"),
                        rs.getInt("gender"), rs.getDate("DOB"), rs.getString("bio"),
                        rs.getString("Facebook"), rs.getString("Instagram"),
                        rs.getString("Twitter"), rs.getString("Youtube"),
                        rs.getInt("activityPoint"), rs.getInt("systemRole"),
                        rs.getInt("status"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getEmailLogin(String email, String password) {
        String sql = "SELECT * FROM [User] WHERE email = ? and password = ? and status = 1";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("userID"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("phoneNumber"), rs.getInt("sell"),
                        rs.getDouble("wallet"), rs.getString("fullname"),
                        rs.getString("publicName"), rs.getString("address"), rs.getString("profileImage"),
                        rs.getString("backgroundImage"), rs.getString("occupation"),
                        rs.getInt("gender"), rs.getDate("DOB"), rs.getString("bio"),
                        rs.getString("Facebook"), rs.getString("Instagram"),
                        rs.getString("Twitter"), rs.getString("Youtube"),
                        rs.getInt("activityPoint"), rs.getInt("systemRole"),
                        rs.getInt("status"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
// </editor-fold>
}
