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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorMail() {
        return doctorMail;
    }

    public void setDoctorMail(String doctorMail) {
        this.doctorMail = doctorMail;
    }

    public String getDoctorPass() {
        return doctorPass;
    }

    public void setDoctorPass(String doctorPass) {
        this.doctorPass = doctorPass;
    }

    public int getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(int doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    public String getDoctorMobile() {
        return doctorMobile;
    }

    public void setDoctorMobile(String doctorMobile) {
        this.doctorMobile = doctorMobile;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
}
