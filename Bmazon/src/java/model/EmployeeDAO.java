/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Employee;
import entity.Seller;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bacon
 */
public class EmployeeDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public static void main(String[] args) {
        EmployeeDAO empd = new EmployeeDAO();
        empd.addEmployee(new Employee(12, "mra", 23092001, "link", 1));
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update `employees` set status = ? where `employeeID` = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, status == 1 ? 1 : 0);
            pre.setInt(2, id);
            n = pre.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int addEmployee(Employee e) {
        int n = 0;
        String xSql = "Insert into employees(userID,name,startdate,salary,avatar,status)"
                + " values(?,?,now(),?,?,1)";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, e.getUserId());
            pre.setString(2, e.getName());
            pre.setDouble(3, e.getSalary());
            pre.setString(4, e.getAvatar());
            n = pre.executeUpdate();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public int editEmployee(Employee e) {
        int n = 0;
        String xSql = "update employees set userID = ? ,name = ?, startdate = ?, salary = ?,"
                + "avatar = ? where employeeID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, e.getUserId());
            pre.setString(2, e.getName());
            pre.setDate(3, e.getStartDate());
            pre.setDouble(4, e.getSalary());
            pre.setString(5, e.getAvatar());
            pre.setInt(6, e.getEmployeeId());
            n = pre.executeUpdate();
            pre.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }

    public Employee getEmployeeID(String id) {
        Employee emp = null;
        String xSql = "select * from employees where employeeID = " + id;
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                emp = new Employee(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
            rs.close();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return emp;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        String xSql = "select * from employees ";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
            rs.close();
            pre.close();

        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Employee> getAllPagingEmployee(int index, int numOfRow, String search) {
        int start = (index - 1) * numOfRow;
        List<Employee> list = new ArrayList<>();
        String xSql = "select * from employees where name like'%" + search + "%' limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
            rs.close();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
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

}
