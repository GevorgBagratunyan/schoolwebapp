package com.gevbagratunyan.school.repository;

import com.gevbagratunyan.school.entity.models.Admin;
import com.gevbagratunyan.school.entity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo  extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsernameAndPassword(String username, String password);
    Optional<Admin> findByUsername(String username);
}
