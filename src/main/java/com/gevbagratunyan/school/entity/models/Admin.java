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

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "Email", nullable = false, unique = true)
    private String mail;

    @Column(name = "permissions")
    private String permissions = "";

    @Column(name = "logged_in_state")
    private boolean isLoggedIn;

    public List<String> getPermissionsList(){
        if(permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
