package com.example.MappingTask.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDto {
    private  Long id;
    @NotNull(message = "name is required")
    @NotEmpty(message = " name is missing")
    private String name;
    @NotNull(message = "Email is required")
    @NotEmpty(message = " email is missing")
    private String emailId;

}

