/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Order;
import entity.Transaction;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class TransactionDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public List<Transaction> getAllPagingTransaction(int index, int numOfRow, String search) {
        int start = (index - 1) * numOfRow;
        List<Transaction> list = new ArrayList<>();
        String sql = "select * from `Transaction` t join User u on t.userID = u.userID where t.status=2 and (t.money like '%" + search + "%' or u.fullname like '%" + search + "%') order by `history` desc limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                Transaction t = new Transaction(rs.getInt("transactionID"),
                        rs.getString("userID"),
                        rs.getDouble("money"),
                        rs.getString("history"),
                        rs.getInt("state"),
                        rs.getInt("status"));
                list.add(t);
            }
        } catch (Exception ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public ArrayList<Transaction> getAllPagingTransactionByUser(int index, int numOfRow, String search, String user) {
        int start = (index - 1) * numOfRow;
        ArrayList<Transaction> list = new ArrayList<>();
        String sql = "select * from `Transaction` where userID = ? and (money like '%" + search + "%' or history like '%" + search + "%') order by `history` desc limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, user);
            pre.setInt(2, start);
            pre.setInt(3, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                Transaction t = new Transaction(rs.getInt("transactionID"),
                        rs.getString("userID"),
                        rs.getDouble("money"),
                        rs.getString("history"),
                        rs.getInt("state"),
                        rs.getInt("status"));
                list.add(t);
            }

        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
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
    
    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) FROM `Transaction` where money like '%" + search + "%' or history like '%" + search + "%'";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }

    public ArrayList<Transaction> getAllTransaction() {
        ArrayList<Transaction> list = new ArrayList<>();
        String sql = "select * from `Transaction` where status = 2 order by transactionID desc";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Transaction t = new Transaction(rs.getInt("transactionID"),
                        rs.getString("userID"),
                        rs.getDouble("money"),
                        rs.getString("history"),
                        rs.getInt("state"),
                        rs.getInt("status"));
                list.add(t);
            }
        } catch (Exception ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public Transaction getTransactionByTransactionID(int tranid) {
        ArrayList<Transaction> list = new ArrayList<>();
        String sql = "select * from `Transaction` where transactionID = " + tranid;
        Transaction t = null;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                t = new Transaction();
                t.setTransactionID(rs.getInt("transactionID"));
                t.setUserID(rs.getString("userID"));
                t.setMoney(rs.getDouble("money"));
                t.setHistory(rs.getString("history"));
                t.setState(rs.getInt("state"));
                t.setStatus(rs.getInt("status"));
            }
        } catch (Exception ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return t;
    }
    
    public ArrayList<Transaction> getTransactionByUserID(int uid) {
        ArrayList<Transaction> list = new ArrayList<>();
        String sql = "select * from `Transaction` where userID = " + uid;
        Transaction t = null;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                t = new Transaction();
                t.setTransactionID(rs.getInt("transactionID"));
                t.setUserID(rs.getString("userID"));
                t.setMoney(rs.getDouble("money"));
                t.setHistory(rs.getString("history"));
                t.setState(rs.getInt("state"));
                t.setStatus(rs.getInt("status"));
                list.add(t);
            }
        } catch (Exception ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        TransactionDAO dao = new TransactionDAO();
        Transaction t = new Transaction("2", 100000, dtf.format(now), 1);
        System.out.println(dao.getAllPagingTransactionByUser(1,5,"","2"));
    }

    public int insertTransaction(Transaction t) {
        int n = 0;
        String xSql = "INSERT INTO `Transaction` (userID, money, history, state, status)"
                + "     VALUES (?,?,?,?,2)";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, t.getUserID());
            pre.setDouble(2, t.getMoney());
            pre.setString(3, t.getHistory());
            pre.setInt(4, t.getState());
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int acceptTopUpRequest(int tranid) {
        int n = 0;
        String xSql = "update `Transaction` set status = 1 where transactionID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, tranid);
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int denyTopUpRequest(int tranid) {
        int n = 0;
        String xSql = "update `Transaction` set status = 0 where transactionID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, tranid);
            n = pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(TransactionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }
}
