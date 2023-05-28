package com.example.MappingTask.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminProfileDto {

    private Long ida;
    @NotNull(message = "location is required")
    private String location;
    private String city;
    private  Long userId;
}
