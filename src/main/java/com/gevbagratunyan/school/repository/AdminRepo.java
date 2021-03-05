package com.gevbagratunyan.school.repository;

import com.gevbagratunyan.school.entity.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo  extends JpaRepository<Admin, Long> {
    Optional<Admin> findByMailAndPassword(String mail, String password);
}
