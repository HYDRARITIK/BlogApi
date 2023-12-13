package com.hydra.demo.Controllers;


import com.hydra.demo.DTO.ApiErrorResponse;
import com.hydra.demo.DTO.UserDto;
import com.hydra.demo.Services.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    private UserServ userServ;

    @GetMapping("/{id}")
    public ResponseEntity<?> GetUserById(@PathVariable("id") Integer id){
        UserDto udt=userServ.getUserById(id);
        return new ResponseEntity<>(udt, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<?> GetAll(){
        List<UserDto> udt=userServ.GetAllUser();
        return new ResponseEntity<>(udt, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> CreateUser(@RequestBody  UserDto user){
        UserDto udt=userServ.createUser(user);
        return new ResponseEntity<>(udt, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateUser(@RequestBody  UserDto user,@PathVariable("id") Integer id){

        return new ResponseEntity<>(userServ.UpdateUser(user,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  DeleteUser(@PathVariable("id") Integer id){
        UserDto updatedUser=userServ.deleteUser(id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }



}




