package com.sha.springboottaxapplication.controller;

import com.sha.springboottaxapplication.model.File;
import com.sha.springboottaxapplication.model.User;
import com.sha.springboottaxapplication.repository.FileDBRepository;
import com.sha.springboottaxapplication.repository.UserRepository;
import com.sha.springboottaxapplication.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:8080")
public class FilesController {

    @Autowired(required = false)
    FilesStorageService storageService;

    @Autowired
    FileDBRepository fileDBRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/addfile")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile []file1 , @RequestParam String formmsg, HttpServletRequest request) {
        MultipartFile file = null;
        String message = "Successfully";

        System.out.println(formmsg);
        System.out.println(request.getUserPrincipal().getName());

        Optional<User> user = userRepository.findByUsername(request.getUserPrincipal().getName());
        System.out.println(user.get().getId());



        for (int i = 0 ; i <file1.length; i++){

            if (!file1[i].isEmpty())
            try {
                file = file1[i];

                try{
                    storageService.save(file);
                }catch (Exception e){

                }

                System.out.println(file.getOriginalFilename());
//                System.out.println(messages); ,@RequestParam String messages

                File info = new File();
                info.setName(file.getOriginalFilename());


                info.setUrl("E:/Tax/Tax-Frontend-ll/Documents/" + file.getOriginalFilename());
                info.setData(file.getBytes());
                info.setMessage(formmsg);
                info.setUser_id(String.valueOf(user.get().getId()));
                fileDBRepository.save(info);
                System.out.println(user.get().getId());

                String msg = "Uploaded the file successfully: " + file.getOriginalFilename();
//                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(msg));
            } catch (Exception e) {
                System.out.println(e);
                message = "Something Went Wrong";
                //message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                //return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(msg);
                String msg = "Uploaded the file successfully: " + file.getOriginalFilename();
//                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(msg));
            }

        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @GetMapping("/files")
    public List<File> getListFiles() {
        return  fileDBRepository.findAll();
    }


    @GetMapping("/file/{userId}")
    public List<File> getFileByid(@PathVariable String userId){
            return fileDBRepository.findByFileID(userId);
    }


}
