/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class User {

    //private profile
    private String userId;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private int sell;
    //wallet
    private double wallet;
    //public profile
    private String fullname;
    private String publicName;
    private String address;
    private String profileImage;
    private String backgroundImage;
    private String occupation;
    private int gender;
    private Date DOB;
    private String bio;
    //social link
    private String Facebook;
    private String Instagram;
    private String Twitter;
    private String Youtube;
    //admin management information
    private int activityPoint;
    private int systemRole;
    private int status;

    public User() {
    }

    public User(String userId, String username, String password, String address, String bio, String Facebook, String Instagram, String Twitter, String Youtube) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.address = address;
        this.bio = bio;
        this.Facebook = Facebook;
        this.Instagram = Instagram;
        this.Twitter = Twitter;
        this.Youtube = Youtube;
    }

    public User(String userId, String username, String password, String email, String phoneNumber, int sell, double wallet, String fullname, String publicName, String address, String profileImage, String backgroundImage, String occupation, int gender, Date DOB, String bio, String Facebook, String Instagram, String Twitter, String Youtube, int activityPoint, int systemRole, int status) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sell = sell;
        this.wallet = wallet;
        this.fullname = fullname;
        this.publicName = publicName;
        this.address = address;
        this.profileImage = profileImage;
        this.backgroundImage = backgroundImage;
        this.occupation = occupation;
        this.gender = gender;
        this.DOB = DOB;
        this.bio = bio;
        this.Facebook = Facebook;
        this.Instagram = Instagram;
        this.Twitter = Twitter;
        this.Youtube = Youtube;
        this.activityPoint = activityPoint;
        this.systemRole = systemRole;
        this.status = status;
    }

    public User(String username, String password, String email, String phoneNumber, int sell, double wallet, String fullname, String publicName, String address, String profileImage, String backgroundImage, String occupation, int gender, String bio, String Facebook, String Instagram, String Twitter, String Youtube, int activityPoint, int systemRole, int status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sell = sell;
        this.wallet = wallet;
        this.fullname = fullname;
        this.publicName = publicName;
        this.address = address;
        this.profileImage = profileImage;
        this.backgroundImage = backgroundImage;
        this.occupation = occupation;
        this.gender = gender;
        this.bio = bio;
        this.Facebook = Facebook;
        this.Instagram = Instagram;
        this.Twitter = Twitter;
        this.Youtube = Youtube;
        this.activityPoint = activityPoint;
        this.systemRole = systemRole;
        this.status = status;
    }

    public User(String username, String password, String email, int sell, String fullname,String publicName, int systemRole, int status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.sell = sell;
        this.fullname = fullname;
        this.publicName = publicName;
        this.systemRole = systemRole;
        this.status = status;
    }
    
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String Facebook) {
        this.Facebook = Facebook;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String Instagram) {
        this.Instagram = Instagram;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String Twitter) {
        this.Twitter = Twitter;
    }

    public String getYoutube() {
        return Youtube;
    }

    public void setYoutube(String Youtube) {
        this.Youtube = Youtube;
    }

    public int getActivityPoint() {
        return activityPoint;
    }

    public void setActivityPoint(int activityPoint) {
        this.activityPoint = activityPoint;
    }

    public int getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(int systemRole) {
        this.systemRole = systemRole;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
