package com.studentservice.service.impl;

import com.studentservice.util.DateUtil;
import com.studentservice.entity.Student;
import com.studentservice.model.request.StudentDTO;
import com.studentservice.model.response.ResponseDTO;
import com.studentservice.repository.StudentRepository;
import com.studentservice.service.StudentService;
import com.studentservice.util.Convert;
import com.studentservice.vo.request.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service @Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseDTO getUsers() {
        List<StudentDTO> list = studentRepository.findAll().stream()
                .map(s -> {
                    return StudentDTO.builder()
                            .firstName(s.getFirstName())
                            .lastName(s.getLastName())
                            .address(s.getAddress())
                            .dob(s.getDateOfBirth() != null ? DateUtil.converString(s.getDateOfBirth()) : "")
                            .gender(s.getGender())
                            .phoneNumber(s.getPhoneNumber())
                            .studentId(String.valueOf(s.getId()))
                            .build();
                }).toList();
        return Convert.buildResponse(true, list);
    }

    @Override
    public ResponseDTO saveUser(StudentVO request) {
        Student student = mapToStudent(new Student(), request);
        Student data = studentRepository.save(student);
        return Convert.buildResponse(true, StudentDTO.builder().firstName(data.getFirstName())
                .lastName(data.getLastName())
                .address(data.getAddress())
                .dob(DateUtil.converString(data.getDateOfBirth()))
                .gender(data.getGender())
                .phoneNumber(data.getPhoneNumber())
                .studentId(String.valueOf(data.getId()))
                .build());
    }

    @Override
    public ResponseDTO getUser(String userId) {
        try {
            Student student = studentRepository.findById(UUID.fromString(userId))
                    .orElseThrow(() -> new RuntimeException("student not found"));
            return Convert.buildResponse(true, StudentDTO.builder().firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .address(student.getAddress())
                    .dob(DateUtil.converString(student.getDateOfBirth()))
                    .gender(student.getGender())
                    .phoneNumber(student.getPhoneNumber())
                    .studentId(String.valueOf(student.getId()))
                    .build());
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Convert.buildResponse(false, null);
        }
    }

    @Override
    public ResponseDTO updateUser(StudentVO request, String userId) {
        Optional<Student> studentOpt = studentRepository.findById(UUID.fromString(userId));

        if (studentOpt.isEmpty()) {
            log.info("student not found");
            return Convert.buildResponse(false, null);
        }
        Student student = mapToStudent(studentOpt.get(), request);

        Student saved = studentRepository.save(student);
        return Convert.buildResponse(true, StudentDTO.builder().firstName(saved.getFirstName())
                .lastName(saved.getLastName())
                .address(saved.getAddress())
                .dob(DateUtil.converString(saved.getDateOfBirth()))
                .gender(saved.getGender())
                .phoneNumber(saved.getPhoneNumber())
                .studentId(String.valueOf(saved.getId()))
                .build());
    }

    private Student mapToStudent(Student student, StudentVO request) {
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAddress(request.getAddress());
        student.setEmail(request.getEmail());
        student.setDateOfBirth(LocalDate.parse(request.getDob()));
        student.setPhoneNumber(request.getPhoneNum());
        student.setGender(request.getGender());
        return student;
    }
}


