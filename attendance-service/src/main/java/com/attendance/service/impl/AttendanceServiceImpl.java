package com.attendance.service.impl;

import com.attendance.entity.Attendance;
import com.attendance.model.response.ClassDTO;
import com.attendance.model.response.StudentResDTO;
import com.attendance.repository.AttendanceRepository;
import com.attendance.service.AttendanceService;
import com.attendance.service.InternalService;
import com.attendance.vo.request.AttendanceVO;
import com.attendance.vo.request.response.StudentAttendanceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    private final InternalService internalService;



    public AttendanceServiceImpl(AttendanceRepository attendanceRepository,
                                  InternalService internalService) {
        this.attendanceRepository = attendanceRepository;
        this.internalService = internalService;
    }

    @Override
    public Attendance saveAttendance(AttendanceVO request) {
        //TODO: check if student exist
        internalService.getStudent(request.getStudentId());

        Attendance data = Attendance.builder()
                .student(UUID.fromString(request.getStudentId()))
                .StudentClass(UUID.fromString(request.getStudentClassId()))
                .remarks(request.getRemarks())
                .status(request.getStatus()).build();
        return attendanceRepository.save(data);
    }

    @Override
    public List<StudentAttendanceVO> getStudentAttendance(String userId) {

        List<StudentAttendanceVO> students = attendanceRepository.findByStudent(UUID.fromString(userId))
                .stream().map(s -> {
                    StudentResDTO student = internalService.getStudent(String.valueOf(s.getStudent()));
                    ClassDTO className = internalService.getClassName(String.valueOf(s.getStudentClass()));
                    return StudentAttendanceVO.builder()
                            .attendanceDate(s.getAttendanceDate())
                            .studentName(student.getPayload().getFirstName().concat(" ").concat(student.getPayload().getLastName()))
                            .className(className.getPayload().getName())
                            .status(s.getStatus()).build();
                }).collect(Collectors.toList());

        return students;
    }
}
