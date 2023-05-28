package com.example.MappingTask.Implements;

import com.example.MappingTask.ApiResponse.ApiResponse;
import com.example.MappingTask.DTO.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserIMPLE {
    ApiResponse addUser(UserDto userDto) throws Exception;

    ApiResponse login(UserDto userDto) throws Exception;

    ApiResponse getAll() throws Exception;

    ApiResponse deleteById(Long id) throws Exception;
}
