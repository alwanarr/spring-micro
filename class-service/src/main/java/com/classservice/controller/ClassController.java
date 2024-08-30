package com.classservice.controller;

import com.classservice.service.ClassService;
import com.classservice.vo.response.request.ClassScheduleVO;
import com.classservice.vo.response.request.ClassVO;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("")
    public ResponseEntity getClasses(Pageable pageable) {
        return new ResponseEntity(classService.getClass(pageable), HttpStatus.OK);
    }

    @GetMapping("/{classId}")
    public ResponseEntity getClassById(@PathVariable String classId) {
        return new ResponseEntity(classService.getClassById(classId), HttpStatus.OK);
    }

    @GetMapping("/{teacherId}/schedule")
    public ResponseEntity getClassOfTeacher(@PathVariable(value = "teacherId") String teacherId,
                                            @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return new ResponseEntity(classService.teacherScedule(teacherId, date), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity saveSchedule(@RequestBody ClassScheduleVO request) {
        return new ResponseEntity(classService.saveScedule(request), HttpStatus.OK);
    }

    @PostMapping("/save-class")
    public ResponseEntity saveClass(@RequestBody ClassVO request) {
        return new ResponseEntity(classService.save(request), HttpStatus.OK);
    }

    @PutMapping("/update-class/{id}")
    public ResponseEntity saveClass(@RequestBody ClassVO request, @PathVariable String id) {
        return new ResponseEntity(classService.update(request, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete-class/{id}")
    public ResponseEntity deleteClass(@PathVariable String id) {
        return new ResponseEntity(classService.delete(id), HttpStatus.OK);
    }
}
