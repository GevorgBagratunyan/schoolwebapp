package com.gevbagratunyan.school;

import com.gevbagratunyan.school.repository.EmployeeRepo;
import com.gevbagratunyan.school.repository.PupilRepo;
import com.gevbagratunyan.school.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepo userRepo;
    private PupilRepo pupilRepo;
    private EmployeeRepo employeeRepo;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepo userRepo, PasswordEncoder passwordEncoder, EmployeeRepo employeeRepo, PupilRepo pupilRepo) {
        this.userRepo = userRepo;
        this.pupilRepo=pupilRepo;
        this.passwordEncoder = passwordEncoder;
        this.employeeRepo=employeeRepo;
    }

    @Override
    public void run(String... args) {


//        Pupil pupil=new Pupil();
//        FinalYearMarks yearMarks=new FinalYearMarks();
//        CurrentMarks weekMarks=new CurrentMarks();
//
//        pupil.setCurrentMarks(weekMarks);
//        pupil.setFinalYearMarks(yearMarks);
//        pupil.setClassname("7a");
//        pupil.setIdCard("0012475613");
//        pupil.setName("TestAVG Marks");
//        pupil.setMail("AvgMarks@mail.ru");
//        pupil.setCreatedDate(new Date(System.currentTimeMillis()));
//        weekMarks.getARM().put(new Timestamp(System.currentTimeMillis()), 7.0);
//        Thread.sleep(300);
//        weekMarks.getARM().put(new Timestamp(System.currentTimeMillis()), 8.0);
//        Thread.sleep(300);
//        weekMarks.getARM().put(new Timestamp(System.currentTimeMillis()), 10.0);
//        Thread.sleep(300);
//        Double avg = weekMarks.calculateAVG(Subject.ARM);
//        yearMarks.setYearMark(Subject.ARM,avg);
//        pupilRepo.save(pupil);

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
