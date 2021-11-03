/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Gallery;
import entity.Product;
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
public class GalleryDAO extends BaseDAO {

    BaseDAO dbConn = new BaseDAO();

    public int deleteGallery(int id) {
        int n = 0;
        String sql = "delete from Gallery where galleryID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int addGallery(Gallery g) {
        int n = 0;
        String xSql = "INSERT INTO Gallery(productID ,productTypeID ,link,status)\n"
                + "VALUES (?, ?,? ,?)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, g.getProductID());
            pre.setString(2, g.getProductTypeID());
            pre.setString(3, g.getLink());
            pre.setInt(4, g.getStatus());
            n = pre.executeUpdate();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int editGallery(Gallery g) {
        int n = 0;
        String xSql = "update Gallery set productID = ?, productTypeID = ?, link =?, status = ? where galleryID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, g.getProductID());
            pre.setString(2, g.getProductTypeID());
            pre.setString(3, g.getLink());
            pre.setDouble(4, g.getStatus());
            pre.setInt(5, g.getGalleryID());
            n = pre.executeUpdate();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) AS NumberOfGallerys FROM gallery,product where gallery.productID=product.productID and product.productName like '%"+search+"%'";
        try {
            pre=conn.prepareStatement(xSql);
            rs=pre.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
            rs.close();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }

    public Gallery getGalleryById(int id) {
        Gallery gallery = new Gallery();
        String sql = "SELECT * FROM Gallery where galleryID=" + id;
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                gallery.setGalleryID(id);
                gallery.setLink(rs.getString("link"));
                gallery.setProductID(rs.getInt("productID"));
                gallery.setProductTypeID(rs.getString("productTypeID"));
                gallery.setStatus(rs.getInt("status"));
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return gallery;
    }
    
    public Gallery getDefaultGalleryByProductTypeId(String id) {
        Gallery gallery = new Gallery();
        String sql = "SELECT * FROM Gallery where productTypeID = ? ORDER BY GalleryID asc LIMIT 1 ";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                gallery.setGalleryID(rs.getInt("galleryID"));
                gallery.setLink(rs.getString("link"));
                gallery.setProductID(rs.getInt("productID"));
                gallery.setProductTypeID(rs.getString("productTypeID"));
                gallery.setStatus(rs.getInt("status"));
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return gallery;
    }
    
    public Gallery getRevertGalleryByProductTypeId(String id) {
        Gallery gallery = new Gallery();
        String sql = "SELECT * FROM Gallery where productTypeID = ? ORDER BY GalleryID desc LIMIT 1 ";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                gallery.setGalleryID(rs.getInt("galleryID"));
                gallery.setLink(rs.getString("link"));
                gallery.setProductID(rs.getInt("productID"));
                gallery.setProductTypeID(rs.getString("productTypeID"));
                gallery.setStatus(rs.getInt("status"));
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return gallery;
    }

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "UPDATE Gallery SET status = ? WHERE galleryID = ? ";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setInt(2, id);
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public List<Gallery> getAllGallery() {
        List<Gallery> list = new ArrayList<>();
        String xSql = "select * from Gallery order by productID asc";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
            rs.close();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Gallery> getAllPagingGallery(int index, int numOfRow, String search) {
        int start=(index-1)*numOfRow;
        List<Gallery> list = new ArrayList<>();
        String xSql = "SELECT * FROM gallery,product where gallery.productID=product.productID and product.productName like '%"+search+"%' LIMIT ?,?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, start);
            pre.setInt(2, numOfRow);
            rs = pre.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setGalleryID(rs.getInt("galleryID"));
                gallery.setLink(rs.getString("link"));
                gallery.setProductID(rs.getInt("productID"));
                gallery.setProductTypeID(rs.getString("productTypeId"));
                gallery.setStatus(rs.getInt("status"));
                list.add(gallery);
            }
            rs.close();
            pre.close();
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public List<Gallery> getAllGalleryOfProduct(int pid) {
        List<Gallery> list = new ArrayList<>();
        String xSql = "select * from Gallery where productID =" + pid + "";
        try {
            pre = conn.prepareStatement(xSql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
            rs.close();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String getSampleOfProduct(int pid) {
        String s = null;
        String xSql = "select link from Gallery WHERE productID =? limit 0,1";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                s = rs.getString("link");
            }
            rs.close();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public String getImageByProductTypeID(String ps) {
        String s = null;
        String xSql = "select link from Gallery WHERE productTypeID = ? limit 0,1";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, ps);
            rs = pre.executeQuery();
            if (rs.next()) {
                s = rs.getString("link");
            }
            rs.close();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public List<Gallery> getAllImageByProductTypeID(String ptypeID) {
        List<Gallery> list = new ArrayList<>();
        String xSql = "select * from Gallery WHERE productTypeID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, ptypeID);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
            rs.close();
            pre.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void main(String[] args) {
        GalleryDAO dao = new  GalleryDAO();
        System.out.println(dao.getSampleOfProduct(1));
    }

}
