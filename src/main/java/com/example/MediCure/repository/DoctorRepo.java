package com.example.MediCure.repository;

import com.example.MediCure.model.DoctorInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepo extends JpaRepository<DoctorInfo,Integer>
{
    public DoctorInfo findByDoctorMailAndDoctorPass(String mail, String pass);

    public DoctorInfo findByDoctorId(int docId);

    @Transactional
    @Modifying
    @Query("delete DoctorInfo di where di.doctorId = :doctorId")
    public void deleteDoctor(int doctorId);

    @Transactional
    @Modifying
    @Query("update DoctorInfo di set di.doctorName = :name, di.doctorMail = :mail, di.doctorAge = :age, di.doctorMobile = :mobile, di.doctorAddress = :address, di.doctorGender = :gender, di.specialist = :specialist where di.doctorId = :doctorId")
    public void updateDoctor(int doctorId, String name,String mail,int age,String mobile, String address, String gender,String specialist);

    @Query("select di.doctorName from DoctorInfo di where di.doctorId = :doctorId")
    public void findDoctorNameById(int doctorId);
}
