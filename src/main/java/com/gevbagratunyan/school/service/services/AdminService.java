package com.gevbagratunyan.school.service.services;

import com.gevbagratunyan.school.entity.models.Admin;
import com.gevbagratunyan.school.repository.AdminRepo;
import com.gevbagratunyan.school.service.crud.CreateSupported;
import com.gevbagratunyan.school.service.crud.DeleteSupported;
import com.gevbagratunyan.school.service.crud.ReadSupported;
import com.gevbagratunyan.school.service.crud.UpdateSupported;
import com.gevbagratunyan.school.transfer.admin.request.AdminAddRequest;
import com.gevbagratunyan.school.transfer.admin.request.AdminUpdateRequest;
import com.gevbagratunyan.school.transfer.admin.response.AdminResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class AdminService implements CreateSupported<AdminAddRequest, AdminResponse>, UpdateSupported<Long, AdminUpdateRequest, AdminResponse>,
        ReadSupported<Long, AdminResponse>, DeleteSupported<Long> {

    private final AdminRepo adminRepository;
    private PasswordEncoder passwordEncoder;

    public AdminService(AdminRepo adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AdminResponse add(AdminAddRequest adminAddRequest) {
        Admin admin = new Admin();
        admin.setUsername(adminAddRequest.getUsername());
        admin.setPassword(passwordEncoder.encode(adminAddRequest.getPassword()));
        admin.setMail(adminAddRequest.getMail());
        Admin savedAdmin =  adminRepository.save(admin);
        AdminResponse adminResponse = new AdminResponse();
        BeanUtils.copyProperties(savedAdmin,adminResponse);
        return adminResponse;
    }

    @Override
    public void delete(Long id) {
        boolean exists = adminRepository.existsById(id);
        if (!exists) {
            throw new NoSuchElementException("Admin not found");
        }
        adminRepository.deleteById(id);

    }

    @Override
    public AdminResponse get(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admin not found"));
        AdminResponse response = new AdminResponse();
        BeanUtils.copyProperties(admin, response);
        return response;
    }

    @Override
    public AdminResponse update(Long id, AdminUpdateRequest updateRequest) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admin not found"));
        BeanUtils.copyProperties(updateRequest, admin);
        Admin updatedAdmin = adminRepository.save(admin);
        AdminResponse response = new AdminResponse();
        BeanUtils.copyProperties(updatedAdmin, response);
        return response;
    }

    public AdminResponse getByUsernameAndPassword(String username, String password){
        Admin admin = adminRepository.findByUsernameAndPassword(username,passwordEncoder.encode(password)).
                orElseThrow(() -> new NoSuchElementException("Admin not found"));
        AdminResponse response = new AdminResponse();
        BeanUtils.copyProperties(admin,response);
        return response;
    }

    public void setLoggedIn(Long id,boolean isLoggedIn){
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admin not found"));
        admin.setLoggedIn(isLoggedIn);
        adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }
}
