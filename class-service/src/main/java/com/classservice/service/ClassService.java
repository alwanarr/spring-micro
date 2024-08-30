package com.classservice.service;

import com.classservice.model.response.ResponseDTO;
import com.classservice.vo.response.request.ClassScheduleVO;
import com.classservice.vo.response.request.ClassVO;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ClassService {

    ResponseDTO teacherScedule(String teacherId, LocalDate scheduleDate);
    ResponseDTO saveScedule(ClassScheduleVO request);
    ResponseDTO save(ClassVO request);
    ResponseDTO update(ClassVO request, String id);
    ResponseDTO delete(String id);
    ResponseDTO getClass(Pageable pageable);
    ResponseDTO getClassById(String classId);
}
