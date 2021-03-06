package com.gevbagratunyan.school;

import com.gevbagratunyan.school.entity.enums.Role;
import com.gevbagratunyan.school.entity.models.Admin;
import com.gevbagratunyan.school.entity.models.User;
import com.gevbagratunyan.school.repository.AdminRepo;
import com.gevbagratunyan.school.repository.UserRepo;
import com.gevbagratunyan.school.transfer.admin.response.AdminResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

//        User user = new User();
//        user.setPassword(passwordEncoder.encode("123456789"));
//        user.setUsername("TestUser4");
//        user.setMail("testUser4@mail.ru");
//        user.setCreatedDate(new Date(System.currentTimeMillis()));
//        user.setRole(Role.ADMIN);
//
//        userRepo.save(user);

    }
}
