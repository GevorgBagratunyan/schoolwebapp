package com.gevbagratunyan.school.entity.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "Email", unique = true)
    private String mail;

    @Column(name = "permissions")
    private String permissions = "";

    @Column(name = "logged_in_state")
    private boolean isLoggedIn=false;

    public List<String> getPermissionsList(){
        if(permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
