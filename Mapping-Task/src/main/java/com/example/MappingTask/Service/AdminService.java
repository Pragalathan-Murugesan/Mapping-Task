package com.example.MappingTask.Service;

import com.example.MappingTask.ApiResponse.ApiResponse;
import com.example.MappingTask.DTO.Comman;
import com.example.MappingTask.Entity.AdminEntity;
import com.example.MappingTask.Entity.AdminProfileEntity;
import com.example.MappingTask.Implements.AdminImple;
import com.example.MappingTask.Repository.AdminProfile;
import com.example.MappingTask.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService implements AdminImple {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private AdminProfile adminProfile;
    @Autowired
    private ApiResponse apiResponse;
    public ApiResponse add(Comman comman) throws Exception {
        try {
            AdminEntity adminEntity = new AdminEntity();
            AdminProfileEntity adminProfileEntity = new AdminProfileEntity();
            adminProfileEntity.setAdminEntity(adminEntity);
            adminEntity.setAdminProfileEntity(adminProfileEntity);
            adminProfile.save(adminProfileEntity);
            adminRepo.save(adminEntity);

//            AdminProfileEntity adminProfileEntity = new AdminProfileEntity();
//            adminProfileEntity.setAdminEntity(adminEntity);
//            adminProfile.save(adminProfileEntity);
//            adminRepo.save(adminEntity);

//            AdminProfileEntity adminProfileEntity = new AdminProfileEntity();
//            adminProfileEntity.setUserId(adminEntity.getId());
//            adminProfileEntity.setLocation(comman.getLocation());
//            adminProfileEntity.setCity(comman.getCity());
//            adminProfile.save(adminProfileEntity);

            apiResponse.setData(adminEntity);
            apiResponse.setMessage("User Added ");
            apiResponse.setStatus(HttpStatus.OK.value());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse get() throws Exception {
        try {
            List<AdminEntity> getData1 = adminRepo.findAll();
            apiResponse.setStatus(HttpStatus.ACCEPTED.value());
            apiResponse.setData(getData1);
            apiResponse.setMessage("Data Received");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse deleteId(Long id) throws Exception {
        try {
            adminProfile.deleteById(id);
            apiResponse.setMessage("Id deleted successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setData(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }
    public ApiResponse updatAll(Comman comman) throws Exception {
        try {
           AdminEntity update1 = adminRepo.updatEmailId(comman.getName());
            update1.setEmailId(comman.getEmailId());
             adminRepo.save(update1);

            AdminProfileEntity adminProfileEntity = adminProfile.updateColumns(comman.getUserId());
            adminProfileEntity.setCity(comman.getCity());
            adminProfileEntity.setLocation(comman.getLocation());
            adminProfile.save(adminProfileEntity);

            apiResponse.setMessage("updated Successfully");
            apiResponse.setData(update1);
            apiResponse.setStatus(HttpStatus.OK.value());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }
}