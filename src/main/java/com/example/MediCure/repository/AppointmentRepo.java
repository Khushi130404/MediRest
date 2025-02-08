package com.example.MediCure.repository;

import com.example.MediCure.model.Appointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepo  extends JpaRepository<Appointment,Integer> {

    public Appointment findByAppId(int appId);

    @Transactional
    @Modifying
    @Query("delete from Appointment ap where ap.appId =:appId")
    public void deleteByAppId(int appId);

    public List<Appointment> findByDocId(int docId);

    @Query("select ap from Appointment ap where ap.docId = :docId AND STR_TO_DATE(ap.date, '%d-%m-%Y')  >= STR_TO_DATE(:currentDate, '%d-%m-%Y')")
    public List<Appointment> getFutureAppointmentByDocId(int docId,String currentDate);

    @Query(value = "select * from Appointment where doc_id = :docId and STR_TO_DATE(date, '%d-%m-%Y') < STR_TO_DATE(:date, '%d-%m-%Y') and STR_TO_DATE(date, '%d-%m-%Y') >= DATE_SUB(STR_TO_DATE(:date, '%d-%m-%Y'), INTERVAL 1 WEEK)", nativeQuery = true)
    public List<Appointment> getPastAppointmentByDocId(@Param("docId") int docId, @Param("date") String date);

    @Query("select * from Appointment where doc_id = :docId")
    public List<Appointment> getAllPastAppointmentByDocId(int docId);
}
