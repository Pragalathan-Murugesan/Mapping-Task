package com.example.MappingTask.Controller;

import com.example.MappingTask.ApiResponse.ApiResponse;
import com.example.MappingTask.DTO.UserDto;
import com.example.MappingTask.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Valid
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/adduser")
    public ApiResponse addUser (@Valid @RequestBody UserDto userDto) throws Exception {
        return userService.addUser(userDto);
    }
    @PostMapping(value = "/login")
    public ApiResponse login (@RequestBody UserDto userDto) throws Exception {
        return userService.login(userDto);
    }
    @GetMapping(value = "/getall")
    public ApiResponse getAll() throws Exception {
        return userService.getAll();
    }
    @DeleteMapping(value = "/deletebyid/{id}")
    public ApiResponse deleteById(@PathVariable("id") Long id) throws Exception {
        return userService.deleteById(id);
    }
}
