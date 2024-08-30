package com.attendance.controller;

import com.attendance.service.AttendanceService;
import com.attendance.vo.request.AttendanceVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;


    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/student/{userId}")
    public ResponseEntity getStudentAttendance(@PathVariable String userId) {
        return new ResponseEntity(attendanceService.getStudentAttendance(userId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity saveAttendance(@RequestBody AttendanceVO request) {
        return new ResponseEntity(attendanceService.saveAttendance(request), HttpStatus.OK);
    }


}
