package com.gevbagratunyan.school.service.services;

import com.gevbagratunyan.school.entity.enums.Role;
import com.gevbagratunyan.school.entity.models.User;
import com.gevbagratunyan.school.repository.UserRepo;
import com.gevbagratunyan.school.service.crud.CreateSupported;
import com.gevbagratunyan.school.service.crud.DeleteSupported;
import com.gevbagratunyan.school.service.crud.ReadSupported;
import com.gevbagratunyan.school.service.crud.UpdateSupported;
import com.gevbagratunyan.school.transfer.user.request.UserAddRequest;
import com.gevbagratunyan.school.transfer.user.request.UserUpdateRequest;
import com.gevbagratunyan.school.transfer.user.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService implements CreateSupported<UserAddRequest, UserResponse>, UpdateSupported<Long, UserUpdateRequest, UserResponse>,
        ReadSupported<Long, UserResponse>, DeleteSupported<Long> {

    private final UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse add(UserAddRequest userAddRequest) {
        User user = new User();
        user.setUsername(userAddRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userAddRequest.getPassword()));
        user.setMail(userAddRequest.getMail());
        user.setCreatedDate(new Date(System.currentTimeMillis()));
        user.setRole(Role.stringToEnum(userAddRequest.getRole()));
        user.setPermissions(userAddRequest.getPermissions());
        user.setAge(userAddRequest.getAge());

        User savedUser =  userRepo.save(user);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(savedUser, userResponse);
        userResponse.setRole(savedUser.getRole().toString());
        return userResponse;
    }

    @Override
    public void delete(Long id) {
        boolean exists = userRepo.existsById(id);
        if (!exists) {
            throw new NoSuchElementException("User not found");
        }
        userRepo.deleteById(id);

    }

    @Override
    public UserResponse get(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
        response.setRole(user.getRole().toString());
        return response;
    }

    @Override
    public UserResponse update(Long id, UserUpdateRequest updateRequest) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        BeanUtils.copyProperties(updateRequest, user);
        User updatedUser = userRepo.save(user);
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(updatedUser, response);
        return response;
    }

    public UserResponse getByUsernameAndPassword(String username, String password){
        User user = userRepo.findByUsernameAndPassword(username,passwordEncoder.encode(password)).
                orElseThrow(() -> new NoSuchElementException("User not found"));
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user,response);
        return response;
    }

    public void setLoggedIn(Long id,boolean isLoggedIn){
        User user = userRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        user.setLoggedIn(isLoggedIn);
        userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
