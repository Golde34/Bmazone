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
public class DAOShipCompany {
    
    DBConnection dbConn;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String xSql = null;

    public DAOShipCompany(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }

    public void deleteShipCompany(String companyID) {
        String sql = "delete from ShipCompany where [companyID] = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addShipCompany(ShipCompany sp) {
        xSql = "INSERT INTO ShipCompany ([companyName],[unitCost],[commitDate],[status])\n"
                + "     VALUES (?,?,?,?)";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setString(1, sp.getCompanyName());
            ps.setDouble(2, sp.getUnitCost());
            ps.setInt(3, sp.getCommitDate());
            ps.setInt(4, sp.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editShipCompany(ShipCompany sp) {
        int n = 0;
        xSql = "update ShipCompany set [companyName] = ? [unitCost] = ? [commitDate] = ? [status] =? where [companyID] = ?";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setString(1, sp.getCompanyName());
            ps.setDouble(2, sp.getUnitCost());
            ps.setInt(3, sp.getCommitDate());
            ps.setInt(4, sp.getStatus());
            ps.setInt(5, sp.getCompanyID());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public List<ShipCompany> getAllShipCompany() {
        List<ShipCompany> list = new ArrayList<>();
        xSql = "select * from ShipCompany where [status] = 1";
        try {
            ps = conn.prepareStatement(xSql);
            rs = ps.executeQuery();
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
