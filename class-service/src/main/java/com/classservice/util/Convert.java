package com.classservice.util;


import com.classservice.model.response.ResponseDTO;

public class Convert {
    public static ResponseDTO buildResponse(boolean success, Object data) {
        return ResponseDTO.builder()
                .isSuccess(success)
                .payload(data)
                .build();
    }

}
