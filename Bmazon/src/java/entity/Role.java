/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 1;
    private int roleID;
    private String roleName;
    private int adminPermission;
    private int employeePermisson;
    private int sellerPermission;
    private int customerPermission;
    private int status;

    public Role(int roleID, String roleName, int adminPermission, int employeePermisson, int sellerPermission, int customerPermission, int status) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.adminPermission = adminPermission;
        this.employeePermisson = employeePermisson;
        this.sellerPermission = sellerPermission;
        this.customerPermission = customerPermission;
        this.status = status;
    }

    public Role() {
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(int adminPermission) {
        this.adminPermission = adminPermission;
    }

    public int getEmployeePermisson() {
        return employeePermisson;
    }

    public void setEmployeePermisson(int employeePermisson) {
        this.employeePermisson = employeePermisson;
    }

    public int getSellerPermission() {
        return sellerPermission;
    }

    public void setSellerPermission(int sellerPermission) {
        this.sellerPermission = sellerPermission;
    }

    public int getCustomerPermission() {
        return customerPermission;
    }

    public void setCustomerPermission(int customerPermission) {
        this.customerPermission = customerPermission;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

}