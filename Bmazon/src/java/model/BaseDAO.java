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

public class BaseDAO extends DBConnection {

    DBConnection dbConn;
    Connection conn;
    PreparedStatement pre = null;
    ResultSet rs = null;
    String xSql = null;

    public BaseDAO() {
        conn=connection;
    }

    public void finalize() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
