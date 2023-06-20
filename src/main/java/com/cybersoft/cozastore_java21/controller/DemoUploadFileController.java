package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.exception.CustomFileNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/demo")
public class DemoUploadFileController {

    @Value("${path.root}")
    private String spath;
    @PostMapping("/uploadfile")
    public ResponseEntity<?> uploadFile(@RequestParam MultipartFile file) throws IOException {

        // Path : chua ham ho tro san lien quan toi duong dan
        //B1: bien duong dan kieu String qua kieu Path with Paths
        Path rootPath = Paths.get(spath);
        // B2 Check path exist? if path not exist, create it.
//        file.getOriginalFilename() : lay ten file va dinh dang

       try {
           if(!Files.exists(rootPath)) {
               Files.createDirectories(rootPath);
           }
               //  StandardCopyOption.REPLACE_EXISTING : xu li ten file bi trung
               Files.copy(file.getInputStream(),rootPath.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING); // resolve = "/"

       }catch (Exception e){
           System.out.println("Error create Directories");
           e.getMessage();
       }
        return new ResponseEntity<>("", HttpStatus.OK);
    }
    @GetMapping("/{filename}")
    public ResponseEntity<?> loadFile(@PathVariable String filename) throws MalformedURLException {
       try {
           Path pathRoot = Paths.get(spath);
           Resource resource = new UrlResource(pathRoot.resolve(filename).toUri());
           if(resource.exists()){
               // neu resource ton tai thi moi cho phep download
               return ResponseEntity.ok()
                       .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

           }else {
               // khi nem exception thi code se dung va tra ra loi
               throw new CustomFileNotFoundException(200,"File Not Fond");
           }

       }catch (Exception e){
           throw new CustomFileNotFoundException(200,"FileNotFound");
       }

    }
}
