package com.gevbagratunyan.school.repository;

import com.gevbagratunyan.school.entity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsernameAndPassword(String mail, String password);
    User findByUsername(String username);
}
