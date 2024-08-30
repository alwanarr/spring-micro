INSERT INTO teacher.teachers (teacher_id, first_name, last_name, date_of_birth, gender, address, phone_number, qualification) VALUES
('3c6e4d9e-02e4-4f8a-8c25-51c5a4ff994e', 'Agus', 'Suhartono', '1980-03-15', 'male', 'Jalan Merdeka', '081234567890', 'S1 Pendidikan Matematika'),
('7e0d41c6-89f5-44d9-9e7c-d8d1a659bdd8', 'Dewi', 'Sulastri', '1985-07-25', 'female', 'Jalan Diponegoro', '081987654321', 'S2 Pendidikan Bahasa Inggris');

INSERT INTO classes.class_schedules (class_id, subject, schedule_date, teacher_id) VALUES
('c64c30f6-2ccb-4529-802d-2bde2b90484d', 'Matematika', '2024-09-01', '3c6e4d9e-02e4-4f8a-8c25-51c5a4ff994e'),
('ee4a98eb-40e0-403b-821e-6cbe57959f17', 'Bahasa Inggris', '2024-09-02', '7e0d41c6-89f5-44d9-9e7c-d8d1a659bdd8');



INSERT INTO classes.classes ( id, name, academic_year) VALUES
( 'c64c30f6-2ccb-4529-802d-2bde2b90484d', 'Kelas 1A', '2024-2025'),
( 'ee4a98eb-40e0-403b-821e-6cbe57959f17', 'Kelas 2B', '2024-2025');

INSERT INTO student.students (
    id, 
    first_name, 
    last_name, 
    date_of_birth, 
    gender, 
    address, 
    email, 
    phone_number
) 
VALUES (
    '71eec4af-2fe6-44a4-9fca-c59b4967c89d',            
    'John',                        
    'Doe',                         
    '2000-01-01',                  
    'Male',                        
    '123 Main St, Anytown, USA',   
    'john.doe@example.com',        
    '1234567890'                   
);

INSERT INTO att.attendance_records (
    student_id, 
    class_id, 
    attendance_date, 
    status, 
    remarks
) VALUES (
    '71eec4af-2fe6-44a4-9fca-c59b4967c89d',  
    'c64c30f6-2ccb-4529-802d-2bde2b90484d',  
    '2024-08-29',                            
    'Present',                               
    'No remarks'                             
);