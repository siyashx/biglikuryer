package com.company.kotlinapp_apis.dao.admin;

import com.company.kotlinapp_apis.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByEmail(String email);
}
