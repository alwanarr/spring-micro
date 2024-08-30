package com.attendance.vo.request.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class StudentAttendanceVO {
    private String studentName;
    private LocalDate attendanceDate;

    private String status;

    private String className;
}
