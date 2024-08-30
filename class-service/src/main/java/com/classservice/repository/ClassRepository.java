package com.classservice.repository;

import com.classservice.entity.Classes;
import com.classservice.model.ScheduleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ClassRepository extends JpaRepository<Classes, UUID> {
    @Query(nativeQuery = true, value = "select c.\"name\", a.schedule_date , a.start_time , a.end_time  from classes.class_schedules a inner join classes.classes c on a.class_id  = c.id where a.schedule_date = :scheduleDate;\n")
    List<ScheduleProjection> findSchedulesByDate(@Param("scheduleDate") LocalDate scheduleDate);

}
