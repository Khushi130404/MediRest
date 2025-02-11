package com.example.MediCure.model;

import jakarta.persistence.*;

@Entity
public class Diagnosis {
    @Id
    @GeneratedValue()
    private int diagnosisId;

    @OneToOne
    @JoinColumn(name = "appId", referencedColumnName = "appId") // Establish foreign key relationship
    private Appointment appointment;

    @Lob
    private byte[] image;


    public Diagnosis() {}

    public Diagnosis(Appointment appointment, byte[] image) {
        this.appointment = appointment;
        this.image = image;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
