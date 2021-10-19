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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ProductTypeDAO extends BaseDAO {

    
    
    public static void main(String[] args) {
        ProductTypeDAO dao = new ProductTypeDAO();
        
        List<ProductType> list = dao.getProductByProductID(25);
        for (ProductType productType : list) {
            System.out.println(productType.getColor());
        }
    }
    public int getPageNumber(String search, String productID) {
        int num = 0;
        String xSql = "SELECT COUNT(*)from ProductType\n" +
"       where color like '%" + search + "%' and productID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, productID);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
    
    public ArrayList<ProductType> getAllPagingProductType(int index, int numOfRow, String search, String pid) {
        ArrayList<ProductType> list = new ArrayList<>();
        String sql = "declare @PageNo INT = " + index + "\n" +
"                declare @PageSize INT=" + numOfRow + " \n" +
"                SELECT * FROM\n" +
"                (SELECT * ,\n" +
"                ROW_NUMBER() over (order by productID) as RowNum\n" +
"                FROM ProductType where productID = " + pid + " and(color like '%" + search + "%'))T\n" +
"                where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            pre = conn.prepareStatement(sql);
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
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public void deleteProductType(String ProTypeId) {
        String sql = "delete from ProductType where prodụctTypeID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, ProTypeId);
            pre.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addProductType(ProductType p) {
        String xSql = "INSERT INTO ProductType ([productTypeId],[productID],[size],[color],[price],[wareHouseID],[quantity],[status])\n"
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
        } catch (SQLException e) {
        }
    }

    public int editProduct(ProductType p) {
        int n = 0;
        String xSql = "UPDATE [Bmazon].[dbo].[ProductType]SET [productID] = ?,[size] = ? ,[color] = ? ,[price] = ?,[wareHouseID] = ?,[quantity] = ?,[status] = ? WHERE [productTypeId] = ?";
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
        } catch (SQLException e) {
        }
        return n;
    }

    public int checkoutProductType(int ProTypeId, int quantity) {
        int n = 0;
        String xSql = "update product set quantity =? where productTypeId = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, quantity);
            pre.setInt(2, ProTypeId);
            n = pre.executeUpdate();
        } catch (SQLException e) {
        }
        return n;
    }

    public List<ProductType> getAllProductType() {
        List<ProductType> list = new ArrayList<>();
        String xSql = "select * from ProductType where status = 1";
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
        } catch (SQLException e) {
        }
        return list;
    }

    public ProductType getProductTypeByPTypeID(String ProTypeId) {
        ProductType ptype = new ProductType();
        String xSql = "select * from ProductType where productTypeId = ?";
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
        } catch (SQLException e) {
        }
        return ptype;
    }


    public int getProductIdByProductTypeId(String id) {
        int pid = -1;
        String xSql = "SELECT [productID] FROM [Bmazon].[dbo].[ProductType] where productTypeId =?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                pid = rs.getInt("productID");
            }
        } catch (SQLException e) {

        }
        return pid;
    }

    public List<ProductType> getProductByProductID(int pid) {
        List<ProductType> list = new ArrayList<>();
        String xSql = "select * from ProductType where productID = ?";
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
        } catch (SQLException e) {
        }
        return list;
    }

    public ProductType getProductTypeByColorAndSize(String color, String size, String productID) {
        ProductType pt = new ProductType();
        String xSql = "select pt.* from Product p join ProductType pt on p.productID = pt.productID where p.productID = ? and pt.size = ? and pt.color = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, productID);
            pre.setString(2, size);
            pre.setString(3, color);
            rs = pre.executeQuery();
            if (rs.next()) {
                pt.setProductID(rs.getInt("productID"));
                pt.setProductTypeId(rs.getString("productTypeId"));
                pt.setColor(rs.getString("color"));
                pt.setPrice(rs.getString("price"));
                pt.setSize(rs.getString("size"));
                pt.setWareHouseID(rs.getInt("wareHouseID"));
                pt.setQuantity(rs.getInt("quantity"));
                pt.setStatus(rs.getInt("status"));

            }
        } catch (SQLException e) {
        }
        return pt;
    }

    public ArrayList<ProductType> getProductByColor(String color) {
        ArrayList<ProductType> list = new ArrayList<>();
        String xSql = "SELECT * FROM ProductType WHERE color like ?";
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
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<String> getAllSizeOfProduct(int id) {
        ArrayList<String> list = new ArrayList<>();
        String xSql = "select distinct size from ProductType where productID = " + id + "";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("size"));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<String> getAllColorOfProduct(int id) {
        ArrayList<String> list = new ArrayList<>();
        String xSql = "select distinct color from ProductType where productID = " + id + "";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("color"));
            }
        } catch (SQLException e) {
        }
        return list;
    }
//
//    public int getMaxQuantity(int pid) {
//        String xSql= "select quantity from product where id = ?";
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
//        String xSql= "SELECT * FROM product WHERE id = ?";
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
        String xSql = "SELECT price FROM ProductType WHERE productID = " + pid + " Order by price";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {

                price = rs.getString("price");

            }
        } catch (SQLException e) {
        }
        return price;
    }

    public int changeStatus(String id, int status) {
        int n = 0;
        String sql = "update [ProductType] set status = ? where productTypeId = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setString(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public List<ProductType> searchProduct(String text) {
        List<ProductType> list = new ArrayList<>();
        String xSql = "SELECT distinct *FROM [Bmazon].[dbo].[ProductType] where productTypeId like '%" + text + "%' or productID like '%" + text + "%' or size like '%" + text + "%' or color like '%" + text + "%' or price like '%" + text + "%' or wareHouseID like '%" + text + "%' or quantity like '%" + text + "%'";
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
        } catch (SQLException e) {
        }
        return list;
    }

    public boolean checkExistColor(String color) {
        String sql = "SELECT * FROM [ProductType] WHERE color = '" + color + "'";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkExistSizeAndColor(String size, String color, int productId) {
        String sql = "SELECT * FROM [ProductType] WHERE size = '" + size + "' and color='" + color + "' and productID=" + productId;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
