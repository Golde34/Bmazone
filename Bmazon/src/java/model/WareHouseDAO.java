/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.WareHouse;
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
public class WareHouseDAO extends BaseDAO{

    BaseDAO dbConn = new BaseDAO();
   

//    public void deleteWareHouse(String wareHouseID) {
//        String sql = "delete from WareHouse where `wareHouseID` = ?";
//        try {
//            pre = conn.prepareStatement(sql);
//            pre.setString(1, wareHouseID);
//            pre.executeUpdate();
//        } catch (SQLException e) {
//        }
//    }
    
    public int getPageNumber(String search) {
        int num = 0;
        String xSql= "SELECT COUNT(*) FROM `WareHouse` where wareHouseAddress like '%" + search + "%'";
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
    
    public List<WareHouse> getAllPagingWareHouse(int index, int numOfRow, String search) {
        List<WareHouse> list = new ArrayList<>();
        String xSql= "declare @PageNo INT = ? \n"
                + "declare @PageSize INT= ? \n"
                + "SELECT * from(\n"
                + "SELECT *,\n"
                + "ROW_NUMBER() over (order by wareHouseID) as RowNum\n"
                + "  FROM `WareHouse` where wareHouseAddress like '%" + search + "%')T\n"
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
                list.add(new WareHouse(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update `WareHouse` set status = ? where `wareHouseID` = ?";
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
    
    public int addWareHouse(WareHouse wh) {
        int n = 0;
        String xSql= "INSERT INTO WareHouse (`wareHouseAddress`,`status`) VALUES (?,1)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, wh.getWareHouseAddress());
            n = pre.executeUpdate();
        } catch (SQLException e) {
        }
        return n;
    }

    public int editWareHouse(WareHouse wh) {
        int n = 0;
        String xSql= "update WareHouse set `wareHouseAddress` = ?, `status` =? where `wareHouseID` = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, wh.getWareHouseAddress());
            pre.setInt(2, wh.getStatus());
            pre.setInt(3, wh.getWareHouseID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
        }
        return n;
    }

    public boolean checkExistWareHouse(String warehouse) {
        String xSql= "SELECT * FROM `Warehouse` where wareHouseAddress like ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, warehouse);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public WareHouse getWareHouseById(int id) {
        WareHouse wh = new WareHouse();
        String xSql= "select * from WareHouse where wareHouseID = ?" ;
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                wh.setWareHouseID(rs.getInt(1));
                wh.setWareHouseAddress(rs.getString(2));
                wh.setStatus(rs.getInt(3));
            }
        } catch (SQLException e) {
        }
        return wh;
    }
    
    public List<WareHouse> getAllWareHouse() {
        List<WareHouse> list = new ArrayList<>();
        String xSql= "select * from WareHouse where `status` = 1";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new WareHouse(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
