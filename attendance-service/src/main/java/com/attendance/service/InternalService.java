package com.attendance.service;

import com.attendance.config.StudentAPI;
import com.attendance.model.response.ClassDTO;
import com.attendance.model.response.StudentResDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class InternalService {

    private final RestTemplate restTemplate;

    private final StudentAPI studentAPI;
//    private final String urlTeacher;

    public InternalService(RestTemplate restTemplate, StudentAPI studentAPI
//                           @Value("${internal.api.teacher.url}") String url
    ) {
        this.restTemplate = restTemplate;
        this.studentAPI = studentAPI;
    }

    public StudentResDTO getStudent(String studentId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<StudentResDTO> student = restTemplate
                .exchange(studentAPI.getBase() + studentId,
                        HttpMethod.GET,
                        entity,
                        StudentResDTO.class);

        if(!student.getBody().isSuccess()) {
            throw new RuntimeException("Student Not Found");
        }
        return student.getBody();
    }

    public ClassDTO getClassName(String classId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<ClassDTO> res = restTemplate
                .exchange(studentAPI.getClassUrl() + classId,
                        HttpMethod.GET,
                        entity,
                        ClassDTO.class);

        if(!res.getBody().isSuccess()) {
            throw new RuntimeException("Class Not Found");
        }
        return res.getBody();
    }
}
