/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class BaseDAO {
    
    DBConnection dbConn;
    Connection conn;
    PreparedStatement pre = null;
    ResultSet rs = null;
    String xSql = null;

    public BaseDAO(DBConnection dbCon) {
        this.dbConn = dbCon;
        conn = dbCon.getConnection();
    }
}
