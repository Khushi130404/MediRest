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
public class AdminInfo
{
    @Id
    @GeneratedValue
    int adminId;

    @Column
    String adminName;

    @Column
    String adminPass;

    public AdminInfo(){}

    public AdminInfo(String adminName, String adminPass) {
        this.adminName = adminName;
        this.adminPass = adminPass;
    }
}
