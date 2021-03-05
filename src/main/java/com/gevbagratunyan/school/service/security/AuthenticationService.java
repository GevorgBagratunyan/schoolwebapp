package com.gevbagratunyan.school.service.security;

import com.gevbagratunyan.school.repository.AdminRepo;
import com.gevbagratunyan.school.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private UserRepo userRepository;
    private AdminRepo adminRepository;

    public AuthenticationService(UserRepo userRepository, AdminRepo adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

//    public void login(UserLoginRequest userLoginRequest){
//        User user = userRepository.getByEmailAndPassword(userLoginRequest.getEMail(),userLoginRequest.getPassword());
//        user.setLoggedIn(true);
//        userRepository.updateUser(user);
//    }
//
//    public void login(AdminLoginRequest adminLoginRequest){
//        Admin admin = adminRepository.getByEmailAndPassword(adminLoginRequest.getEMail(),adminLoginRequest.getPassword());
//        admin.setLoggedIn(true);
//        adminRepository.updateAdmin(admin);
//    }
//
//    public void logoutUser(Long id){
//        User user = userRepository.getUserById(id);
//        user.setLoggedIn(false);
//        userRepository.updateUser(user);
//    }
//
//    public void logoutAdmin(Long id){
//        Admin admin = adminRepository.getAdminById(id);
//        admin.setLoggedIn(false);
//        adminRepository.updateAdmin(admin);
//    }
}
