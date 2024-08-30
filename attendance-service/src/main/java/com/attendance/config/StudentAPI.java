package com.attendance.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "internal-api.student")
@Getter
@Setter
public class StudentAPI {
    @Value("${internal-api.student.base}")
    private String base;

    @Value("${internal-api.classApi.url}")
    private String classUrl;
}
