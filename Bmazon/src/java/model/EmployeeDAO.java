/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Employee;
import entity.Seller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bacon
 */
public class EmployeeDAO extends BaseDAO{
     BaseDAO dbConn = new BaseDAO();

    public int addEmployee(Employee e) {
        int n = 0;
        String xSql = "INSERT INTO employees (userID,name,startdate,salary,avatar,status)"
                + "     VALUES (?,?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, e.getUserId());
            pre.setString(2, e.getName());
            pre.setDate(3, e.getStartDate());
            pre.setDouble(4, e.getSalary());
            pre.setString(5, e.getAvatar());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int editSeller(Employee e) {
        int n = 0;
        String xSql = "update employees set userID = ? ,name = ?, startdate = ?, salary = ?,"
                + "avatar = ? where employeeID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, e.getUserId());
            pre.setString(2, e.getName());
            pre.setDate(3, e.getStartDate());
            pre.setDouble(4, e.getSalary());
            pre.setString(5, e.getAvatar());
            pre.setInt(6, e.getEmployeeId());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
     public Employee getEmployeeID(String id) {
        Employee emp=null;
        String xSql = "select * from employees where employeeID = " + id;
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
               emp=new Employee(
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
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }
     public static void main(String[] args) {
        EmployeeDAO ed= new EmployeeDAO();
         System.out.println(ed.getEmployeeID("1"));
    }

    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        String xSql = "select * from employees";
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

   
}
