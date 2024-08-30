package com.studentservice.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVO {
    private String firstName;
    private String lastName;
    private String gender;

    private String dob;
    private String address;
    private String email;
    private String phoneNum;
}
