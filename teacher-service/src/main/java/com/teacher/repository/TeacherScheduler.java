package com.teacher.repository;

import com.teacher.entity.TeacherSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeacherScheduler extends JpaRepository<TeacherSchedule, UUID> {
}
