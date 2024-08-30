package com.classservice.repository;

import com.classservice.entity.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, UUID> {
}
