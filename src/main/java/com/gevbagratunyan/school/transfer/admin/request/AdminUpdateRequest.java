package com.gevbagratunyan.school.transfer.admin.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class AdminUpdateRequest {
    @Size(min=3)
    private String name;
    @Size(min = 7)
    private String password;
    @Email
    private String mail;
}
