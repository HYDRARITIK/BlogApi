package com.hydra.demo.Services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydra.demo.DTO.UserDto;
import com.hydra.demo.Exception.ApplicationException;
import com.hydra.demo.IRepository.IUserRepo;
import com.hydra.demo.document.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServ {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserRepo iuserRepo;


    public UserDto getUserById(Integer userId){
       User us=iuserRepo.findById(userId).orElseThrow(
               ()->new ApplicationException("123","userNotFOund",HttpStatus.NOT_FOUND));


        return this.modelMapper.map(us, UserDto.class);

    }

  

    public UserDto  createUser(UserDto userdto){
        User ToBeSaved=this.modelMapper.map(userdto,User.class);
       User savedUser =iuserRepo.save(ToBeSaved);
       UserDto Back=this.modelMapper.map(savedUser, UserDto.class);
       return Back;
    }
    public UserDto  UpdateUser(UserDto userdto,Integer userId){

        User user=iuserRepo.findById(userId).orElseThrow
                (()-> new ApplicationException("104","userNotFound",HttpStatus.CONFLICT));

        user.setEmail(userdto.getEmail());
        user.setFirstname(userdto.getName());

        User saved=iuserRepo.save(user);
        return this.modelMapper.map(saved, UserDto.class);

    }

    public UserDto deleteUser(Integer userId){
        User user=iuserRepo.findById(userId).orElseThrow
                (()-> new ApplicationException("104","userNotFound",HttpStatus.CONFLICT));

        iuserRepo.delete(user);

        return this.modelMapper.map(user, UserDto.class);

    }
    public List<UserDto> GetAllUser(){
        List<User> ui=iuserRepo.findAll();
        List<UserDto> udt= ui.stream().map((curr_user)->{
            return this.modelMapper.map(curr_user, UserDto.class);
        }).toList();

        return udt;

    }
//    mapper



}
