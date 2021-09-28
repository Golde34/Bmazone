/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ProductType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ProductTypeDAO extends BaseDAO {

    public void deleteProductType(String ProTypeId) {
        String sql = "delete from ProductType where prodụctTypeID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, ProTypeId);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addProductType(ProductType p) {
        xSql = "INSERT INTO ProductType ([productTypeId],[productID],[size],[color],[price],[wareHouseID],[quantity],[status])\n"
                + "     VALUES (?,?,?,?,?,?,?,?)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, p.getProductTypeId());
            pre.setInt(2, p.getProductID());
            pre.setString(3, p.getSize());
            pre.setString(4, p.getColor());
            pre.setString(5, p.getPrice());
            pre.setInt(6, p.getWareHouseID());
            pre.setInt(7, p.getQuantity());
            pre.setInt(8, p.getStatus());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int editProduct(ProductType p) {
        int n = 0;
        xSql = "update product set productID = ? size = ? color = ? price =? wareHouseID = ? quantity = ? status = ? where productTypeId = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, p.getProductID());
            pre.setString(2, p.getSize());
            pre.setString(3, p.getColor());
            pre.setString(4, p.getPrice());
            pre.setInt(5, p.getWareHouseID());
            pre.setInt(6, p.getQuantity());
            pre.setInt(7, p.getStatus());
            pre.setString(8, p.getProductTypeId());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public int checkoutProductType(int ProTypeId, int quantity) {
        int n = 0;
        xSql = "update product set quantity =? where productTypeId = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, quantity);
            pre.setInt(2, ProTypeId);
            n = pre.executeUpdate();
        } catch (Exception e) {
        }
        return n;
    }

    public List<ProductType> getAllProductType() {
        List<ProductType> list = new ArrayList<>();
        xSql = "select * from ProductType where status = 1";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ProductType getProductTypeByPTypeID(String ProTypeId) {
        ProductType ptype = new ProductType();
        xSql = "select * from ProductType where productTypeId = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, ProTypeId);
            rs = pre.executeQuery();
            while (rs.next()) {
                ptype = new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return ptype;
    }

    public List<ProductType> getProductByProductID(int pid) {
        List<ProductType> list = new ArrayList<>();
        xSql = "select * from ProductType where productID = ? order by productID asc";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<ProductType> getProductByColor(String color) {
        ArrayList<ProductType> list = new ArrayList<>();
        xSql = "SELECT * FROM ProductType WHERE color like ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, "%" + color + "%");
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
//
//    public int getMaxQuantity(int pid) {
//        xSql = "select quantity from product where id = ?";
//        try {
//            ps = conn.prepareStatement(xSql);
//            ps.setInt(1, pid);
//            ps.executeUpdate();
//            if (rs.next()) {
//                return rs.getInt("quantity");
//            }
//        } catch (Exception e) {
//        }
//        return 0;
//    }

//
//    public boolean checkDupProTypeId(int pid) {
//        xSql = "SELECT * FROM product WHERE id = ?";
//        try {
//            ps = conn.prepareStatement(xSql);
//            ps.setInt(1, pid);
//            ps.executeUpdate();
//            if (rs.next()) {
//                return true;
//            }
//        } catch (Exception e) {
//        }
//        return false;
//    }
    public String getProductPrice(int pid) {
        String price = null;
        xSql = "SELECT price FROM ProductType WHERE productID = " + pid + " Order by price";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {

                price = rs.getString("price");

            }
        } catch (Exception e) {
        }
        return price;
    }

    public List<ProductType> searchProduct(String text) {
        List<ProductType> list = new ArrayList<>();
        xSql = "SELECT distinct *FROM [Bmazon].[dbo].[ProductType] where productTypeId like '%" + text + "%' or productID like '%" + text + "%' or size like '%" + text + "%' or color like '%" + text + "%' or price like '%" + text + "%' or wareHouseID like '%" + text + "%' or quantity like '%" + text + "%'";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, text);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new ProductType(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        ProductTypeDAO dao = new ProductTypeDAO();
        List<ProductType> list = dao.searchProduct("12");
        for (ProductType productType : list) {
            System.out.println(productType.getProductTypeId());
        }
    }
}


