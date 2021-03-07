package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UserUpdateRequest {
    @Size(min=3)
    private String name;
    @Size(min = 7)
    private String password;
    @Email
    private String mail;
}
