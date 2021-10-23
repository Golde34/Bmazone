/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author Admin
 */
public class ProductDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*)from Product p join Seller s on p.sellerID=s.sellerID join ProductCategory pc on p.productID=pc.productID join Category c on pc.categoryId=c.categoryID join ProductGenre pg on pg.productID=p.productID join Genre g on g.genreID=pg.genreID\n"
                + "   where p.productName like '%" + search + "%' or c.categoryName like '%" + search + "%' or g.genreName like '%" + search + "%' or s.sellerShopName like '%" + search + "%'";
        ResultSet rs = dbConn.getData(xSql);
        try {
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }

    public int getPageNumberBySeller(String search, int sellerID) {
        int num = 0;
        String xSql = "SELECT COUNT(*)from Product p join Seller s on p.sellerID=s.sellerID join ProductCategory pc on p.productID=pc.productID join Category c on pc.categoryId=c.categoryID join ProductGenre pg on pg.productID=p.productID join Genre g on g.genreID=pg.genreID\n"
                + "   where p.productName like '%" + search + "%' and p.sellerID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, sellerID);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }

    public ArrayList<Product> getAllPagingProduct(int index, int numOfRow, String search) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "declare @PageNo INT =" + index + "\n"
                + "declare @PageSize INT=" + numOfRow + "\n"
                + "SELECT * from(\n"
                + "SELECT p.*,s.sellerShopName,g.genreName,c.categoryName,\n"
                + "ROW_NUMBER() over (order by p.productID) as RowNum\n"
                + "  from Product p join Seller s on p.sellerID=s.sellerID join ProductCategory pc on p.productID=pc.productID join Category c on pc.categoryId=c.categoryID join ProductGenre pg on pg.productID=p.productID join Genre g on g.genreID=pg.genreID\n"
                + "   where p.productName like '%" + search + "%' or c.categoryName like '%" + search + "%' or g.genreName like '%" + search + "%' or s.sellerShopName like '%" + search + "%')T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getAllPagingProductBySeller(int index, int numOfRow, String search, String seller) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "declare @PageNo INT =" + index + "\n"
                + "declare @PageSize INT=" + numOfRow + "\n"
                + "SELECT * from(\n"
                + "SELECT productID,productName,[description],rating,sellerID,[User].fullname,releaseDate,Product.[status],\n"
                + "ROW_NUMBER() over (order by Product.productID) as RowNum\n"
                + "  FROM Product inner join [User] on Product.sellerID=[User].userID where Product.sellerID = " + seller + " and(productName like '%" + search + "%' ))T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product where status=1";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getTrueProduct(int index) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = " declare @PageNo INT = " + index + " \n"
                + " declare @PageSize INT=20 \n"
                + " SELECT * from( \n"
                + " SELECT *,\n  "
                + " ROW_NUMBER() over (order by releaseDate) as RowNum\n  "
                + "   FROM [Bmazon].[dbo].[Product] p ) as T \n "
                + " where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)  ";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getTrueProductPaging(int total, int end) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product  where status=1 order by releaseDate OFFSET " + total + " ROWS \n"
                + "FETCH NEXT " + end + " ROWS ONLY";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductSale() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 8 * FROM Product";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductNew() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 8 * FROM Product order by releaseDate";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    public ArrayList<Product> getNewProductSeller(String sid) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 6 * FROM Product where sellerID = ? order by releaseDate asc";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, sid);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public Product getProductLatest(int sellerID) {
        Product pro = new Product();
        String sql = "SELECT TOP 1 * FROM Product where sellerID = ? order by productID desc";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, sellerID);
            rs = pre.executeQuery();
            if (rs.next()) {
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> getProductApple() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 8 * FROM Product where description like '%apple%'";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductGear() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT price * FROM Product where description like '%apple%'";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductBySellerPaging(int index, String seller) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = " declare @PageNo INT = ? \n"
                + " declare @PageSize INT=10 \n"
                + " SELECT * from( \n"
                + " SELECT *,\n  "
                + " ROW_NUMBER() over (order by productID) as RowNum\n  "
                + "   FROM [Bmazon].[dbo].[Product] p  where sellerID = ?) as T \n "
                + " where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)  ";
        //String sql = "SELECT * FROM Product where seller = '" + seller + "'";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.setString(2, seller);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductBySeller(String seller) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product where sellerID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1,Integer.parseInt(seller));
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> searchProduct(String S) {
        ArrayList<Product> list = new ArrayList<>();
        return list;
    }

    public ArrayList<Product> getProductSuggest() {

        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT TOP 16 * FROM Product order by releaseDate";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }


    public static void main(String[] args) {
        ProductDAO pDAO = new ProductDAO();
        System.out.println(pDAO.getNewProductSeller("1"));
    }

    public int totalProductSeller(String sid) {
        int count = 0;

        String xSql = "SELECT count(*) FROM [Bmazon].[dbo].[Product] where sellerID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, sid);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    public int totalRelatedProduct(int id) {
        int count = 0;
        String xSql = "SELECT count(*) FROM Product a join ProductCategory b on a.productID=b.productID where b.categoryId=(SELECT categoryId FROM ProductCategory WHERE productID=" + id + ")";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }
    
    public int totalProduct() {
        int count = 0;

        String xSql = "SELECT count(*) FROM [Bmazon].[dbo].[Product] ";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    public int totalSearchProduct(String text) {
        int count = 0;

        String xSql = "SELECT count(*) FROM [Bmazon].[dbo].[Product] where productName like '%" + text + "%' or productName like '%" + text + "%' or description like '%" + text + "%' or rating like '%" + text + "%'";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    public ArrayList<Product> getProductByName(int index, String name) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = " declare @PageNo INT = " + index + " \n"
                + " declare @PageSize INT=20 \n"
                + " SELECT * from( \n"
                + " SELECT *,\n  "
                + " ROW_NUMBER() over (order by productID) as RowNum\n  "
                + "   FROM [Bmazon].[dbo].[Product] p  where productName like '%" + name + "%' OR description like '%" + name + "%') as T \n "
                + " where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)  ";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductByFilter(int index, String name, int cateID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = " declare @PageNo INT = " + index + " \n"
                + " declare @PageSize INT=20 \n"
                + " SELECT * from( \n"
                + " SELECT p.productID,p.productName,p.description,p.rating,p.releaseDate,p.sellerID,p.[status],\n  "
                + " ROW_NUMBER() over (order by p.productID) as RowNum \n  "
                + "  FROM Product p join ProductCategory pc on p.productID=pc.productID where productName like '%" + name + "%' OR description like '%" + name + "%' and categoryId= " + cateID + "  ) as T  \n "
                + " where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)  ";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public Product getProductByID(int id) {
        Product pro = new Product();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] where productID=" + id;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return pro;
    }

    public ArrayList<Product> getProductByCategory(int categoryID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] as a join ProductCategory as b on a.productID=b.productID\n"
                + "WHERE a.status=1 and b.categoryId=" + categoryID;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductByGenre(int genreID) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Product] as a join ProductGenre as b on a.productID=b.productID WHERE a.status=1 and b.genreID=" + genreID;

        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getRelatedProductByProductID(int id) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product a join ProductCategory b on a.productID=b.productID where b.categoryId=(SELECT categoryId FROM ProductCategory WHERE productID=" + id + ")";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    public ArrayList<Product> getRelatedProductByProductIDPaging(int index, int id) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = " declare @PageNo INT = ? \n"
                + " declare @PageSize INT=10 \n"
                + " SELECT * from( \n"
                + " SELECT a.productID, a.productName,a.description,a.rating,a.releaseDate,a.sellerID,a.status,\n  "
                + " ROW_NUMBER() over (order by a.productID) as RowNum\n  "
                + " FROM Product a join ProductCategory b on a.productID = b.productID where b.categoryId = (SELECT categoryId FROM ProductCategory WHERE productID=" + id + ")) as T \n "
                + " where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, index);
            rs = pre.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductID(rs.getInt("productID"));
                pro.setProductName(rs.getString("productName"));
                pro.setDescription(rs.getString("description"));
                pro.setRating(rs.getInt("rating"));
                pro.setReleaseDate(rs.getDate("releaseDate"));
                pro.setSeller(rs.getInt("sellerID"));
                pro.setStatus(rs.getInt("status"));
                list.add(pro);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public int addProduct(Product obj) {
        int n = 0;
        String sql = "INSERT INTO [Bmazon].[dbo].[Product]([productName],[description],[rating],[releaseDate],[sellerID],[status])"
                + "VALUES(?,?,?,?,?,1)";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getProductName());
            pre.setString(2, obj.getDescription());
            pre.setInt(3, obj.getRating());
            pre.setDate(4, obj.getReleaseDate());
            pre.setInt(5, obj.getSeller());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int updateProduct(Product obj) {
        int n = 0;
        String sql = "UPDATE [Bmazon].[dbo].[Product]\n"
                + "   SET [productName] = ?"
                + "      ,[description] = ?"
                + "      ,[rating] = ?"
                + "      ,[releaseDate] = ?"
                + "      ,[sellerID] = ?"
                + "      ,[status] = ?"
                + " WHERE productID=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getProductName());
            pre.setString(2, obj.getDescription());
            pre.setInt(3, obj.getRating());
            pre.setDate(4, obj.getReleaseDate());
            pre.setInt(5, obj.getSeller());
            pre.setInt(6, obj.getStatus());
            pre.setInt(7, obj.getProductID());
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Product set status = ? where productID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

}
