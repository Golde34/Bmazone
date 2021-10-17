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

    public void deleteGallery(int id) {
        String sql = "delete from Gallery where galleryID = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addGallery(Gallery g) {
        String xSql = "INSERT INTO Gallery ([galleryID],[productID],[productTypeID],[link],[status])\n"
                + "     VALUES (?,?,?,?,?)";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, g.getGalleryID());
            pre.setInt(2, g.getProductID());
            pre.setString(3, g.getProductTypeID());
            pre.setString(4, g.getLink());
            pre.setDouble(5, g.getStatus());
            pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            pre.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int getPageNumber(String search) {
        int num = 0;
        String xSql = "SELECT COUNT(*) from Gallery g join ProductType pt on g.productTypeID=pt.productTypeId join Product p on pt.productID=p.productID join [User] u on p.sellerID=u.userID\n"
                + "   where p.productName like '%" + search + "%' or pt.size like '%" + search + "%' or pt.color like '%" + search + "%' or u.fullname like '%" + search + "%'";
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

    public Gallery getGalleryById(int id) {
        Gallery gallery = new Gallery();
        String sql = "SELECT * FROM [Bmazon].[dbo].[Gallery] where galleryID=" + id;
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

    public int changeStatus(int id, int status) {
        int n = 0;
        String sql = "UPDATE [Gallery] SET status = ? WHERE galleryID = ? ";
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, (status == 1 ? 1 : 0));
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public List<Gallery> getAllGallery() {
        List<Gallery> list = new ArrayList<>();
        String xSql = "select * from [Gallery] order by productID asc";
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
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Gallery> getAllPagingGallery(int index, int numOfRow, String search) {
        List<Gallery> list = new ArrayList<>();
        String xSql = "declare @PageNo INT ="+index+"\n"
                + "declare @PageSize INT="+numOfRow+"\n"
                + "SELECT * from(\n"
                + "SELECT g.*,\n"
                + "ROW_NUMBER() over (order by g.galleryID) as RowNum\n"
                + "  FROM Gallery g join ProductType pt on g.productTypeID=pt.productTypeId join Product p on pt.productID=p.productID join Seller s on p.sellerID=s.sellerID\n"
                + "   where g.[status]=1 and(p.productName like '%"+search+"%' or pt.size like '%"+search+"%' or pt.color like '%"+search+"%' or s.sellerShopName like '%"+search+"%'))T\n"
                + "where T.RowNum between ((@PageNo-1)*@PageSize)+1 and (@PageNo*@PageSize)";
        try {
            pre = conn.prepareStatement(xSql);
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
        String xSql = "select * from [Gallery] where productID =" + pid + "";
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
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String getSampleOfProduct(int pid) {
        String s = null;
        String xSql = "select top 1 link from [Gallery] WHERE productID =?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                s = rs.getString("link");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public String getImageByProductTypeID(String ps) {
        String s = null;
        String xSql = "select top 1 link from [Gallery] WHERE productTypeID = ?";
        try {
            pre = conn.prepareStatement(xSql);
            pre.setString(1, ps);
            rs = pre.executeQuery();
            while (rs.next()) {
                s = rs.getString("link");
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

//    public List<Gallery> getGalleryBySizeAndColor(ProductType p) {
//        List<Gallery> list = new ArrayList<>();
//        xSql = "select from ";
//        try {
//            ps = conn.prepareStatement(xSql);
//            ps.setString(1, p.getProductTypeId());
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Gallery(
//                        rs.getInt(1),
//                        rs.getInt(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getInt(5)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
    public static void main(String[] args) {
        GalleryDAO g = new GalleryDAO();
        Gallery ga = g.getGalleryById(1);
        ga.setLink("Pr1Ty1Ga1.jpg");
        g.editGallery(ga);
    }
}
