/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ProductType;
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

    public int getPageNumber(String search, String productID) {
        int num = 0;
        String xSql = "SELECT COUNT(*)from ProductType\n"
                + "       where color like '%" + search + "%' and productID = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, productID);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num;
    }

    public ArrayList<ProductType> getAllPagingProductType(int index, String search, String pid) {
        ArrayList<ProductType> list = new ArrayList<>();
        String sql = "SELECT * FROM ProductType where productID = " + pid + " and color like '%" + search + "%' limit ?,?";
        try {
            conn=new DBConnection().getConnection();
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
            
            
        } catch (Exception e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
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

    public int checkoutProductType(String ProTypeId, int quantity) {
        int n = 0;
        String xSql = "update ProductType set quantity =? where productTypeId = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, quantity);
            pre.setString(2, ProTypeId);
            n = pre.executeUpdate();
            
        } catch (Exception e) {
        }finally {
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

    public List<ProductType> getAllProductType() {
        List<ProductType> list = new ArrayList<>();
        String xSql = "select * from ProductType where status = 1";
        try {
            conn=new DBConnection().getConnection();
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
        }finally {
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
    public List<ProductType> getAllProductTypeBySeller(int sellerID) {
        List<ProductType> list = new ArrayList<>();
        String xSql = "SELECT * FROM producttype pt inner join product p on pt.productID = p.productID \n" +
                        "where p.sellerID = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, sellerID);
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
        }finally {
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

    public ProductType getProductTypeByPTypeID(String ProTypeId) {
        ProductType ptype = new ProductType();
        String xSql = "select * from ProductType where productTypeId = ?";
        try {
            conn=new DBConnection().getConnection();
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
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ptype;
    }

    public ProductType getExactProductTypeByProductId(int productID, double price, String size, String color) {
        ProductType ptype = new ProductType();
        String xSql = "select * from ProductType where productID = ? and price = ? and size = ? and color = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, productID);
            pre.setDouble(2, price);
            pre.setString(3, size);
            pre.setString(4, color);
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
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ptype;
    }

    public ProductType getDefaultProductTypeByProductId(int productID) {
        ProductType ptype = new ProductType();
        String xSql = "select * from ProductType where productID = ? LIMIT 1";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, productID);
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
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ptype;
    }
    
    public int getProductQuantity(String pid, String size, String color) {
        int quantity = 0;
        String xSql = "SELECT quantity FROM ProductType WHERE productTypeID = ? and size = ? and color = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, pid);
            pre.setString(2, size);
            pre.setString(3, color);
            rs = pre.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt("quantity");
            }
            
            
        } catch (Exception e) {
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return quantity;
    }

    public int getProductIdByProductTypeId(String id) {
        int pid = -1;
        String xSql = "SELECT productID FROM ProductType where productTypeId =?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                pid = rs.getInt("productID");
            }
            
            
        } catch (Exception e) {

        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pid;
    }

    public List<ProductType> getProductByProductID(int pid) {
        List<ProductType> list = new ArrayList<>();
        String xSql = "select * from ProductType where productID = ?";
        try {
            conn=new DBConnection().getConnection();
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
        }finally {
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

    public ProductType getProductTypeByColorAndSize(String color, String size, String productID) {
        ProductType pt = new ProductType();
        String xSql = "select pt.* from Product p join ProductType pt on p.productID = pt.productID where p.productID = ? and pt.size = ? and pt.color = ?";
        try {
            conn=new DBConnection().getConnection();
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
            
            
        } catch (Exception e) {
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pt;
    }

    public ArrayList<ProductType> getProductByColor(String color) {
        ArrayList<ProductType> list = new ArrayList<>();
        String xSql = "SELECT * FROM ProductType WHERE color like ?";
        try {
            conn=new DBConnection().getConnection();
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
        }finally {
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

    public ArrayList<String> getAllSizeOfProduct(int id) {
        ArrayList<String> list = new ArrayList<>();
        String xSql = "select distinct size from ProductType where productID = " + id + "";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("size"));
            }
            
            
        } catch (Exception e) {
        }finally {
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

    public ArrayList<String> getAllColorOfProduct(int id) {
        ArrayList<String> list = new ArrayList<>();
        String xSql = "select distinct color from ProductType where productID = " + id + "";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("color"));
            }
            
            
        } catch (Exception e) {
        }finally {
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
  
    public String getProductPrice(int pid) {
        String price = null;
        String xSql = "SELECT price FROM ProductType WHERE productID = " + pid + " Order by price";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                price = rs.getString("price");
            }
            
            
        } catch (Exception e) {
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return price;
    }

    public int addProductType(ProductType p) {
        int n = 0;
        String xSql = "INSERT INTO ProductType (productTypeId,productID,size,color,price,wareHouseID,quantity,status)\n"
                + "     VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, p.getProductTypeId());
            pre.setInt(2, p.getProductID());
            pre.setString(3, p.getSize());
            pre.setString(4, p.getColor());
            pre.setString(5, p.getPrice());
            pre.setInt(6, p.getWareHouseID());
            pre.setInt(7, p.getQuantity());
            pre.setInt(8, p.getStatus());
            n = pre.executeUpdate();
            
        } catch (Exception e) {
        }finally {
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

    public int editProduct(ProductType p) {
        int n = 0;
        String xSql = "UPDATE ProductType SET productID = ?,size = ? ,color = ? ,price = ?,wareHouseID = ?,quantity = ?,status = ? WHERE productTypeId = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, p.getProductID());
            pre.setString(2, p.getSize());
            pre.setString(3, p.getColor());
            pre.setString(4, p.getPrice());
            pre.setInt(5, p.getWareHouseID());
            pre.setInt(6, p.getQuantity());
            pre.setInt(7, p.getStatus());
            pre.setString(8, p.getProductTypeId());
            n = pre.executeUpdate();
            
        } catch (Exception e) {
        }finally {
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
    
    public int deleteProductType(String ProTypeId) {
        int n = 0;
        String sql = "delete from ProductType where productTypeId = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, ProTypeId);
            n = pre.executeUpdate();
            
        } catch (Exception e) {
        }finally {
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
    
    public int changeStatus(String id, int status) {
        int n = 0;
        String sql = "update ProductType set status = ? where productTypeId = ?";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setString(2, id);
            n = pre.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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

    public List<ProductType> searchProduct(String text) {
        List<ProductType> list = new ArrayList<>();
        String xSql = "SELECT distinct *FROM ProductType where productTypeId like '%" + text + "%' or productID like '%" + text + "%' or size like '%" + text + "%' or color like '%" + text + "%' or price like '%" + text + "%' or wareHouseID like '%" + text + "%' or quantity like '%" + text + "%'";
        try {
            conn=new DBConnection().getConnection();
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
        }finally {
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

    public boolean checkExistColor(String color) {
        String sql = "SELECT * FROM ProductType WHERE color = '" + color + "'";
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean checkExistSizeAndColor(String size, String color, int productId) {
        String sql = "SELECT * FROM ProductType WHERE size = '" + size + "' and color='" + color + "' and productID=" + productId;
        try {
            conn=new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                rs.close();
                pre.close();
                conn.close();
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
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

    public ArrayList<ProductType> getAllPagingProductType(int index, int numOfRow, String search, String pid) {
        int start=(index-1)*numOfRow;
        ArrayList<ProductType> list = new ArrayList<>();
        String xSql= "select * from producttype where productID = ? limit ?,?";
        try {
            conn=new DBConnection().getConnection();
            pre=conn.prepareStatement(xSql);
            pre.setString(1, pid);
            pre.setInt(2, start);
            pre.setInt(3, numOfRow);
            rs=pre.executeQuery();
            while(rs.next()){
                ProductType pt = new ProductType();
                pt.setProductTypeId(rs.getString("productTypeId"));
                pt.setQuantity(rs.getInt("productID"));
                pt.setSize(rs.getString("size"));
                pt.setColor(rs.getString("color"));
                pt.setPrice(rs.getString("price"));
                pt.setWareHouseID(rs.getInt("wareHouseID"));
                pt.setQuantity(rs.getInt("quantity"));
                pt.setStatus(rs.getInt("status"));
                list.add(pt);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
    public ArrayList<ProductType> getAllPagingProductTypeBySeller(int index, int numOfRow, String search, int sellerID) {
        int start=(index-1)*numOfRow;
        ArrayList<ProductType> list = new ArrayList<>();
        String xSql= "SELECT * FROM producttype pt inner join product p on pt.productID = p.productID \n" +
                        "where p.sellerID = ? limit ?,?";
        try {
            conn=new DBConnection().getConnection();
            pre=conn.prepareStatement(xSql);
            pre.setInt(1, sellerID);
            pre.setInt(2, start);
            pre.setInt(3, numOfRow);
            rs=pre.executeQuery();
            while(rs.next()){
                ProductType pt = new ProductType();
                pt.setProductTypeId(rs.getString("productTypeId"));
                pt.setQuantity(rs.getInt("productID"));
                pt.setSize(rs.getString("size"));
                pt.setColor(rs.getString("color"));
                pt.setPrice(rs.getString("price"));
                pt.setWareHouseID(rs.getInt("wareHouseID"));
                pt.setQuantity(rs.getInt("quantity"));
                pt.setStatus(rs.getInt("status"));
                list.add(pt);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
