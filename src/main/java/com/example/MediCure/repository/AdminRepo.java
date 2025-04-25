package com.example.MediCure.repository;

import com.example.MediCure.model.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminInfo, Integer>
{
    AdminInfo findByAdminNameAndAdminPass(String adminName, String adminPass);
}
