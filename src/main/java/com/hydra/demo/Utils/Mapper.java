package com.hydra.demo.Utils;

import com.hydra.demo.DTO.UserDto;
import com.hydra.demo.document.User;

public class Mapper {


   public UserDto userEntityToDto(User user){
        UserDto user_dto=new UserDto();
        user_dto.setId(user.getId());
       user_dto.setName(user.getName());
       user_dto.setEmail(user.getEmail());
       user_dto.setPassword(user.getPassword());


        return user_dto;

    }

    public User DtoToUserEntity(User user){
        UserDto user_dto=new UserDto();
        user_dto.setId(user.getId());
        user_dto.setName(user.getName());
        user_dto.setEmail(user.getEmail());
        user_dto.setPassword(user.getPassword());


        return null;

    }



}
