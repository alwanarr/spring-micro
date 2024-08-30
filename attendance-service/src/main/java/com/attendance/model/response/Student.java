package com.attendance.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String address;
    private String phoneNumber;
}
