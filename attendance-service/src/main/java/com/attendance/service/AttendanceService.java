package com.attendance.service;

import com.attendance.entity.Attendance;
import com.attendance.vo.request.AttendanceVO;
import com.attendance.vo.request.response.StudentAttendanceVO;

import java.util.List;

public interface AttendanceService {
    Attendance saveAttendance(AttendanceVO request);

    List<StudentAttendanceVO> getStudentAttendance(String userId);
}
