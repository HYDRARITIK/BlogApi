package com.hydra.demo.DTO;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private  String password;
}
