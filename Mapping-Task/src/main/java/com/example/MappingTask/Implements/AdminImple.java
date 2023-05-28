package com.example.MappingTask.Implements;

import com.example.MappingTask.ApiResponse.ApiResponse;
import com.example.MappingTask.DTO.AdminDto;
import com.example.MappingTask.DTO.AdminProfileDto;
import com.example.MappingTask.DTO.Comman;
import com.example.MappingTask.Entity.AdminEntity;

public interface AdminImple {
    ApiResponse add(Comman comman) throws Exception;

    ApiResponse get() throws Exception;

    ApiResponse deleteId(Long id) throws Exception;

    ApiResponse updatAll(Comman comman ) throws Exception;
}
