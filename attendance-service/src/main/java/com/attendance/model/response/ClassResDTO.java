package com.attendance.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClassResDTO {
    private String name;
    private String academicYear;
}
