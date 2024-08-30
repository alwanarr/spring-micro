package com.classservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface ScheduleProjection {

    String getName();

    LocalDate getScheduleDate();

    LocalTime getStartTime();

    LocalTime getEndTime();

}
