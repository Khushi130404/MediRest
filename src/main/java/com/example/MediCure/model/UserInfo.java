package com.example.MediCure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class UserInfo
{
    @Id
    @GeneratedValue
    public int userId;
    @Column
    public String userName;
    @Column
    public String userMail;
    @Column
    public String userPass;
    @Column
    public int userAge;
    @Column
    public String userGender;
    @Column
    public String userMobile;
    @Column
    public String userAddress;

    public UserInfo(){}

    public UserInfo(String userName, String userMail, String userPass, int userAge, String userGender, String userMobile, String userAddress) {
        this.userName = userName;
        this.userMail = userMail;
        this.userPass = userPass;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userMobile = userMobile;
        this.userAddress = userAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
