package com.studentservice.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private String studentId;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String address;
    private String phoneNumber;
}
