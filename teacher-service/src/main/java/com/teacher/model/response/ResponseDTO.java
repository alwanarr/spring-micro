package com.teacher.model.response;

import com.teacher.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResponseDTO {
    private boolean isSuccess;
    private Object payload;
}
