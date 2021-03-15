package com.gevbagratunyan.school.transfer.user.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private int age;
    private String mail;
    private String role;
}
