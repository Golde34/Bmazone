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
public class Seller implements Serializable {
    private static final long serialVersionUID = 1;
    private int sellerID;
    private int userID;
    private String sellerShopName;
    private String sellerPhone;
    private String evidence;
    private int sellerMainProduct;
    private String description;
    private int sellerVerification;
    private String backGroundImage;
    private String avatar;
    private int status;

    public Seller() {
    }

    public Seller(int sellerID, int userID, String sellerShopName, String sellerPhone, String evidence, int sellerMainProduct, String description, int sellerVerification, int status) {
        this.sellerID = sellerID;
        this.userID = userID;
        this.sellerShopName = sellerShopName;
        this.sellerPhone = sellerPhone;
        this.evidence = evidence;
        this.sellerMainProduct = sellerMainProduct;
        this.description = description;
        this.sellerVerification = sellerVerification;
        this.status = status;
    }

    public Seller(int userID, String sellerShopName, String sellerPhone, String evidence, int sellerMainProduct, String description, int sellerVerification) {
        this.userID = userID;
        this.sellerShopName = sellerShopName;
        this.sellerPhone = sellerPhone;
        this.evidence = evidence;
        this.sellerMainProduct = sellerMainProduct;
        this.description = description;
        this.sellerVerification = sellerVerification;
    }
    
    public Seller(int sellerID, int userID, String sellerShopName, String sellerPhone, String evidence, int sellerMainProduct, String description, int sellerVerification, String backGroundImage, String avatar, int status) {
        this.sellerID = sellerID;
        this.userID = userID;
        this.sellerShopName = sellerShopName;
        this.sellerPhone = sellerPhone;
        this.evidence = evidence;
        this.sellerMainProduct = sellerMainProduct;
        this.description = description;
        this.sellerVerification = sellerVerification;
        this.backGroundImage = backGroundImage;
        this.avatar = avatar;
        this.status = status;
    }

    public Seller(int userID, String sellerShopName, String sellerPhone, String evidence, int sellerMainProduct, String description, int sellerVerification, String backGroundImage, String avatar) {
        this.userID = userID;
        this.sellerShopName = sellerShopName;
        this.sellerPhone = sellerPhone;
        this.evidence = evidence;
        this.sellerMainProduct = sellerMainProduct;
        this.description = description;
        this.sellerVerification = sellerVerification;
        this.backGroundImage = backGroundImage;
        this.avatar = avatar;
    }
    
    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getSellerShopName() {
        return sellerShopName;
    }

    public void setSellerShopName(String sellerShopName) {
        this.sellerShopName = sellerShopName;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public int getSellerMainProduct() {
        return sellerMainProduct;
    }

    public void setSellerMainProduct(int sellerMainProduct) {
        this.sellerMainProduct = sellerMainProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSellerVerification() {
        return sellerVerification;
    }

    public void setSellerVerification(int sellerVerification) {
        this.sellerVerification = sellerVerification;
    }

    public String getBackGroundImage() {
        return backGroundImage;
    }

    public void setBackGroundImage(String backGroundImage) {
        this.backGroundImage = backGroundImage;
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
