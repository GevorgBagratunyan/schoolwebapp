package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserAddRequest {
    @NotEmpty(message = "Name should not be empty")
    @Size(min=3, max = 50, message = "Name size should  be between 3 and 50 chars")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8)
    private String password;

    @NotEmpty
    @Email
    private String mail;
}
