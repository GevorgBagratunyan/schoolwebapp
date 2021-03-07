package com.gevbagratunyan.school;

import com.gevbagratunyan.school.entity.data.EmployeeBanking;
import com.gevbagratunyan.school.entity.enums.Position;
import com.gevbagratunyan.school.entity.enums.Role;
import com.gevbagratunyan.school.entity.enums.Specialization;
import com.gevbagratunyan.school.entity.models.Employee;
import com.gevbagratunyan.school.entity.models.User;
import com.gevbagratunyan.school.repository.EmployeeRepo;
import com.gevbagratunyan.school.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepo userRepo;
    private EmployeeRepo employeeRepo;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepo userRepo, PasswordEncoder passwordEncoder, EmployeeRepo employeeRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.employeeRepo=employeeRepo;
    }

    @Override
    public void run(String... args) {

//        Employee employee = new Employee();
//        EmployeeBanking banking=new EmployeeBanking();
//        banking.setBankCard("1234-2345-3456-4567");
//        banking.setSalary(250000);
//        banking.setBalance(23000);
//        employee.setEmployeeBanking(banking);
//        employee.setName("Poxosyan Petrtos");
//        employee.setPosition(Position.DEP_DIR);
//        employee.setSpecialization(Specialization.ARM_HIST);
//        employee.setCreatedDate(new Date(System.currentTimeMillis()));
//        employee.setMail("poxosyan@mail.ru");
//        employee.setIdCard("0010020034");
//
//        employeeRepo.save(employee);

//
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
