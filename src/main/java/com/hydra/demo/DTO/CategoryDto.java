package com.hydra.demo.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {


    private Long id;

    @NotNull
    private String title;
    @NotNull
    private String description;
}
