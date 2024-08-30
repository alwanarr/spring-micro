package com.classservice.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TeacherResDTO {
    private TeacherRes payload;
    private boolean success;
}
