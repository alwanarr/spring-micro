package com.teacher.service;

import com.teacher.entity.Teacher;
import com.teacher.model.response.ResponseDTO;
import com.teacher.vo.request.TeacherVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherService {

    ResponseDTO teachers(String firstName, Pageable pageable);

    ResponseDTO getTeacher(String id);

    ResponseDTO saveTeacher(TeacherVO req);
    ResponseDTO updateTeacher(TeacherVO req, String id);
    ResponseDTO deleteTeacher(String id);



}
