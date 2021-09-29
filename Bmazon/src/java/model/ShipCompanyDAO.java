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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ShipCompanyDAO extends BaseDAO{

    
    public void deleteShipCompany(String companyID) {
        String sql = "delete from ShipCompany where [companyID] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, companyID);
            pre.executeUpdate();
        } catch (Exception e) {
        }
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
    public static void main(String[] args) {
        ShipCompanyDAO dao = new ShipCompanyDAO();
        ShipCompany s = dao.getShipCompanyById(4);
        s.setCommitDate(10);
        s.setCompanyName("b");
        s.setUnitCost(10000);
        dao.editShipCompany(s);
    }
    
    public ShipCompany getShipCompanyById(int id) {
        ShipCompany company = new ShipCompany();
        xSql = "select * from ShipCompany where companyID = "+id;
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
