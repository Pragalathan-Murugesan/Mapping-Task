package com.example.MappingTask.Controller;

import com.example.MappingTask.ApiResponse.ApiResponse;
import com.example.MappingTask.DTO.Comman;
import com.example.MappingTask.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminapi")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/adduser")
    public ApiResponse add (@RequestBody Comman comman) throws Exception {
        return adminService.add(comman);
    }
    @GetMapping(value = "/getall")
    public ApiResponse get() throws Exception {
        return adminService.get();
    }

    @DeleteMapping(value = "/deletebyid/{id}")
    public ApiResponse deleteId(@PathVariable("id") Long id) throws Exception {
        return adminService.deleteId(id);
    }

    @PutMapping(value = "/updateall")
    public ApiResponse updateAll(@RequestBody Comman comman) throws Exception {
        return adminService.updatAll(comman);
    }
}
