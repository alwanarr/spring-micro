package com.studentservice.controller;

import com.studentservice.service.StudentService;
import com.studentservice.vo.request.StudentVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity getUsers() {
        return new ResponseEntity(studentService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity saveUser(@RequestBody StudentVO req) {
        return new ResponseEntity(studentService.saveUser(req), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUsers(@PathVariable("userId") String userId) {
        var res = studentService.getUser(userId);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity update(@PathVariable("userId") String userId, @RequestBody StudentVO req) {
        var res = studentService.updateUser(req, userId);
        HttpStatus httpStatus = res.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity(res, httpStatus);
    }
}
