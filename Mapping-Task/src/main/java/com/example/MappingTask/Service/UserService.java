package com.example.MappingTask.Service;

import com.example.MappingTask.ApiResponse.ApiResponse;
import com.example.MappingTask.DTO.UserDto;
import com.example.MappingTask.Entity.UserEntity;
import com.example.MappingTask.Implements.UserIMPLE;
import com.example.MappingTask.JWTTokens.GenerateTokens;
import com.example.MappingTask.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService implements UserIMPLE {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private  ApiResponse apiResponse;
    @Autowired
    private GenerateTokens generateTokens;


    @Override
    public ApiResponse addUser(UserDto userDto) throws Exception {
        try {
            UserEntity add = new UserEntity();
            add.setUserName(userDto.getUserName());
            add.setEmailId(userDto.getEmailId());
            add.setPassword(userDto.getPassword());
            userRepo.save(add);
            apiResponse.setData(add);
            apiResponse.setMessage("User Added ");
            apiResponse.setStatus(HttpStatus.OK.value());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }


    @Override
    public ApiResponse login(UserDto userDto) throws Exception {
        try {
            UserEntity userEntity = userRepo.findOneByEmailIdIgnoreCaseAndPassword(userDto.getEmailId(), userDto.getPassword());
            if (userEntity != null) {
                apiResponse.setData(null);
                apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
                apiResponse.setMessage("Login Failed Please Enter Correct Required Data");
            }
            String token = generateTokens.generateToken(userEntity);
            HashMap<String, Object> data = new HashMap<>();
            data.put("Token", token);
            apiResponse.setData(data);
            apiResponse.setMessage("Login Successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse getAll() throws Exception {
        try {
           List<UserEntity> userEntity= userRepo.findAll();
            apiResponse.setStatus(HttpStatus.ACCEPTED.value());
            apiResponse.setData(userEntity);
            apiResponse.setMessage("Data Received");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse deleteById(Long id) throws Exception {
        try {
            userRepo.deleteById(id);
            apiResponse.setMessage("Id deleted successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setData(null);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return apiResponse;
    }
}
