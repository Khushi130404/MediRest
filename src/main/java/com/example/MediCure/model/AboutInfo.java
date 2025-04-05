package com.example.MediCure.model;

import jakarta.persistence.*;

@Entity
public class AboutInfo {

    @Id
    @GeneratedValue
    private int aboutId;

    @OneToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
    private DoctorInfo doctorInfo;

    @Column
    private String about;

    public AboutInfo() {}

    public AboutInfo(DoctorInfo doctorInfo, String about) {
        this.doctorInfo = doctorInfo;
        this.about = about;
    }

    public int getAboutId() {
        return aboutId;
    }

    public DoctorInfo getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(DoctorInfo doctorInfo) {
        this.doctorInfo = doctorInfo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
