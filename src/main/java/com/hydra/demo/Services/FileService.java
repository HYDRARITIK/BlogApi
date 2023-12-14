package com.hydra.demo.Services;


import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.stream.Stream;

import com.hydra.demo.Exception.ApplicationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    //upload image

    public String UploadImage(String Path, MultipartFile file){
        return null;
    }
    // to get image and return to user
    InputStream getResource(String Path, String FileName){
        return null;
    }



    private final String uploadsDir = "C:\\Users\\surjr\\OneDrive\\Desktop\\December2023\\demo\\demo\\src\\main\\java\\com\\hydra\\demo\\Services\\uploads\\";


    @Autowired
    private HttpServletRequest request;
//   upload file
    public String save(MultipartFile file) {
        try {



            String orgName = file.getOriginalFilename();
            String filePath = uploadsDir + orgName;
            File dest = new File(filePath);
            file.transferTo(dest);

            return orgName;

        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }

            throw new RuntimeException(e.getMessage());
        }
    }


//   to return image with particular file name
    public Resource load(String filename) throws FileNotFoundException,MalformedURLException {

//            Path filePath = Paths.get(uploadsDir , filename);

//            Resource resource = new UrlResource(filePath.toUri());

            String filePath=uploadsDir+File.separator+filename;
            Path pathFile=Paths.get(filePath);
            System.out.println("path-------->"+pathFile);
        Resource resourcess = new UrlResource(pathFile.toUri());
        System.out.println("resourcess-------->"+resourcess);
            InputStream resource = new FileInputStream(filePath);
            return resourcess;


//            if (resource.exists() || resource.isReadable()) {
//                return resource;

    }


//    to delete all images
    public void deleteAll() {
//        FileSystemUtils.deleteRecursively(root.toFile());
    }






}
