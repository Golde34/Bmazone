/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.WareHouse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DAOWareHouse {
    
    DBConnection dbConn;
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String xSql = null;

    public DAOWareHouse(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }

    public void deleteWareHouse(String wareHouseID) {
        String sql = "delete from WareHouse where [wareHouseID] = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, wareHouseID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addWareHouse(WareHouse wh) {
        xSql = "INSERT INTO WareHouse ([wareHouseAddress],[wareHouseCity],[status])\n"
                + "     VALUES (?,?,?)";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setString(1, wh.getWareHouseAddress());
            ps.setString(2, wh.getWareHouseCity());
            ps.setInt(3, wh.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editWareHouse(WareHouse wh) {
        int n = 0;
        xSql = "update WareHouse set [wareHouseAddress] = ? [wareHouseCity] = ? [status] =? where [wareHouseID] = ?";
        try {
            ps = conn.prepareStatement(xSql);
            ps.setString(1, wh.getWareHouseAddress());
            ps.setString(2, wh.getWareHouseCity());
            ps.setInt(3, wh.getStatus());
            ps.setInt(4, wh.getWareHouseID());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public List<WareHouse> getAllWareHouse() {
        List<WareHouse> list = new ArrayList<>();
        xSql = "select * from WareHouse where [status] = 1";
        try {
            ps = conn.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new WareHouse(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
