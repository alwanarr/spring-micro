package com.attendance.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Builder
public class ClassDTO implements Serializable {
    private boolean success;
    private ClassResDTO payload;
}
