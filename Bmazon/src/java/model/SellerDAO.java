/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Seller;
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

    public static void main(String[] args) {
        SellerDAO sel = new SellerDAO();
        Seller sele = sel.getSellerByUserID(5);
        System.out.println(sele.getSellerShopName() + " " + sele.getEvidence());
    }

    public int addSeler(Seller s) {
        int n = 0;
        xSql = "INSERT INTO [Bmazon].[dbo].[Seller] ([userID], [sellerShopName], [sellerPhone], [evidence], [sellerMainProduct], [description], [sellerVerification], [status])"
                + "     VALUES (?,?,?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, s.getUserID());
            pre.setString(2, s.getSellerShopName());
            pre.setString(3, s.getSellerPhone());
            pre.setString(4, s.getEvidence());
            pre.setInt(5, s.getSellerMainProduct());
            pre.setString(6, s.getDescription());
            pre.setInt(7, s.getSellerVerification());
            n = pre.executeUpdate();
            pre.close();
        } catch (Exception e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int editSeller(Seller s) {
        int n = 0;
        xSql = "update [Bmazon].[dbo].[Seller] set [userID] = ? ,[sellerShopName] = ?, [sellerPhone] = ?, [evidence] = ?,"
                + "[sellerMainProduct] = ?, [description] = ?, [sellerVerification] = ?, [status] = ? where [sellerID] = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, s.getUserID());
            pre.setString(2, s.getSellerShopName());
            pre.setString(3, s.getSellerPhone());
            pre.setString(4, s.getEvidence());
            pre.setInt(5, s.getSellerMainProduct());
            pre.setString(6, s.getDescription());
            pre.setInt(7, s.getSellerVerification());
            pre.setInt(8, s.getStatus());
            pre.setInt(9, s.getSellerID());
            n = pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public void deleteSeller(int sellerID) {
        String sql = "delete from Seller where [sellerID] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sellerID);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public boolean checkExistPhone(String phone) {
        String sql = "SELECT * FROM [Seller] WHERE sellerPhone = '" + phone + "' and status = 1";
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

    public boolean checkExistUserID(int id) {
        String sql = "SELECT * FROM [Seller] WHERE userID = " + id + " and status = 1";
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

    public boolean checkExistSellerShopName(String sellerShopName) {
        xSql = "SELECT * FROM [Bmazon].[dbo].[Seller] where sellerShopName like '" + sellerShopName + "'";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkExistSellerId(int id) {
        xSql = "SELECT * FROM [Bmazon].[dbo].[Seller] where sellerID = " + id;
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Seller getSellerID(int id) {
        Seller seller = new Seller();
        xSql = "select * from Seller where sellerID = " + id;
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {;
                seller.setSellerID(rs.getInt("sellerID"));
                seller.setUserID(rs.getInt("userID"));
                seller.setSellerShopName(rs.getString("selerShopName"));
                seller.setSellerPhone(rs.getString("sellerPhone"));
                seller.setEvidence(rs.getString("evidence"));
                seller.setSellerMainProduct(rs.getInt("sellerMainProduct"));
                seller.setDescription(rs.getString("description"));
                seller.setSellerVerification(rs.getInt("sellerVerification"));
                seller.setStatus(rs.getInt("status"));
            }
        } catch (Exception e) {
        }
        return seller;
    }

    public List<Seller> getAllSeller() {
        List<Seller> list = new ArrayList<>();
        xSql = "select * from Seller where [status] = 1";
        try {
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
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Seller getSellerByUserID(int userID) {
        xSql = "select * from [Bmazon].[dbo].[Seller] where userID = " + userID;
        ResultSet rs = dbConn.getData(xSql);
        try {
            if (rs.next()) {
                Seller seller = new Seller(rs.getInt("sellerID"), rs.getInt("userID"),
                        rs.getString("sellerShopName"), rs.getString("sellerPhone"),
                        rs.getString("evidence"), rs.getInt("sellerMainProduct"),
                        rs.getString("description"), rs.getInt("sellerVerification"),
                        rs.getInt("status"));
                return seller;
            }
        } catch (Exception e) {
            Logger.getLogger(SellerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public List<Seller> searchSeller(String text) {
        List<Seller> list = new ArrayList<>();
        xSql = "SELECT * FROM [Bmazon].[dbo].[Role] where roleName like '%" + text + "%'";
        try {
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
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
