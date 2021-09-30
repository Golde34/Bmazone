/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class UserDAO extends BaseDAO {
    
    BaseDAO dbConn = new BaseDAO();

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User user = dao.getUserByProductId(2);
        System.out.println(user.getFullname());
    }
    

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

    public void singup(String user, String pass, String email, String phone, String fname) {
        String sql = "INSERT INTO [User]([username],[password],[email],[phoneNumber],[fullname],[systemRole],[status])\n"
                + "     VALUES	(?,?,?,?,?,0,1)";

        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, pass);
            pre.setString(3, email);
            pre.setString(4, phone);
            pre.setString(5, fname);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int addUser(User obj) {
        int n = 0;
        String sql = "INSERT INTO [User](username, password, email, phoneNumber, sell, wallet, fullname, publicName, address,"
                + " profileImage, backgroundImage, occupation, gender, DOB, bio, Facebook, Instagram, Twitter, Youtube,"
                + " activityPoint, systemRole, status)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

    public int changePassword(String username, String newPass) {
        try {
            String sqlUpdate = "update [User] set password = ? where username = ?";
            PreparedStatement preStm = conn.prepareStatement(sqlUpdate);
            preStm.setString(1, newPass);
            preStm.setString(2, username);
            int n = preStm.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int changeStatus(String username, int status) {
        int n = 0;
        String sql = "UPDATE [User] SET status = " + (status == 1 ? 1 : 0)
                + " WHERE username = '" + username + "'";
        try {
            pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "UPDATE [User] SET status = " + (status == 1 ? 1 : 0)
                + " WHERE userID = '" + id + "'";
        try {
            pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int removeCustomer(int id) {
        int n = 0;
        String sql = "SELECT * FROM ([User] AS a JOIN [Order] as b on a.userID = b.userID ) Join [Product] as c on a.userID=c.seller"
                + "WHERE a.userID = " + id;
        ResultSet rs = dbConn.getData(sql);
        try {
            if (rs.next()) {
                n = changeStatus(rs.getInt("userID"), 0);
            } else {
                String sqlDelete = "DELETE FROM User WHERE userID = " + id;
                Statement state = conn.createStatement();
                n = state.executeUpdate(sqlDelete);
            }
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
        String sql = "SELECT * FROM [User] WHERE phoneNumber = '" + phone + "' and status = 1";
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
        String sql = "SELECT * FROM [User] WHERE email = '" + mail + "' and status = 1";
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

    public User getUserById(int id) {
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
    
    public User getUserByProductId(int id) {
        String sql = "select * from [User] u join Product p on u.userID = p.seller where p.productID="+id+"";
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
        String sql = "SELECT * FROM [User] where status=1";
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

    public ArrayList<User> getTrueUser() {
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

        String sql = "SELECT * FROM [User] WHERE status=1 and username like '%" + uName + "%' " + s1 + " " + s2;
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

    public void updateWalletUser(User obj, double amount) {

        String sql = "UPDATE [User] SET wallet=? where userID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setDouble(1, obj.getWallet() + amount);
            pre.setString(2, obj.getUserId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePublicInfo(User obj) {
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
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePrivateInfo(User obj) {
        String sql = "UPDATE [User] SET  fullname=?, email=?, phoneNumber=?, [password]=?"
                + " where userID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getFullname());
            pre.setString(2, obj.getEmail());
            pre.setString(3, obj.getPhoneNumber());
            pre.setString(4, obj.getPassword());
            pre.setString(5, obj.getUserId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String sql = "UPDATE [User] SET profileImage = '" + uploadImg + "' WHERE userID = " + obj.getUserId();
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int uploadBackgroundImage(User obj, String uploadImg) {
        int n = 0;
        String sql = "UPDATE [User] SET backgroundImage = '" + uploadImg + "' WHERE userID = " + obj.getUserId();
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
