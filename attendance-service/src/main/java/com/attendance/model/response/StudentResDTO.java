package com.attendance.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResDTO {
    private boolean success;
    private Student payload;
}
