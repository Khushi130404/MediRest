package com.example.MediCure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
