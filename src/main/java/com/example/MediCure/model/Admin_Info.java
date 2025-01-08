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
public class Admin_Info {

    @Id
    @GeneratedValue
    int admin_id;

    @Column
    String admin_name;

    @Column
    String admin_pass;

    public Admin_Info(){}

    public Admin_Info(String admin_name, String admin_pass) {
        this.admin_name = admin_name;
        this.admin_pass = admin_pass;
    }
}
