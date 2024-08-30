package com.classservice.service.impl;

import com.classservice.entity.ClassSchedule;
import com.classservice.entity.Classes;
import com.classservice.model.ScheduleProjection;
import com.classservice.model.response.ResponseDTO;
import com.classservice.model.response.TeacherResDTO;
import com.classservice.repository.ClassRepository;
import com.classservice.repository.ClassScheduleRepository;
import com.classservice.service.ClassService;
import com.classservice.service.InternalService;
import com.classservice.util.Convert;
import com.classservice.vo.response.TeacherScheduleVO;
import com.classservice.vo.response.request.ClassScheduleVO;
import com.classservice.vo.response.request.ClassVO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClassServiceImpl implements ClassService {

    private final InternalService internalService;
    private final ClassRepository repository;
    private final ClassScheduleRepository classScheduleRepository;



    public ClassServiceImpl(InternalService internalService, ClassRepository repository, ClassScheduleRepository classScheduleRepository) {
        this.internalService = internalService;
        this.repository = repository;
        this.classScheduleRepository = classScheduleRepository;
    }

    @Override
    public ResponseDTO teacherScedule(String teacherId, LocalDate scheduleDate) {
        TeacherResDTO teacher = internalService.getTeacher(teacherId);
        String firstName = teacher.getPayload().getFirstName();
        String lastName = teacher.getPayload().getLastName();
        String fullName = firstName + " " + lastName;
        List<ScheduleProjection> schedulesByDate = repository.findSchedulesByDate(scheduleDate);

        return Convert.buildResponse(true, TeacherScheduleVO.builder()
                .teacherName(fullName)
                .schedule(schedulesByDate).build());
    }

    @Override
    public ResponseDTO saveScedule(ClassScheduleVO request) {
        Optional<Classes> classOpt = repository.findById(request.getClassId());
        if (classOpt.isEmpty()) {
            throw new RuntimeException("Class not found");
        }

        var teacher= internalService
                .getTeacher(String.valueOf(request.getTeacherId()));


        ClassSchedule data = ClassSchedule.builder()
                .classId(request.getClassId())
                .endTime(request.getEndTime())
                .subject(request.getSubject())
                .startTime(request.getStartTime())
                .scheduleDate(request.getScheduleDate())
                .teacherId(request.getTeacherId())
                .build();
        return Convert.buildResponse(true, classScheduleRepository.save(data));
    }

    @Override
    public ResponseDTO save(ClassVO request) {
        Classes data = Classes.builder().academicYear(request.getAcademicYear())
                .name(request.getName()).build();
        Classes save = repository.save(data);
        return Convert.buildResponse(true, data);
    }

    @Override
    public ResponseDTO update(ClassVO request, String id) {
        Optional<Classes> classesOptional = repository.findById(UUID.fromString(id));
        if (classesOptional.isEmpty()) throw new RuntimeException("Class not found");
        Classes classes = classesOptional.get();
        classes.setName(request.getName());
        classes.setAcademicYear(request.getAcademicYear());
        Classes save = repository.save(classes);
        return Convert.buildResponse(true, save);
    }

    @Override
    public ResponseDTO delete(String id) {
        try {
            repository.deleteById(UUID.fromString(id));
            return Convert.buildResponse(true, null);
        } catch (EmptyResultDataAccessException e) {
            return Convert.buildResponse(false, "ID not found");
        }

    }

    @Override
    public ResponseDTO getClass( Pageable pageable) {
        Page<Classes> all = repository.findAll(pageable);
        return Convert.buildResponse(true, all);
    }

    @Override
    public ResponseDTO getClassById(String classId) {
        Optional<Classes> clsOpt = repository.findById(UUID.fromString(classId));
        if (clsOpt.isEmpty()) {
            Convert.buildResponse(false, clsOpt.get());
        }
        return Convert.buildResponse(true, clsOpt.get());
    }
}
