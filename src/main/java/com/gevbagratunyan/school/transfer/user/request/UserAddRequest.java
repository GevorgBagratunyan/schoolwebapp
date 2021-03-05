package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserAddRequest {

    @NotEmpty
    @Pattern(regexp = "[A-Za-z]+", message = "Your name must contain only letters")
    private String name;

    @NotEmpty
    @Min(value = 7, message = "Your age must be greater than 6")
    private int age;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8)
    private String password;

    @NotEmpty
    @Email(message = "Email should be in valid form")
    private String mail;

}
