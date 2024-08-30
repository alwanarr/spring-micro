package com.studentservice.util;

import com.studentservice.model.response.ResponseDTO;

public class Convert {

    public static ResponseDTO buildResponse(boolean success, Object data) {
        return ResponseDTO.builder()
                .success(success)
                .payload(data)
                .build();
    }

}
