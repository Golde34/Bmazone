/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Role;
import java.sql.ResultSet;
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

    BaseDAO dbConn = new BaseDAO();

    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) FROM `Role` where roleName like '%" + search + "%'";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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

    public List<Role> getAllPagingRole(int index, int numOfRow, String search) {
        List<Role> list = new ArrayList<>();
        String xSql = "declare @PageNo INT = ? \n"
                + "declare @PageSize INT= ? \n"
                + "SELECT * from(\n"
                + "SELECT *,\n"
                + "ROW_NUMBER() over (order by roleID) as RowNum\n"
                + "  FROM `Role` where roleName like '%" + search + "%')T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, index);
            pre.setInt(2, numOfRow);
//            pre.setString(3, search);
//            pre.setString(4, search);
//            pre.setString(5, search);
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update `Role` set status = ? where `roleID` = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status == 1 ? 1 : 0);
            pre.setInt(2, id);
            n = pre.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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

    public int addRole(Role r) {
        int n = 0;
        String xSql = "INSERT INTO `Role` (`roleID`, `roleName`, `adminPermission`, `sellerPermission`, `customerPermission`, `status`)"
                + "     VALUES (?,?,?,?,?,1)";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, r.getRoleID());
            pre.setString(2, r.getRoleName());
            pre.setInt(3, r.getAdminPermission());
            pre.setInt(4, r.getSellerPermission());
            pre.setInt(5, r.getCustomerPermission());
            n = pre.executeUpdate();
            
        } catch (Exception e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
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

    public int editRole(Role r) {
        int n = 0;
        String xSql = "update `Role` set `roleName` = ? ,`adminPermission` = ?, `sellerPermission` = ?,`customerPermission` = ?, `status` = ? where `roleID` = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, r.getRoleName());
            pre.setInt(2, r.getAdminPermission());
            pre.setInt(3, r.getSellerPermission());
            pre.setInt(4, r.getCustomerPermission());
            pre.setInt(5, r.getStatus());
            pre.setInt(6, r.getRoleID());
            n = pre.executeUpdate();
            
        } catch (Exception e) {
        }finally {
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

    public void deleteRole(int roleID) {
        String sql = "delete from Role where `roleID` = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, roleID);
            pre.executeUpdate();
            
        } catch (Exception e) {
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean checkExistRoleName(String roleName) {
        boolean isExist = false;
        String xSql = "SELECT * FROM `Role` where roleName like ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, roleName);
            rs = pre.executeQuery();
            if (rs.next()) {
                isExist = true;
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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

    public boolean checkExistRoleId(int id) {
        boolean isExist = false;
        String xSql = "SELECT * FROM `Role` where roleID = " + id;
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                isExist =  true;
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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

    public Role getRoleId(int id) {
        Role role = new Role();
        String xSql = "select * from Role where roleID = " + id;
        try {
            conn=new DBConnection().getConnection();
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return role;
    }

    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();
        String xSql = "select * from Role where `status` = 1";
        try {
            conn=new DBConnection().getConnection();
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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

    public List<Role> searchRole(String text) {
        List<Role> list = new ArrayList<>();
        String xSql = "SELECT * FROM `Role` where roleName like '%" + text + "%'";
        try {
            conn=new DBConnection().getConnection();
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
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
}
