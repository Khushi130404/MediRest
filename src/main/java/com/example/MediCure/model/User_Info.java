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
public class User_Info
{
    @Id
    @GeneratedValue
    public int user_id;
    @Column
    public String user_name;
    @Column
    public String user_mail;
    @Column
    public String user_pass;
    @Column
    public int user_age;
    @Column
    public String user_gender;
    @Column
    public String user_mobile;
    @Column
    public String user_address;

    public User_Info(){}

    public User_Info(String user_name, String user_mail, String user_pass, int user_age, String user_gender, String user_mobile, String user_address) {
        this.user_name = user_name;
        this.user_mail = user_mail;
        this.user_pass = user_pass;
        this.user_age = user_age;
        this.user_gender = user_gender;
        this.user_mobile = user_mobile;
        this.user_address = user_address;
    }
}
