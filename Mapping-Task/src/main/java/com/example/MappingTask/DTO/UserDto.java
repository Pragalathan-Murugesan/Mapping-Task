package com.example.MappingTask.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Long id;
    @NotNull(message = "UserName is Missing")
    @NotEmpty(message = "UserName is Required")
    private String userName;

    @NotNull(message = "EmailId  is Missing")
    @NotEmpty(message = "EmailId Is Required")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private  String emailId;

    @NotNull(message = "Password  is Missing")
    @NotEmpty(message = "Password Is Required")
    private  String password;


}
