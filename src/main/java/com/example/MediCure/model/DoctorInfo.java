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
public class DoctorInfo
{
    @Id
    @GeneratedValue
    public int doctorId;
    @Column
    public String doctorName;
    @Column
    public String doctorMail;
    @Column
    public String doctorPass;
    @Column
    public int doctorAge;
    @Column
    public String doctorGender;
    @Column
    public String doctorMobile;
    @Column
    public String doctorAddress;
    @Column
    public String specialist;

    public DoctorInfo(){}

    public DoctorInfo(String doctorName, String doctorMail, String doctorPass, int doctorAge, String doctorGender, String doctorMobile, String doctorAddress, String specialist) {
        this.doctorName = doctorName;
        this.doctorMail = doctorMail;
        this.doctorPass = doctorPass;
        this.doctorAge = doctorAge;
        this.doctorGender = doctorGender;
        this.doctorMobile = doctorMobile;
        this.doctorAddress = doctorAddress;
        this.specialist = specialist;
    }
}
