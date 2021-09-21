/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.WareHouse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class WareHouseDAO extends BaseDAO{

    public WareHouseDAO(DBConnection dbCon) {
        super(dbCon);
    }

    public void deleteWareHouse(String wareHouseID) {
        String sql = "delete from WareHouse where [wareHouseID] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, wareHouseID);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addWareHouse(WareHouse wh) {
        xSql = "INSERT INTO WareHouse ([wareHouseAddress],[wareHouseCity],[status])\n"
                + "     VALUES (?,?,?)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, wh.getWareHouseAddress());
            pre.setString(2, wh.getWareHouseCity());
            pre.setInt(3, wh.getStatus());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editWareHouse(WareHouse wh) {
        int n = 0;
        xSql = "update WareHouse set [wareHouseAddress] = ? [wareHouseCity] = ? [status] =? where [wareHouseID] = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, wh.getWareHouseAddress());
            pre.setString(2, wh.getWareHouseCity());
            pre.setInt(3, wh.getStatus());
            pre.setInt(4, wh.getWareHouseID());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public List<WareHouse> getAllWareHouse() {
        List<WareHouse> list = new ArrayList<>();
        xSql = "select * from WareHouse where [status] = 1";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
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
