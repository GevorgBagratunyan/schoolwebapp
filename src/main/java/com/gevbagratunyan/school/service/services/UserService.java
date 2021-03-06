package com.gevbagratunyan.school.service.services;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements CreateSupported<UserAddRequest, UserResponse>,
        UpdateSupported<Long, UserUpdateRequest, UserResponse>,
        ReadSupported<Long, UserResponse>,
        DeleteSupported<Long> {

    private final UserRepo userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserResponse add(UserAddRequest userAddRequest) {
        User user= new User();
        BeanUtils.copyProperties(userAddRequest, user);
        user.setCreatedDate(new Date(System.currentTimeMillis()));
        User savedUser =  userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(savedUser,userResponse);
        return userResponse;
    }

    @Override
    public void delete(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new NoSuchElementException("User not found");
        }
        userRepository.deleteById(id);

    }

    @Override
    public UserResponse get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
        return response;
    }

    @Override
    public UserResponse update(Long id, UserUpdateRequest updateRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        user.setUpdatedDate(new Date(System.currentTimeMillis()));
        BeanUtils.copyProperties(updateRequest, user);
        User updatedUser = userRepository.save(user);
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(updatedUser, response);
        return response;
    }




    public UserResponse getByUsernameAndPassword(String username, String password){
        User user = userRepository.findByUsernameAndPassword(username, passwordEncoder.encode(password)).
                orElseThrow(() -> new NoSuchElementException("User not found"));
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user,response);
        return response;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
