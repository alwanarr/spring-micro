package com.teacher.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher_schedules")
@Entity
public class TeacherSchedule implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "teacher_id", nullable = false)
    private UUID teacherId;

    @Column(name = "class_id")
    private UUID classId;

    @Column(name = "subject", length = 100)
    private String subject;

    @Column(name = "schedule_date")
    private LocalDate scheduleDate;
}
