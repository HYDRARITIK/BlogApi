package com.hydra.demo.DTO;

import com.hydra.demo.document.Category;
import com.hydra.demo.document.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {


    private long id;
    @NotNull
    private String title;
    @NotNull
    private String content;

    private String imageName;


    private CategoryDto category;

    private UserDto user;

}
