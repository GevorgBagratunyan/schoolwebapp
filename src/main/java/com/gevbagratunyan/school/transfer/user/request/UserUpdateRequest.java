package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserUpdateRequest {
    @NotEmpty
    private String name;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8)
    private String password;
}
