package com.teacher.util;

import com.teacher.entity.Teacher;
import com.teacher.model.response.ResponseDTO;

public class Convert {
    public static ResponseDTO buildResponse(boolean success, Object data) {
        return ResponseDTO.builder()
                .isSuccess(success)
                .payload(data)
                .build();
    }

}
