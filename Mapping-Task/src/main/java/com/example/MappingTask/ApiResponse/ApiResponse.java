package com.example.MappingTask.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ApiResponse {
    private  Object data;
    private  String message;
    private  Object status;
}
