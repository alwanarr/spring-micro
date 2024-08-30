package com.studentservice.service;

import com.studentservice.model.response.ResponseDTO;
import com.studentservice.vo.request.StudentVO;

public interface StudentService {
    ResponseDTO getUsers();
    ResponseDTO saveUser(StudentVO request);
    ResponseDTO getUser(String userId);
    ResponseDTO updateUser(StudentVO request, String userId);

}
