package com.teacher.service.impl;

import com.teacher.entity.Teacher;
import com.teacher.model.response.ResponseDTO;
import com.teacher.repository.TeacherRepository;
import com.teacher.service.TeacherService;
import com.teacher.util.Convert;
import com.teacher.util.DateUtil;
import com.teacher.vo.request.TeacherVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public ResponseDTO teachers(String firstName, Pageable pageable) {
        Page<Teacher> data;
        log.info("firstname : {}", firstName);
        if ( firstName.equals("")) {

            data = teacherRepository.findAll(pageable);
        } else  {
           data = teacherRepository.findByFirstNameContaining(firstName, pageable);
        }
        return Convert.buildResponse(true, data);
    }

    @Override
    public ResponseDTO getTeacher(String id) {
        Optional<Teacher> data = teacherRepository.findById(UUID.fromString(id));

        if (data.isEmpty()) {
            log.info("data teacher : isEmpty");
            return Convert.buildResponse(false, null);
        }
        log.info("data teacher : {}", data.get().getFirstName());
        return Convert.buildResponse(true, data.get());
    }

    @Override
    public ResponseDTO saveTeacher(TeacherVO req) {
        Teacher teacher = Teacher.builder()
                .address(req.getAddress())
                .gender(req.getGender())
                .lastName(req.getLastName())
                .firstName(req.getFirstName())
                .phoneNumber(req.getPhoneNumber())
                .qualification(req.getQualification())
                .dateOfBirth(LocalDate.parse(req.getDob()))
                .build();
        try {
            Teacher save = teacherRepository.save(teacher);
            return Convert.buildResponse(true, save);
        } catch (DataIntegrityViolationException e) {
            return Convert.buildResponse(false, null);
        }
    }

    @Override
    public ResponseDTO updateTeacher(TeacherVO req, String id) {
        Optional<Teacher> data = teacherRepository.findById(UUID.fromString(id));
        if (data.isEmpty()) {
            return Convert.buildResponse(false, null);
        }
        Teacher teacher = data.get();
        teacher.setAddress(req.getAddress());
        teacher.setGender(req.getGender());
        teacher.setLastName(req.getLastName());
        teacher.setFirstName(req.getFirstName());
        teacher.setPhoneNumber(req.getPhoneNumber());
        teacher.setQualification(req.getQualification());
        try {
            Teacher save = teacherRepository.save(teacher);
            return Convert.buildResponse(true, save);
        } catch (DataIntegrityViolationException e) {
            return Convert.buildResponse(false, null);
        }
    }

    @Override
    public ResponseDTO deleteTeacher(String id) {
        teacherRepository.deleteById(UUID.fromString(id));
        return Convert.buildResponse(true, null);
    }
}
