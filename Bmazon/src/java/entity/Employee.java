/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author bacon
 */
public class Employee {
    private int employeeId;
    private int userId;
    private String name;
    private Date startDate;
    private double salary;
    private String avatar;
    private int status;

    public Employee() {
    }

    public Employee(int employeeId, int userId, String name, Date startDate, double salary, String avatar, int status) {
        this.employeeId = employeeId;
        this.userId = userId;
        this.name = name;
        this.startDate = startDate;
        this.salary = salary;
        this.avatar = avatar;
        this.status = status;
    }

    public Employee(int userId, String name, Date startDate, double salary, String avatar, int status) {
        this.userId = userId;
        this.name = name;
        this.startDate = startDate;
        this.salary = salary;
        this.avatar = avatar;
        this.status = status;
    }

    public Employee(int userId, String name, double salary, String avatar, int status) {
        this.userId = userId;
        this.name = name;
        this.salary = salary;
        this.avatar = avatar;
        this.status = status;
    }
    

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
}
