package com.hydra.demo.Controllers;

import com.hydra.demo.DTO.PostDto;

import com.hydra.demo.Services.FileService;
import com.hydra.demo.Services.PostServ;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostServ postServ;

    @Autowired
    private FileService fileServ;

    @PostMapping("/user/{userId}/category/{categId}")
    public ResponseEntity<?> createPost(@RequestBody PostDto pdt, @PathVariable Integer userId, @PathVariable Integer categId){


       PostDto pdto=postServ.createPost(pdt,userId,categId);

        return new ResponseEntity<>(pdto, HttpStatus.OK);

    }

//    updatePost

    @PutMapping("")

    public ResponseEntity<?> updatePost(@RequestBody PostDto pdt,@PathVariable Integer postId){

        PostDto pdto=postServ.updatePost(pdt,postId);
        return new ResponseEntity<>(pdto, HttpStatus.OK);
    }


//    deletePost

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Integer postId){

       postServ.deletePost(postId);
//        return new ResponseEntity<>(pdto, HttpStatus.OK);

    }

//    getAllPost
//        baseurl/?pageNo=2?pageSize=3
    @GetMapping("")
    public ResponseEntity<?> getAllPost(@RequestParam(defaultValue = "0") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "title") String sortBy
    ){
        List<PostDto> pdto=postServ.getAllPost(pageSize,pageNo,sortBy);

        return new ResponseEntity<>(pdto, HttpStatus.OK);
    }

//    getPostById


    @GetMapping("/{PostId}")
    public ResponseEntity<?> getPostById(@PathVariable Integer PostId){
        PostDto pdto=postServ.getPostById(PostId);
        return new ResponseEntity<>(pdto, HttpStatus.OK);
    }



    //    getPostsByCategory

    @GetMapping("/category/{categId}")
    public ResponseEntity<?> getPostsByCategory(@PathVariable Integer categId){
        List<PostDto> pdto=postServ.getPostsByCategory(categId);
        return new ResponseEntity<>(pdto, HttpStatus.OK);
    }



//    getPostByUser

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getPostsByUser(@PathVariable Integer userId){
        List<PostDto> pdto=postServ.getPostsByUser(userId);
        return new ResponseEntity<>(pdto, HttpStatus.OK);
    }



//upload images
    @PostMapping("/images/upload")
    public ResponseEntity<?>  uploadImage(@RequestBody MultipartFile file) {

        return new ResponseEntity<String>(fileServ.save(file),HttpStatus.OK);
    }
//get image
    @GetMapping("/images/{filename}")
    public ResponseEntity<?> getImage(@PathVariable String filename) throws IOException {

        return new ResponseEntity<>(fileServ.load(filename).getURL(),HttpStatus.OK) ;
        // return image
    }

    @PostMapping("/single/upload")
    public ResponseEntity<String> fileUploading(@RequestParam("file") MultipartFile file) {
        // Code to save the file to a database or disk
        return ResponseEntity.ok("Successfully uploaded the file");
    }
    private final String uploadsDir = "C:\\Users\\surjr\\OneDrive\\Desktop\\December2023\\demo\\demo\\src\\main\\java\\com\\hydra\\demo\\Services\\uploads\\";

//    @GetMapping(value = "/images/{filename}" ,produces = MediaType.IMAGE_JPEG_VALUE)
//    public void getImg(@PathVariable String filename,
//                       HttpServletResponse response
//    ) throws IOException {
//
//        Resource resource =this.fileServ.load(filename);
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        StreamUtils.copy(resource,response.getOutputStream());
//
//    }


}
