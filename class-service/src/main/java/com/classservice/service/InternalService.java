package com.classservice.service;

import com.classservice.model.response.TeacherResDTO;
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

    private final String urlTeacher;

    public InternalService(RestTemplate restTemplate,
                           @Value("${internal.api.teacher.url}") String url) {
        this.restTemplate = restTemplate;
        this.urlTeacher = url;
    }

    public TeacherResDTO getTeacher(String teacherId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        log.info("url : {}", urlTeacher.concat(teacherId));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<TeacherResDTO> teacher = restTemplate.exchange(urlTeacher.concat(teacherId), HttpMethod.GET, entity, TeacherResDTO.class);
        if (!teacher.getBody().isSuccess()) throw new RuntimeException("Teacher not found");
        return teacher.getBody();
    }
}
