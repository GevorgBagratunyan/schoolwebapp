package com.gevbagratunyan.school.entity.models;

import com.gevbagratunyan.school.entity.enums.Role;
import javafx.beans.DefaultProperty;
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

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "Email", nullable = false, unique = true)
    private String mail;

    @Column(name = "permissions")
    private String permissions = "";

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.GUEST;

    @Column(name = "Created_Date",nullable = false)
    private Date createdDate;

    @Column(name = "Updated_Date")
    private Date updatedDate;

    @Column(name = "logged_in_state")
    private boolean isLoggedIn=false;

    public List<String> getPermissionsList(){
        if(permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }


}
