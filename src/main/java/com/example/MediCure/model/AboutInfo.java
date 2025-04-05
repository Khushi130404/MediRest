package com.example.MediCure.model;

import jakarta.persistence.*;

@Entity
public class AboutInfo
{
    @Id
    @OneToOne
    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId")
    public DoctorInfo doctorInfo;

    @Column
    String about;

    public AboutInfo(DoctorInfo doctorInfo, String about) {
        this.doctorInfo = doctorInfo;
        this.about = about;
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
