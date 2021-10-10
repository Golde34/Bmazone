/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ShipCompany;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public void deleteShipCompany(String companyID) {
        String sql = "delete from ShipCompany where [companyID] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, companyID);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public boolean checkExistCompanyName(String companyname) {
        xSql = "SELECT * FROM [Bmazon].[dbo].[ShipCompany] where companyName like '" + companyname + "'";
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

    public void addShipCompany(ShipCompany sp) {
        xSql = "INSERT INTO ShipCompany ([companyName],[unitCost],[commitDate],[status])\n"
                + "     VALUES (?,?,?,?)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, sp.getCompanyName());
            pre.setDouble(2, sp.getUnitCost());
            pre.setInt(3, sp.getCommitDate());
            pre.setInt(4, sp.getStatus());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editShipCompany(ShipCompany sp) {
        int n = 0;
        xSql = "update ShipCompany set [companyName] = ? ,[unitCost] = ? ,[commitDate] = ? ,[status] =? where [companyID] = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, sp.getCompanyName());
            pre.setDouble(2, sp.getUnitCost());
            pre.setInt(3, sp.getCommitDate());
            pre.setInt(4, sp.getStatus());
            pre.setInt(5, sp.getCompanyID());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public ShipCompany getShipCompanyById(int id) {
        ShipCompany company = new ShipCompany();
        xSql = "select * from ShipCompany where companyID = " + id;
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
        } catch (Exception e) {
        }
        return company;
    }

    public int getPageNumber(String search) {
        int num = 0;
        xSql = "SELECT COUNT(*) FROM [Bmazon].[dbo].[ShipCompany] where status=1 and (companyName like '%" + search + "%' or commitDate like '%" + search + "%' or unitCost like '%" + search + "%')";
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
    public static void main(String[] args) {
        ShipCompanyDAO dao = new ShipCompanyDAO();
        List<ShipCompany> list = dao.getAllPagingShipCompany(1, 5, "h");
        for (ShipCompany shipCompany : list) {
            System.out.println(shipCompany.getCompanyName());
        }
    }
    public List<ShipCompany> getAllPagingShipCompany(int index, int numOfRow, String search) {
        List<ShipCompany> list = new ArrayList<>();
        xSql = "declare @PageNo INT =" + index + "\n"
                + "declare @PageSize INT=" + numOfRow + "\n"
                + "SELECT * from(\n"
                + "SELECT *,\n"
                + "ROW_NUMBER() over (order by companyID) as RowNum\n"
                + "  FROM [Bmazon].[dbo].[ShipCompany] where status=1 and (companyName like '%" + search + "%' or commitDate like '%" + search + "%' or unitCost like '%" + search + "%'))T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
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
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ShipCompany> getAllShipCompany() {
        List<ShipCompany> list = new ArrayList<>();
        xSql = "select * from ShipCompany where [status] = 1";
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
        } catch (Exception e) {
        }
        return list;
    }
}
