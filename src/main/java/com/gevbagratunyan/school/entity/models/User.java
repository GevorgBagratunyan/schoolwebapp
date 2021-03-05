package com.gevbagratunyan.school.entity.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "Email", nullable = false, unique = true)
    private String mail;

    @Column(name = "permissions")
    private String permissions = "";

    @Column(name = "Created_Date",nullable = false)
    private Date createdDate;

    @Column(name = "Updated_Date")
    private Date updatedDate;

    @Column(name = "logged_in_state")
    private boolean isLoggedIn;

    public List<String> getPermissionsList(){
        if(permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }


}
