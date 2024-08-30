package com.classservice.vo.response;

import com.classservice.model.ScheduleProjection;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherScheduleVO {
    private String teacherName;
    private List<ScheduleProjection> schedule;
}
