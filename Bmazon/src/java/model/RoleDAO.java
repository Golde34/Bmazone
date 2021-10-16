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

    public int addRole(Role sp) {
        int n = 0;
        String xSql= "INSERT INTO [Bmazon].[dbo].[Role] ([roleID], [roleName], [adminPermission], [sellerPermission], [customerPermission], [status])"
                + "     VALUES (?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, sp.getRoleID());
            pre.setString(2, sp.getRoleName());
            pre.setInt(3, sp.getAdminPermission());
            pre.setInt(4, sp.getSellerPermission());
            pre.setInt(5, sp.getCustomerPermission());
            n = pre.executeUpdate();
            pre.close();
        } catch (Exception e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int editRole(Role sp) {
        int n = 0;
        String xSql= "update Role set [roleName] = ? ,[adminPermission] = ?, [sellerPermission] = ?,[customerPermission] = ?, [status] = ? where [roleID] = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(6, sp.getRoleID());
            pre.setString(1, sp.getRoleName());
            pre.setInt(2, sp.getAdminPermission());
            pre.setInt(3, sp.getSellerPermission());
            pre.setInt(4, sp.getCustomerPermission());
            pre.setInt(5, sp.getStatus());
            pre.executeUpdate();
        } catch (SQLException e) {
        }
        return n;
    }

    public void deleteRole(int roleID) {
        String sql = "delete from Role where [roleID] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, roleID);
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public boolean checkExistRoleName(String roleName) {
        String xSql= "SELECT * FROM [Bmazon].[dbo].[Role] where roleName like ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, roleName);
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
        String xSql= "SELECT * FROM [Bmazon].[dbo].[Role] where roleID = " + id;
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
        String xSql= "select * from Role where roleID = " + id;
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
        } catch (SQLException e) {
        }
        return role;
    }

    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();
        String xSql= "select * from Role where [status] = 1";
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
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Role> searchRole(String text) {
        List<Role> list = new ArrayList<>();
        String xSql= "SELECT * FROM [Bmazon].[dbo].[Role] where roleName like '%" + text + "%'";
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
        } catch (SQLException e) {
        }
        return list;
    }

    public Role getRoleById(int id) {
        Role role = new Role();
        String xSql= "select * from Role where roleID = " + id;
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                role.setRoleID(rs.getInt("roleID"));
                role.setRoleName(rs.getString("roleName"));
                role.setAdminPermission(rs.getInt("adminPermission"));
                role.setSellerPermission(rs.getInt("sellerPermission"));
                role.setCustomerPermission(rs.getInt("customerPermission"));
                role.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
        }
        return role;
    }
}
