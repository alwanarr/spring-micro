package com.attendance.vo.request;

import com.attendance.enums.AttendanceStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceVO {
    private String studentId;
    private String teacherId;
    private String studentClassId;
    private String status;
    private String remarks;
}
