/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

    public int getPageNumberBySeller(String search, int sellerID) {
        int num = 0;
        String xSql = "SELECT COUNT(*)from Product p join Seller s on p.sellerID=s.sellerID join ProductCategory pc on p.productID=pc.productID join Category c on pc.categoryId=c.categoryID join ProductGenre pg on pg.productID=p.productID join Genre g on g.genreID=pg.genreID\n"
                + "   where p.productName like '%" + search + "%' and p.sellerID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, sellerID);
            rs = pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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

//hieu
    public ArrayList<Product> getAllPagingProduct(int index, int numOfRow, String search) {
        int start = (index - 1) * numOfRow;
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from product where productName like '%" + search + "%' limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
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
// nam

    public ArrayList<Product> getAllPagingProductBySeller(int index, int numOfRow, String search, String seller) {
        int start = (index - 1) * numOfRow;
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from product where sellerID = ? and productName like '%" + search + "%'  limit ?,?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, seller);
            pre.setInt(2, start);
            pre.setInt(3, numOfRow);
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

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product where status=1";
        try {
            conn = new DBConnection().getConnection();
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
//thinh

    public ArrayList<Product> getTrueProduct(int index) {
        ArrayList<Product> list = new ArrayList<>();
        int start = (index - 1) * 20;
        String sql
                = " SELECT * "
                + "   FROM Product p  \n "
                + " limit ? , ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, 20);
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

    public ArrayList<Product> getProductSale() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product limit 0,8";
        try {
            conn = new DBConnection().getConnection();
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

    public ArrayList<Product> getProductNew() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product order by releaseDate limit 0,8";
        try {
            conn = new DBConnection().getConnection();
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

    public ArrayList<Product> getNewProductSeller(String sid) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product where sellerID = ? order by releaseDate asc limit 0,8";
        try {
            conn = new DBConnection().getConnection();
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

    public ArrayList<Product> getProductApple() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product where description like '%apple%' limit 0,8";
        try {
            conn = new DBConnection().getConnection();
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

    public ArrayList<Product> getProductGear() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product p join ProductCategory pc on p.productID=pc.productId where pc.categoryId = 5 limit 0,8";
        try {
            conn = new DBConnection().getConnection();
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

    public ArrayList<Product> getProductBySellerPaging(int index, int sid) {

        ArrayList<Product> list = new ArrayList<>();
        int start = (index - 1) * 10;
        String sql
                = " SELECT * \n"
                + " FROM Product where sellerID = " + sid + " \n "
                + " limit ?,10";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
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

    public ArrayList<Product> getProductBySeller(String seller) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product where sellerID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(seller));
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

    public ArrayList<Product> getTop10ProductBySeller(String seller) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT  * FROM Product where sellerID = ? limit 0,10";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(seller));
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

    public ArrayList<Product> getProductSuggest(int userid) {

        ArrayList<Product> list = new ArrayList<>();
        String sql = "select p.productId,p.productname,`description`,rating,releaseDate,sellerID,status "
                + "from  productview as  pv "
                + "right join product as p on pv.productid= p.productid and userid = ? "
                + " order by click desc limit 0,16 ";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userid);
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
    public ArrayList<Product> getProductSuggest(int index,int userid) {

        ArrayList<Product> list = new ArrayList<>();
         int start = (index - 1) * 10;
   
        String sql = "select p.productId,p.productname,`description`,rating,releaseDate,sellerID,status from  productview as  pv right join product as p on pv.productid= p.productid and userid = " + userid
                + " order by click desc limit ?,20 ";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
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

    public Product getProductByID(int id) {
        Product pro = new Product();
        String sql = "SELECT * FROM Product where productID=" + id;
        try {
            conn = new DBConnection().getConnection();
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
        return pro;
    }

    public Product getProductLatest(int sellerID) {
        Product pro = new Product();
        String sql = "SELECT  * FROM Product where sellerID = ? order by productID desc limt 0,1";
        try {
            conn = new DBConnection().getConnection();
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
        return pro;
    }

    public int totalProductSeller(String sid) {
        int count = 0;

        String xSql = "SELECT count(*) from Product where sellerID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            pre.setString(1, sid);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
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
        return count;
    }

    public int totalRelatedProduct(int id) {
        int count = 0;
        String xSql = "SELECT count(*) FROM Product a join ProductCategory b on a.productID=b.productID where b.categoryId=(SELECT categoryId FROM ProductCategory WHERE productID=" + id + ")";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
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
        return count;
    }

    public int totalProduct() {
        int count = 0;

        String xSql = "SELECT count(*) FROM Product ";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
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
        return count;
    }

    public int totalSearchProduct(String text) {
        int count = 0;

        String xSql = "SELECT count(*) FROM Product where productName like '%" + text + "%' or productName like '%" + text + "%' or description like '%" + text + "%' or rating like '%" + text + "%'";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
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
        return count;
    }

  

    public ArrayList<Product> getProductByName(int index, String name) {
        ArrayList<Product> list = new ArrayList<>();
        int start = (index - 1) * 20;
        String s = "";
//        if (cate != null || cate.length != 0) {
//            s += "And( ";
//            for (int i = 0; i < cate.length - 1; i++) {
//                if (cate[i] != null || cate[i] != "") {
//
//                    s += "pc.categoryId= " + cate[i] + " ";
//                    if (i < cate.length - 2) {
//                        s += " or ";
//                    }
//                }
//            }
//        }
//        s += " ) ";
        String sql
                = " SELECT *\n  "
                + " FROM Product as p join productcategory as pc on p.productid=pc.productid  where (productName like '%" + name + "%' OR description like '%" + name + "%' )\n"
                + s
                + "limit ?,?   ";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, 20);
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
//de sau

    public ArrayList<Product> getProductByFilter(int index, String name, String s) {
        ArrayList<Product> list = new ArrayList<>();
        int start = (index - 1) * 20;
        String sql = "Select *"
                + "   FROM product as p join ProductCategory as pc on p.productID=pc.productID  where (productName like '%" + name + "%' OR description like '%" + name + "%') " + s + " \n "
                + " limt ?,?  ";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, 20);
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
      public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
          System.out.println(pd.getProductByID(90));
        //List<Product> x = pd.getProductByName(1, "", cate);
//        for (Product product : x) {
//            System.out.println(product);
//        }

    }
   

    public ArrayList<Product> getProductByCategory(int categoryID,int page) {
        ArrayList<Product> list = new ArrayList<>();
        int start=( page - 1 )* 20 ;
        String sql = " SELECT * FROM Product as a join ProductCategory as b on a.productID=b.productID \n"
                + " WHERE a.status=1 and b.categoryId ="+categoryID+" limit "+start+", 20 ";
        try {
            conn = new DBConnection().getConnection();
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
     public ArrayList<Product> getProductByGenre(int categoryID,int page) {
        ArrayList<Product> list = new ArrayList<>();
        int start=( page - 1 )* 20 ;
        String sql = " SELECT * FROM Product as a join ProductGenre as b on a.productID=b.productID \n"
                + " WHERE a.status=1 and b.genreId ="+categoryID+" limit "+start+", 20 ";
        try {
            conn = new DBConnection().getConnection();
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

    public ArrayList<Product> getProductBycate(int categoryID ) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product as a join ProductCategory as b on a.productID=b.productID \n"
                + "WHERE a.status=1 and b.categoryId=" + categoryID ;

        try {
            conn = new DBConnection().getConnection();
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
      public ArrayList<Product> getProductByGenre(int genreID ) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product as a join ProductGenre as b on a.productID=b.productID \n"
                + "WHERE a.status=1 and b.genreId=" + genreID ;

        try {
            conn = new DBConnection().getConnection();
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

    public ArrayList<Product> getRelatedProductByProductID(int id) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product a join ProductCategory b on a.productID=b.productID where b.categoryId=(SELECT categoryId FROM ProductCategory WHERE productID=" + id + ")";
        try {
            conn = new DBConnection().getConnection();
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
//quang

    public ArrayList<Product> getRelatedProductByProductIDPaging(int index, int id) {
        ArrayList<Product> list = new ArrayList<>();
        int start = (index - 1) * 10;
        String sql
                = " SELECT * \n  "
                + " FROM Product a join ProductCategory b on a.productID = b.productID where b.categoryId = (SELECT categoryId FROM ProductCategory WHERE productID=" + id + ") \n "
                + "limit ?,10";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
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

    public int addProduct(Product obj) {
        int n = 0;
        String sql = "INSERT INTO [Bmazon].[dbo].[Product]([productName],[description],[rating],[releaseDate],[sellerID],[status])"
                + "VALUES(?,?,?,?,?,1)";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getProductName());
            pre.setString(2, obj.getDescription());
            pre.setInt(3, obj.getRating());
            pre.setDate(4, obj.getReleaseDate());
            pre.setInt(5, obj.getSeller());
            n = pre.executeUpdate();

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
        return n;
    }

    public int updateProduct(Product obj) {
        int n = 0;
        String sql = "UPDATE Product\n"
                + "   SET productName = ?"
                + "      ,`description` = ?"
                + "      ,rating = ?"
                + "      ,releaseDate = ?"
                + "      ,sellerID = ?"
                + "      ,status = ?"
                + " WHERE productID=?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getProductName());
            pre.setString(2, obj.getDescription());
            pre.setInt(3, obj.getRating());
            pre.setDate(4, obj.getReleaseDate());
            pre.setInt(5, obj.getSeller());
            pre.setInt(6, obj.getStatus());
            pre.setInt(7, obj.getProductID());
            n = pre.executeUpdate();

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
        return n;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "update Product set status = ? where productID = ?";
        try {
            conn = new DBConnection().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
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

}
