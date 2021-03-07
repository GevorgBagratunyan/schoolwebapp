package com.gevbagratunyan.school.transfer.user.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class PupilSetMarkRequest {
    @NotEmpty
    private String subject;
    @NotEmpty
    @Min(value = 0)
    @Max(value = 10)
    private byte mark;
}
