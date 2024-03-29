/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Seller;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.nio.ch.SelChImpl;

/**
 *
 * @author Admin
 */
public class SellerDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public int addSeler(Seller s) {
        int n = 0;
        String xSql = "INSERT INTO Seller (userID, sellerShopName, sellerPhone, evidence, sellerMainProduct, description, sellerVerification, backGroundImage, avatar, status)"
                + "     VALUES (?,?,?,?,?,?,?,?,?,1)";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, s.getUserID());
            pre.setString(2, s.getSellerShopName());
            pre.setString(3, s.getSellerPhone());
            pre.setString(4, s.getEvidence());
            pre.setInt(5, s.getSellerMainProduct());
            pre.setString(6, s.getDescription());
            pre.setInt(7, s.getSellerVerification());
            pre.setString(8, s.getBackGroundImage());
            pre.setString(9, s.getAvatar());
            n = pre.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int editSeller(Seller s) {
        int n = 0;
        String xSql = "update Seller set userID = ? ,sellerShopName = ?, sellerPhone = ?, evidence = ?,"
                + "sellerMainProduct = ?, description = ?, sellerVerification = ?, backGroundImage = ?,"
                + "avatar = ?, status = ? where sellerID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, s.getUserID());
            pre.setString(2, s.getSellerShopName());
            pre.setString(3, s.getSellerPhone());
            pre.setString(4, s.getEvidence());
            pre.setInt(5, s.getSellerMainProduct());
            pre.setString(6, s.getDescription());
            pre.setInt(7, s.getSellerVerification());
            pre.setString(8, s.getBackGroundImage());
            pre.setString(9, s.getAvatar());
            pre.setInt(10, s.getStatus());
            pre.setInt(11, s.getSellerID());
            n = pre.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int updateSeller(Seller s) {
        int n = 0;
        String xSql = "update Seller set sellerShopName = ?, sellerPhone = ?, evidence = ?,"
                + "sellerMainProduct = ?, description = ?, status = ? where sellerID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, s.getSellerShopName());
            pre.setString(2, s.getSellerPhone());
            pre.setString(3, s.getEvidence());
            pre.setInt(4, s.getSellerMainProduct());
            pre.setString(5, s.getDescription());
            pre.setInt(6, s.getStatus());
            pre.setInt(7, s.getSellerID());
            n = pre.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int deleteSeller(int sellerID) {
        int n = 0;
        String sql = "delete from Seller where sellerID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sellerID);
            n = pre.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public boolean checkExistPhone(String phone) {
        boolean isExist = false;
        String sql = "SELECT * FROM Seller WHERE sellerPhone = '" + phone + "' and status = 1";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                isExist = true;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isExist;
    }

    public boolean checkExistUserID(int id) {
        boolean isExist = false;
        String sql = "SELECT * FROM Seller WHERE userID = " + id + " and status = 1";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                isExist = true;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isExist;
    }

    public boolean checkExistSellerShopName(String sellerShopName) {
        boolean isExist = false;
        String xSql = "SELECT * FROM Seller where sellerShopName like '" + sellerShopName + "'";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                isExist = true;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isExist;
    }

    public boolean checkExistSellerId(int id) {
        boolean isExist = false;
        String xSql = "SELECT * FROM Seller where sellerID = " + id;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                isExist = true;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isExist;
    }

    public Seller getSellerID(String id) {
        Seller seller = new Seller();
        String xSql = "select * from Seller where sellerID = " + id;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                seller.setSellerID(rs.getInt("sellerID"));
                seller.setUserID(rs.getInt("userID"));
                seller.setSellerShopName(rs.getString("sellerShopName"));
                seller.setSellerPhone(rs.getString("sellerPhone"));
                seller.setEvidence(rs.getString("evidence"));
                seller.setSellerMainProduct(rs.getInt("sellerMainProduct"));
                seller.setDescription(rs.getString("description"));
                seller.setSellerVerification(rs.getInt("sellerVerification"));
                seller.setBackGroundImage(rs.getString("backGroundImage"));
                seller.setAvatar(rs.getString("avatar"));
                seller.setStatus(rs.getInt("status"));
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return seller;
    }

    public ArrayList<Seller> getAllSeller() {
        ArrayList<Seller> list = new ArrayList<>();
        String xSql = "select * from Seller where status = 1 and sellerVerification = 1";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Seller(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)));
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<Seller> getNewSeller() {
        List<Seller> list = new ArrayList<>();
        String xSql = "select * from Seller where status = 1 and sellerVerification = 1 ORDER BY sellerID desc LIMIT 5";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Seller(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)));
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<Seller> getSellerBySellerRequest() {
        List<Seller> list = new ArrayList<>();
        String xSql = "select * from Seller where status = 1 and sellerVerification = 0";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Seller(rs.getInt("sellerID"), rs.getInt("userID"),
                        rs.getString("sellerShopName"), rs.getString("sellerPhone"),
                        rs.getString("evidence"), rs.getInt("sellerMainProduct"),
                        rs.getString("description"), rs.getInt("sellerVerification"),
                        rs.getString("backGroundImage"), rs.getString("avatar"),
                        rs.getInt("status")));
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public Seller getSellerByUserID(int userID) {
        Seller seller = new Seller();
        String xSql = "select * from Seller where userID = " + userID;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                seller.setSellerID(rs.getInt("sellerID"));
                seller.setUserID(rs.getInt("userID"));
                seller.setSellerShopName(rs.getString("sellerShopName"));
                seller.setSellerPhone(rs.getString("sellerPhone"));
                seller.setEvidence(rs.getString("evidence"));
                seller.setSellerMainProduct(rs.getInt("sellerMainProduct"));
                seller.setDescription(rs.getString("description"));
                seller.setSellerVerification(rs.getInt("sellerVerification"));
                seller.setBackGroundImage(rs.getString("backGroundImage"));
                seller.setAvatar(rs.getString("avatar"));
                seller.setStatus(rs.getInt("status"));
            }

        } catch (Exception e) {
            Logger.getLogger(SellerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return seller;
    }

    public Seller getSellerByProductId(int productID) {
        Seller seller = new Seller();
        String xSql = "select * from Seller s INNER JOIN Product p \n"
                + "ON s.sellerID = p.sellerID\n"
                + "where p.productID=" + productID;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                seller.setSellerID(rs.getInt("sellerID"));
                seller.setUserID(rs.getInt("userID"));
                seller.setSellerShopName(rs.getString("sellerShopName"));
                seller.setSellerPhone(rs.getString("sellerPhone"));
                seller.setEvidence(rs.getString("evidence"));
                seller.setSellerMainProduct(rs.getInt("sellerMainProduct"));
                seller.setDescription(rs.getString("description"));
                seller.setSellerVerification(rs.getInt("sellerVerification"));
                seller.setBackGroundImage(rs.getString("backGroundImage"));
                seller.setAvatar(rs.getString("avatar"));
                seller.setStatus(rs.getInt("status"));
            }

        } catch (Exception e) {
            Logger.getLogger(SellerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return seller;
    }

    public int acceptSellerRequest(int sellerID) {
        int n = 0;
        String xSql = "update Seller set sellerVerification = 1 where sellerID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, sellerID);
            n = pre.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(SellerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int denySellerRequest(int sellerID) {
        int n = 0;
        String xSql = "update Seller set sellerVerification = 2 where sellerI] = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, sellerID);
            n = pre.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(SellerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public List<Seller> searchSeller(String text) {
        List<Seller> list = new ArrayList<>();
        String xSql = "SELECT * FROM Seller where sellerShopName like '%" + text + "%'";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Seller(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)));
            }

        } catch (Exception e) {
            Logger.getLogger(SellerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public ArrayList<Seller> getAllPagingSellerRequest(int index, int numOfRow, String search) {
        int start = (index - 1) * numOfRow;
        ArrayList<Seller> list = new ArrayList<>();
        String xSql = "select * from seller where sellerVerification = 0 and ( sellerShopName like '%" + search + "%' or sellerPhone like '%" + search + "%' or sellerVerification like '%" + search + "%') limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                Seller seller = new Seller(rs.getInt("sellerID"), rs.getInt("userID"),
                        rs.getString("sellerShopName"), rs.getString("sellerPhone"),
                        rs.getString("evidence"), rs.getInt("sellerMainProduct"),
                        rs.getString("description"), rs.getInt("sellerVerification"),
                        rs.getString("backGroundImage"), rs.getString("avatar"),
                        rs.getInt("status"));
                list.add(seller);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public int getPageNumberSellerResponse(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) FROM `Seller` where sellerVerification = 1 and ( sellerShopName like '%" + search + "%' or sellerPhone like '%" + search + "%' or sellerVerification like '%" + search + "%')";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }

    public ArrayList<Seller> getAllPagingSeller(int index, int numOfRow, String search) {
        int start = (index - 1) * numOfRow;
        ArrayList<Seller> list = new ArrayList<>();
        String xSql = "select * from Seller where sellerShopName like '%" + search + "%' or sellerPhone like '%" + search + "%' or description like '%" + search + "%' limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                Seller seller = new Seller(rs.getInt("sellerID"), rs.getInt("userID"),
                        rs.getString("sellerShopName"), rs.getString("sellerPhone"),
                        rs.getString("evidence"), rs.getInt("sellerMainProduct"),
                        rs.getString("description"), rs.getInt("sellerVerification"),
                        rs.getString("backGroundImage"), rs.getString("avatar"),
                        rs.getInt("status"));
                list.add(seller);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) FROM Seller where sellerShopName like '%" + search + "%' or sellerPhone like '%" + search + "%' or description like '%" + search + "%'";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "UPDATE Seller SET status = ? WHERE sellerID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setInt(2, id);
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }
}
