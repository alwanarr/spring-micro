package com.teacher.controller;

import com.teacher.service.TeacherService;
import com.teacher.vo.request.TeacherVO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("")
    public ResponseEntity teachers(@RequestParam(name = "firstName", required = false, defaultValue = "") String firstName,
                                   Pageable pageable) {
        return new ResponseEntity(teacherService.teachers(firstName, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTeacher(@PathVariable String id) {
        return new ResponseEntity(teacherService.getTeacher(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody TeacherVO req) {
        return new ResponseEntity(teacherService.saveTeacher(req), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return new ResponseEntity(teacherService.deleteTeacher(id), HttpStatus.OK);
    }
}
