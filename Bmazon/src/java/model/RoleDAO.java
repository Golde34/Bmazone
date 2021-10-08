/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Role;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RoleDAO extends BaseDAO {

    public void addRole(Role sp) {
        xSql = "INSERT INTO Role ([roleID], [roleName], [adminPermission], [sellerPermission], [customerPermission], [status])\n"
                + "     VALUES (?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, sp.getRoleID());
            pre.setString(2, sp.getRoleName());
            pre.setInt(3, sp.getAdminPermission());
            pre.setInt(4, sp.getSellerPermission());
            pre.setInt(5, sp.getCustomerPermission());
            pre.setInt(6, sp.getStatus());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editRole(Role sp) {
        int n = 0;
        xSql = "update Role set [roleName] = ? ,[adminPermission] = ?, [sellerPermission] = ?,[customerPermission] = ?, [status] = ? where [roleID] = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, sp.getRoleID());
            pre.setString(2, sp.getRoleName());
            pre.setInt(3, sp.getAdminPermission());
            pre.setInt(4, sp.getSellerPermission());
            pre.setInt(5, sp.getCustomerPermission());
            pre.setInt(6, sp.getStatus());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public void deleteRole(String companyID) {
        String sql = "delete from Role where [roleID] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, companyID);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public boolean checkExistRoleName(String roleName) {
        xSql = "SELECT * FROM [Bmazon].[dbo].[Role] where roleName like '" + roleName + "'";
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

    public boolean checkExistRoleId(int id) {
        xSql = "SELECT * FROM [Bmazon].[dbo].[Role] where roleID = " + id;
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

    public Role getRoleId(int id) {
        Role role = new Role();
        xSql = "select * from Role where roleID = " + id;
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {;
                role.setRoleName(rs.getString("roleName"));
                role.setAdminPermission(rs.getInt("adminPermission"));
                role.setSellerPermission(rs.getInt("sellerPermission"));
                role.setCustomerPermission(rs.getInt("customerPermission"));
                role.setStatus(rs.getInt("status"));
                role.setRoleID(rs.getInt("roleID"));
            }
        } catch (Exception e) {
        }
        return role;
    }

    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();
        xSql = "select * from Role where [status] = 1";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Role(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Role> searchRole(String text) {
        List<Role> list = new ArrayList<>();
        xSql = "SELECT * FROM [Bmazon].[dbo].[Role] where roleName like '%" + text + "%'";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Role(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
