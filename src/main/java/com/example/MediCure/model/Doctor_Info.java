package com.example.MediCure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Doctor_Info
{
    @Id
    @GeneratedValue
    public int doctor_id;
    @Column
    public String doctor_name;
    @Column
    public String doctor_mail;
    @Column
    public String doctor_pass;
    @Column
    public int doctor_age;
    @Column
    public String doctor_gender;
    @Column
    public String doctor_mobile;
    @Column
    public String doctor_address;
    @Column
    public String specialist;

    public Doctor_Info(){}

    public Doctor_Info(String doctor_name, String doctor_mail, String doctor_pass, int doctor_age, String doctor_gender, String doctor_mobile, String doctor_address, String specialist) {
        this.doctor_name = doctor_name;
        this.doctor_mail = doctor_mail;
        this.doctor_pass = doctor_pass;
        this.doctor_age = doctor_age;
        this.doctor_gender = doctor_gender;
        this.doctor_mobile = doctor_mobile;
        this.doctor_address = doctor_address;
        this.specialist = specialist;
    }
}
