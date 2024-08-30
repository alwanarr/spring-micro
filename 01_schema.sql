
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE SCHEMA IF NOT EXISTS student;
CREATE SCHEMA IF NOT EXISTS teacher;
CREATE SCHEMA IF NOT EXISTS att;
CREATE SCHEMA IF NOT EXISTS classes;



CREATE TABLE teacher.teachers (
    teacher_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    gender VARCHAR(10),
    address VARCHAR(255),
    phone_number VARCHAR(20),
    qualification VARCHAR(100)
);

CREATE TABLE student.students (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(10),
    address TEXT,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE classes.classes (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) NOT NULL,
    academic_year VARCHAR(15)
);

CREATE TABLE att.attendance_records (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    student_id UUID  ,
    class_id UUID ,
    attendance_date DATE NOT NULL,
    status VARCHAR(20),
    remarks TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE classes.class_schedules (
    schedule_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    class_id UUID ,
    subject VARCHAR(100) ,
    schedule_date DATE ,
    start_time TIME ,
    end_time TIME ,
    teacher_id UUID 
);