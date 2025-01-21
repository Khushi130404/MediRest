package com.example.MediCure.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue
    public int appId;

    @Column
    public int docId;

    @Column
    public int userId;

    @Column
    public String startTime;

    @Column
    public String endTime;

    @Column
    public String date;

    public Appointment() {  }

    public Appointment(int docId, int userId, String startTime, String endTime, String date) {
        this.docId = docId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }
}