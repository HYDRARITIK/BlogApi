package com.hydra.demo.Controllers;

import com.hydra.demo.DTO.CategoryDto;
import com.hydra.demo.Services.CategoryServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryServ catServ;

   
    @GetMapping("")
    public ResponseEntity<?> GetAll(){
        List<CategoryDto> udt=catServ.GetAllCategory();
        return new ResponseEntity<>(udt, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> CreateCategory(@RequestBody CategoryDto Category){
        CategoryDto udt=catServ.createCategory(Category);
        return new ResponseEntity<>(udt, HttpStatus.OK);
    }

   


}
