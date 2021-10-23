/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ShipCompany;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ShipCompanyDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();
    
    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update [ShipCompany] set status = ? where [companyID] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status == 1 ? 1 : 0);
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
//    public int deleteShipCompany(String companyID) {
//        int n = 0;
//        String sql = "delete from ShipCompany where [companyID] = ?";
//        try {
//            pre = conn.prepareStatement(sql);
//            pre.setString(1, companyID);
//            n = pre.executeUpdate();
//        } catch (SQLException e) {
//        }
//        return n;
//    }

    public boolean checkExistCompanyName(String companyname) {
        String xSql= "SELECT * FROM [Bmazon].[dbo].[ShipCompany] where companyName like ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, companyname);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int addShipCompany(ShipCompany sp) {
        int n = 0;
        String xSql= "INSERT INTO ShipCompany ([companyName],[unitCost],[commitDate],[status])\n"
                + "     VALUES (?,?,?,?)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, sp.getCompanyName());
            pre.setDouble(2, sp.getUnitCost());
            pre.setInt(3, sp.getCommitDate());
            pre.setInt(4, sp.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException e) {
        }
        return n;
    }

    public int editShipCompany(ShipCompany sp) {
        int n = 0;
        String xSql= "update ShipCompany set [companyName] = ? ,[unitCost] = ? ,[commitDate] = ? ,[status] =? where [companyID] = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, sp.getCompanyName());
            pre.setDouble(2, sp.getUnitCost());
            pre.setInt(3, sp.getCommitDate());
            pre.setInt(4, sp.getStatus());
            pre.setInt(5, sp.getCompanyID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
        }
        return n;
    }

    public ShipCompany getShipCompanyById(int id) {
        ShipCompany company = new ShipCompany();
        String xSql= "select * from ShipCompany where companyID = " + id;
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                company.setCommitDate(rs.getInt("commitDate"));
                company.setCompanyName(rs.getString("companyName"));
                company.setStatus(rs.getInt("status"));
                company.setUnitCost(rs.getDouble("unitCost"));
                company.setCompanyID(rs.getInt("companyID"));
            }
        } catch (SQLException e) {
        }
        return company;
    }

    public int getPageNumber(String search) {
        int num = 0;
        String xSql= "SELECT COUNT(*) FROM [Bmazon].[dbo].[ShipCompany] where companyName like '%" + search + "%' or commitDate like '%" + search + "%' or unitCost like '%" + search + "%'";
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
//    public static void main(String[] args) {
//        ShipCompanyDAO dao = new ShipCompanyDAO();
//        dao.changeStatus(1, 1);
//    }
    public List<ShipCompany> getAllPagingShipCompany(int index, int numOfRow, String search) {
        List<ShipCompany> list = new ArrayList<>();
        String xSql= "declare @PageNo INT = ? \n"
                + "declare @PageSize INT= ? \n"
                + "SELECT * from(\n"
                + "SELECT *,\n"
                + "ROW_NUMBER() over (order by companyID) as RowNum\n"
                + "  FROM [Bmazon].[dbo].[ShipCompany] where companyName like '%" + search + "%' or commitDate like '%" + search + "%' or unitCost like '%" + search + "%')T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, index);
            pre.setInt(2, numOfRow);
//            pre.setString(3, search);
//            pre.setString(4, search);
//            pre.setString(5, search);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new ShipCompany(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ShipCompany> getAllShipCompany() {
        List<ShipCompany> list = new ArrayList<>();
        String xSql= "select * from ShipCompany";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new ShipCompany(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
