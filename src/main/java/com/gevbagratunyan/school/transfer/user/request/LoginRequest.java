package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {
    @NotEmpty
    @Email
    private String mail;
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8)
    private String password;
}
